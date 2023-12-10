
package br.ufes.gerenciamento;

import br.ufes.gerenciamento.presenter.MainPresenter;
import br.ufes.gerenciamento.session.Session;
import br.ufes.gerenciamento.util.Configuracoes;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    // TODO: COMMITAR IMPLEMENTAÇÃO DE LOG!

    private static Session session;
    private static LoggerAdapter logger;
    private static String logFormat;
    private static Configuracoes propertyManager;

    public Application() {
        session = Session.getInstancia();
        propertyManager = new Configuracoes();

        getProperties();

        logger = new LoggerAdapterFactory().cria(logFormat);

        new MainPresenter();
    }

    public static String getLogFormat() {
        return logFormat;
    }

    public static void setLogFormat(String logFormat) {
        Application.logFormat = logFormat;
    }

    private static void getProperties() {
        setLogFormat(propertyManager.getConfig("logFormat"));
    }

    public static void changeLogFormat(String logFormat) {
        LoggerAdapter loggerOld = Application.logger;
        Application.logger = new LoggerAdapterFactory().cria(logFormat);
        Application.logger.migraLogger(loggerOld);
        propertyManager.defineConfig("logFormat", logFormat);
        Application.logFormat = logFormat;

    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                        try {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                new Application();
            }
        });
    }

    public static Session getSession() {
        return session;
    }

    public static LoggerAdapter getLogger() {
        return logger;
    }

    public static void setLogger(LoggerAdapter logger) {
        Application.logger = logger;
    }
}
