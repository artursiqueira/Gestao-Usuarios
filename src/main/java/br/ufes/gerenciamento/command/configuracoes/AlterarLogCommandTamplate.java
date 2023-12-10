package br.ufes.gerenciamento.command.configuracoes;

import br.ufes.gerenciamento.Application;
import br.ufes.gerenciamento.presenter.ConfiguracoesPresenter;

import javax.swing.*;

public class AlterarLogCommandTamplate extends CommandTemplate{
    public AlterarLogCommandTamplate(ConfiguracoesPresenter presenter){
        super(presenter);
    }

    @Override
    public void executar() {
        String novoFormatoLog = (String) this.view.getCbFormatoLog().getSelectedItem();
        if (novoFormatoLog.equals(Application.getLogFormat())) {  // TODO: COMMITAR CLASSES DE LOG !!
            JOptionPane.showMessageDialog(
                    view,
                    "O formato selecionado deve ser diferente do atual.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            int confirmacao = JOptionPane.showConfirmDialog(
                    view,
                    "Deseja alterar o formato de log?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirmacao == JOptionPane.YES_OPTION) {
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            onStart();
                            Application.changeLogFormat(novoFormatoLog); // TODO: COMMITAR CLASSES DE LOG !!
                            onSuccess();
                        } catch (RuntimeException ex) {
                            onError(ex);
                        } finally {
                            onFinish();
                        }
                    }
                }.start();
            }
        }
    }
}
