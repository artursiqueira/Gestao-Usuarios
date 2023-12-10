package br.ufes.gerenciamento.logger.adapter;

import br.ufes.gerenciamento.logger.Log;

import java.io.File;
import java.util.List;

public abstract class LoggerAdapter {
    public abstract void grava(Log log);
    public abstract void grava(String... log);
    public abstract String getNomeArquivo();
    public abstract List<String> getLogs();

    public final void migraLogger(LoggerAdapter oldLogger) {
        List<String> logsOld = oldLogger.getLogs();
        for(String log: logsOld) {
            this.grava(log);
        }
        new File(oldLogger.getNomeArquivo()).delete();
    }
}
