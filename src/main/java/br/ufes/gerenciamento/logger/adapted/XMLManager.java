package br.ufes.gerenciamento.logger.adapted;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLManager {
    private File file;
    public XMLManager(String nomeArquivo) {
        file = new File(nomeArquivo);
    }

    public void write(String message) {
        FileWriter fw;
        try {
            fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("<log>" + message + "</log>");
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
    }
    public List<String> getMessages() {
        List<String> messages = new ArrayList<>();
        FileReader fr;
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linha = br.readLine();
            while(linha != null) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(new InputSource(new StringReader(linha)));
                messages.add(doc.getElementsByTagName("log").item(0).getTextContent());
                linha = br.readLine();
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
        return messages;
    }
}
