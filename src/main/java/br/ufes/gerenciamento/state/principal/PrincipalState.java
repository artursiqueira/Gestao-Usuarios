package br.ufes.gerenciamento.state.principal;

import br.ufes.gerenciamento.presenter.MainPresenter;
import br.ufes.gerenciamento.view.PrincipalView;

public abstract class PrincipalState {
    protected MainPresenter presenter;
    protected PrincipalView view;

    public PrincipalState(MainPresenter presenter) {
        this.presenter = presenter;
        this.view = this.presenter.getView();
    }

    public void cadastrar() {
        throw new RuntimeException("Método cadastrar não pode ser executado");
    }
    public void buscarUsuarios() {
        throw new RuntimeException("Método buscar usuarios não pode ser executado");
    }
    public void buscarNotificacoes() {
        throw new RuntimeException("Método buscar notificacoes não pode ser executado");
    }
    public void configurar() {
        throw new RuntimeException("Método configurar não pode ser executado");
    }
    public void meuUsuario() {
        throw new RuntimeException("Método configurar não pode ser executado");
    }
    public void setNumNotificacoes() {

    }
}
