package br.ufes.gerenciamento.command.notificacao;

import br.ufes.gerenciamento.model.Notificacao;
import br.ufes.gerenciamento.presenter.notificacao.VisualizarNotificacaoPresenter;

import javax.swing.*;

public class ExcluirCommand extends PresenterCommand {
    private Notificacao notificacao;
    public ExcluirCommand(VisualizarNotificacaoPresenter presenter, Notificacao notificacao) {
        super(presenter);
        this.notificacao = notificacao;
    }

    @Override
    public void executar() {
        usuarioService.deletarNotificacao(notificacao);
        JOptionPane.showMessageDialog(
                view,
                "Notificação Removida",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

}
