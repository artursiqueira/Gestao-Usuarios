package br.ufes.gerenciamento.state.principal;

import br.ufes.gerenciamento.Application;
import br.ufes.gerenciamento.presenter.MainPresenter;
import br.ufes.gerenciamento.model.Usuario;

public class LogadoState extends PrincipalState {

    // TODO: COMMITAR CLASSES DE PRESENTER E LOG!

    private Usuario usuarioAutenticado;
    public LogadoState(MainPresenter presenter) {
        super(presenter);
        usuarioAutenticado = Application.getSession().getUsuario();
        this.view.getLblNomeUsuario().setText(usuarioAutenticado.getNome());
        String tipo;
        if(usuarioAutenticado.isAdmin()) {
            this.view.getBtnUsuarios().setVisible(true);
            tipo = "Administrador";
        } else {
            tipo = "Usuario";
        }

        this.view.getLblNomeTipoUsuario().setText(tipo);
        this.view.getBtnNotificacoes().setVisible(true);
        this.view.getBtnOpcoes().setVisible(true);
        this.view.getLblNomeTipoUsuario().setVisible(true);
        this.view.getLblNomeUsuario().setVisible(true);

        setNumNotificacoes();
    }

    @Override
    public void cadastrar() {
        new VisualizarUsuarioPresenter(presenter, null);
    }

    @Override
    public void buscarUsuarios() {
        new BuscarUsuarioPresenter(presenter);
    }

    @Override
    public void buscarNotificacoes() {
        new BuscarNotificacaoPresenter(presenter);
    }

    @Override
    public void configurar() {
        new ConfiguracoesPresenter(presenter);
    }

    @Override
    public void meuUsuario() {
        new VisualizarUsuarioPresenter(presenter, usuarioAutenticado);
    }

    @Override
    public void setNumNotificacoes() {
        this.usuarioAutenticado = Application.getSession().getUsuario();

        StringBuilder content = new StringBuilder();

        content.append("Notificações - ");
        content.append(Integer.toString(this.usuarioAutenticado.getNotificacoes().size()));

        this.view.getBtnNotificacoes().setText(content.toString());
    }

}
