package br.ufes.gerenciamento.state.configuracao;

import br.ufes.gerenciamento.presenter.ConfiguracoesPresenter;
import br.ufes.gerenciamento.view.ConfiguracoesView;

public abstract class ConfiguracoesState {
    protected ConfiguracoesPresenter presenter;
    protected ConfiguracoesView view;

    public ConfiguracoesState(ConfiguracoesPresenter presenter) {
        this.presenter = presenter;
        this.view = this.presenter.getView();
    }

    public void salvar() {
        throw new RuntimeException("Método salvar não pode ser executado");
    }

    public void fechar() {
        this.view.dispose();
    }
}

