package br.ufes.gerenciamento.command.notificacao;

import br.ufes.gerenciamento.command.ICommand;
import br.ufes.gerenciamento.model.Notificacao;
import br.ufes.gerenciamento.presenter.notificacao.VisualizarNotificacaoPresenter;
import br.ufes.gerenciamento.service.UsuarioService;
import br.ufes.gerenciamento.view.VisualizarNotificacaoView;

public abstract class PresenterCommand implements ICommand {
    protected VisualizarNotificacaoPresenter presenter;
    protected VisualizarNotificacaoView view;
    protected UsuarioService usuarioService = UsuarioService.getInstancia();

    public PresenterCommand(VisualizarNotificacaoPresenter presenter) {
        this.presenter = presenter;
        this.view = presenter.getView();
    }

    @Override
    public abstract void executar();

    protected final void validarNotificacao(Notificacao notificacao) {
        if(notificacao.getTitulo().trim().isEmpty()) {
            throw new RuntimeException("Informe um título para a notificação");
        }
        if(notificacao.getMensagem().trim().isEmpty()) {
            throw new RuntimeException("Informe uma mensagem para a notificação");
        }
        if(notificacao.getTitulo().length() > 50) {
            throw new RuntimeException("O Título deve ser menor que 50 caracteres");
        }
        if(notificacao.getMensagem().length() > 250) {
            throw new RuntimeException("A mensagem deve ser menor que 250 caracteres");
        }
    }

}
