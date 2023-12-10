package br.ufes.gerenciamento.logger.adapted;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONManager {
    private File file;
    public JSONManager(String nomeArq) {
        file = new File(nomeArq);
    }

    public void writeLog(String message) {
        try {
            FileWriter fw = new FileWriter(file, true);
            JSONObject log = new JSONObject();
            log.put("log", message);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(log.toJSONString());
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JSONManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
    }
    public List<String> getLogs() {
        List<String> logs = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linha = br.readLine();
            while(linha != null) {
                JSONObject jO = (JSONObject) new JSONParser().parse(linha);
                logs.add((String) jO.get("log"));
                linha = br.readLine();
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        } catch (IOException | ParseException ex) {
            Logger.getLogger(JSONManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
        return logs;
    }

}
