package br.ufes.gerenciamento.logger.adapter;

public interface ILoggerAdapterFactory {
    LoggerAdapter cria(String formato);
}
