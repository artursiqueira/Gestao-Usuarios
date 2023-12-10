package br.ufes.gerenciamento.logger.adapter;

import br.ufes.gerenciamento.logger.Log;
import br.ufes.gerenciamento.logger.adapted.CSVTool;

import java.util.List;

public class LoggerCSVAdapter extends LoggerAdapter {
    private final String nomeArquivo;
    private final CSVTool csvTool;

    LoggerCSVAdapter(String nomeArquivo) {
        if (!nomeArquivo.toLowerCase().endsWith("csv")) {
            throw new RuntimeException("Informe um arquivo CSV válido");
        }

        this.csvTool = new CSVTool(nomeArquivo);
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void grava(Log log) {
        csvTool.escreve(log.getMensagem());
    }
    @Override
    public List<String> getLogs() {
        return csvTool.getMessages();
    }
    @Override
    public void grava(String... log) {
        for(String message: log) {
            csvTool.escreve(message);
        }

    }
    @Override
    public String getNomeArquivo() {
        return this.nomeArquivo;
    }
}
