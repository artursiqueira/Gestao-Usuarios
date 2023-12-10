
package br.ufes.gerenciamento.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class Configuracoes {
    private final String CONFIG_PATH = "config.ini";
    
    public String getConfiguracao(String key) {
    
        File file = new File(CONFIG_PATH);
        Properties properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream(file);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
        
        return properties.getProperty(key);
        
    }
    
    public void defineConfiguracao(String key, String value) {
        
        File file = new File(CONFIG_PATH);
        Properties properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream(file);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
       
        properties.setProperty(key, value);
        
        try { 
            FileOutputStream fos = new FileOutputStream(file); 
            properties.store(fos, "ARQUIVO DE CONFIGURACOES"); 
            fos.close(); 
        } catch (IOException ex) {  
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage(), ex.getCause());
        }
 
    }
   
}

