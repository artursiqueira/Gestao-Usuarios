package br.ufes.gerenciamento.logger.adapted;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVTool {
    private File file;
    public CSVTool(String nomeArquivo) {
        file = new File(nomeArquivo);
    }

    public void escreve(String mensagem) {
        FileWriter fw;
        try {
            fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(mensagem + ";");
            bw.close();
        } catch (IOException ex) {
            throw new RuntimeException("Falha ao escrever log", ex.getCause());
        }
    }
    public List<String> getMessages() {
        BufferedReader buffRead = null;
        List<String> messages = new ArrayList<>();
        try {
            buffRead = new BufferedReader(new FileReader(file.getPath()));
            String linha = buffRead.readLine();
            while(linha != null) {
                String[] mensagens = linha.split(";");
                messages.addAll(Arrays.asList(mensagens));
                linha = buffRead.readLine();
            }

            buffRead.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVTool.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } catch (IOException ex) {
            Logger.getLogger(CSVTool.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
        return messages;
    }
}
