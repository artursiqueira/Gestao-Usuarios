package br.ufes.gerenciamento.state.notificacao;

import br.ufes.gerenciamento.command.notificacao.AprovarCommand;
import br.ufes.gerenciamento.command.notificacao.ExcluirCommand;
import br.ufes.gerenciamento.command.notificacao.RecusarCommand;
import br.ufes.gerenciamento.model.Notificacao;
import br.ufes.gerenciamento.model.Usuario;
import br.ufes.gerenciamento.presenter.notificacao.VisualizarNotificacaoPresenter;
import br.ufes.gerenciamento.service.UsuarioService;

import javax.swing.*;

public class VisualizacaoNotificacaoState extends VisualizarNotificacaoState {
    private Notificacao notificacao;
    private UsuarioService usuarioService;
    private Usuario remetente;
    private Usuario destinatario;

    public VisualizacaoNotificacaoState(VisualizarNotificacaoPresenter presenter, Notificacao notificacao) {
        super(presenter);
        this.usuarioService = UsuarioService.getInstancia();
        this.view.setTitle("Visualizar Notificação");

        this.notificacao = notificacao;

        remetente = usuarioService.lerPorId(notificacao.getIdRemetente());

        if(remetente == null) {
            excluir();
            JOptionPane.showMessageDialog(
                    view,
                    "O remetente não existe mais no sistema!",
                    "Erro",
                    JOptionPane.INFORMATION_MESSAGE
            );

        }

        destinatario = usuarioService.lerPorId(notificacao.getIdDestinatario());

        if(!notificacao.isLida()) usuarioService.lerNotificacao(notificacao);

        this.view.getTxtRemetente().setText(remetente.getNome());
        this.view.getTxtDestinatario().setText(destinatario.getNome());
        this.view.getTxtTitulo().setText(notificacao.getTitulo());
        this.view.getTxtMensagem().setText(notificacao.getMensagem());
        this.view.getTxtMensagem().setEnabled(false);
        this.view.getTxtTitulo().setEnabled(false);
        this.view.getTxtRemetente().setEnabled(false);
        this.view.getTxtDestinatario().setEnabled(false);
        this.view.getBtnEnviar().setVisible(false);

        if(notificacao.isAprovacao() && !remetente.isAprovado()) {
            this.view.getBtnAprovar().setVisible(true);
            this.view.getBtnRecusar().setVisible(true);
            this.view.getBtnExcluir().setVisible(false);

        } else {
            this.view.getBtnAprovar().setVisible(false);
            this.view.getBtnRecusar().setVisible(false);
            this.view.getBtnExcluir().setVisible(true);
        }

    }

    @Override
    public void aprovar() {
        new AprovarCommand(presenter, notificacao).executar();
        fechar();
    }

    @Override
    public void recusar() {
        new RecusarCommand(presenter, notificacao).executar();
        fechar();
    }

    @Override
    public void excluir() {
        new ExcluirCommand(presenter, notificacao).executar();
        fechar();
    }

}
