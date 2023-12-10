package br.ufes.gerenciamento.command.notificacao;

import br.ufes.gerenciamento.model.Notificacao;
import br.ufes.gerenciamento.model.Usuario;
import br.ufes.gerenciamento.presenter.notificacao.VisualizarNotificacaoPresenter;

import javax.swing.*;

public class EnviarCommand extends PresenterCommand {
    private Usuario remetente;
    private Usuario destinatario;

    public EnviarCommand(VisualizarNotificacaoPresenter presenter, Usuario remetente, Usuario destinatario) {
        super(presenter);
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    @Override
    public void executar() {
        String titulo = this.view.getTxtTitulo().getText();
        String mensagem = this.view.getTxtMensagem().getText();

        Notificacao notificacao = new Notificacao(
                this.remetente.getId(),
                this.destinatario.getId(),
                titulo,
                mensagem,
                false
        );

        validarNotificacao(notificacao);

        usuarioService.enviarNotificacao(notificacao);

        JOptionPane.showMessageDialog(
                this.view,
                "Notificação enviada!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );

    }

}

