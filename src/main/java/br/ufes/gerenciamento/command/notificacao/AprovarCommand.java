package br.ufes.gerenciamento.command.notificacao;

import br.ufes.gerenciamento.model.Notificacao;
import br.ufes.gerenciamento.presenter.notificacao.VisualizarNotificacaoPresenter;

import javax.swing.*;

public class AprovarCommand extends PresenterCommand {
    private Notificacao notificacao;

    public AprovarCommand(VisualizarNotificacaoPresenter presenter, Notificacao notificacao) {
        super(presenter);
        this.notificacao = notificacao;
    }

    @Override
    public void executar() {
        usuarioService.aprovarUsuario(notificacao.getIdRemetente());
        JOptionPane.showMessageDialog(
                view,
                "Usuario Aprovado!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );
        usuarioService.enviarNotificacao(
                new Notificacao(
                        notificacao.getIdDestinatario(),
                        notificacao.getIdRemetente(),
                        "Bem-vindo!",
                        "Sua solicitação foi aprovada e seu acesso foi liberado!",
                        false
                )
        );
        usuarioService.deletarNotificacao(notificacao);
    }
}
