package br.ufes.gerenciamento.state.notificacao;

import br.ufes.gerenciamento.Application;
import br.ufes.gerenciamento.command.notificacao.EnviarCommand;
import br.ufes.gerenciamento.model.Usuario;
import br.ufes.gerenciamento.presenter.notificacao.VisualizarNotificacaoPresenter;
import br.ufes.gerenciamento.service.UsuarioService;

public class EnvioNotificacaoState extends VisualizarNotificacaoState {
    private UsuarioService service;
    private Usuario remetente;
    private Usuario destinatario;
    public EnvioNotificacaoState(VisualizarNotificacaoPresenter presenter, Usuario destinatario) {
        super(presenter);
        service = UsuarioService.getInstancia();
        this.view.setTitle("Enviar Notificação");
        this.remetente = Application.getSession().getUsuario();
        this.destinatario = destinatario;

        if(remetente.getId().longValue() == destinatario.getId().longValue()) {
            throw new RuntimeException(
                    "Você não pode enviar uma notificação para você mesmo"
            );
        }

        this.view.getTxtRemetente().setText(this.remetente.getNome());
        this.view.getTxtDestinatario().setText(this.destinatario.getNome());
        this.view.getTxtRemetente().setEnabled(false);
        this.view.getTxtDestinatario().setEnabled(false);
        this.view.getBtnEnviar().setVisible(true);
        this.view.getBtnAprovar().setVisible(false);
        this.view.getBtnRecusar().setVisible(false);
        this.view.getBtnExcluir().setVisible(false);
    }

    @Override
    public void enviar() {
        new EnviarCommand(
                presenter,
                remetente,
                destinatario
        ).executar();
        fechar();
    }

}
