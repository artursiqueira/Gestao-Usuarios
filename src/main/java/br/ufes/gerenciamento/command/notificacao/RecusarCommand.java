package br.ufes.gerenciamento.command.notificacao;

import br.ufes.gerenciamento.model.Notificacao;
import br.ufes.gerenciamento.presenter.notificacao.VisualizarNotificacaoPresenter;

import javax.swing.*;

public class RecusarCommand extends PresenterCommand {
    private Notificacao notificacao;
    public RecusarCommand(VisualizarNotificacaoPresenter presenter, Notificacao notificacao) {
        super(presenter);
        this.notificacao = notificacao;
    }
    @Override
    public void executar() {
        usuarioService.deletar(usuarioService.lerPorId(notificacao.getIdRemetente()));
        usuarioService.deletarNotificacao(notificacao);
        JOptionPane.showMessageDialog(
                view,
                "Solicitação recusada",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
