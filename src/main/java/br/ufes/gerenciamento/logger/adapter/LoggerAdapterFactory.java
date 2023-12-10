package br.ufes.gerenciamento.logger.adapter;

public class LoggerAdapterFactory implements ILoggerAdapterFactory {
    @Override
    public LoggerAdapter cria(String formato) {
        switch(formato) {
            case "XML":
                return new LoggerXMLAdapter("log.xml");
            case "JSON":
                return new LoggerJSONAdapter("log.json");
            case "CSV":
                return new LoggerCSVAdapter("log.csv");
            default:
                throw new RuntimeException("Formato não suportado");
        }
    }
}
