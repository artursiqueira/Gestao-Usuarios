package br.ufes.gerenciamento.state.configuracao;

import br.ufes.gerenciamento.presenter.ConfiguracoesPresenter;

public class ConfigurandoConfiguracoesState extends ConfiguracoesState {

    public ConfigurandoConfiguracoesState(ConfiguracoesPresenter presenter) {
        super(presenter);
        view.getBtnFechar().setEnabled(false);
        view.getBtnSalvar().setEnabled(false);
        view.getCbFormatoLog().setEnabled(false);
    }

}
