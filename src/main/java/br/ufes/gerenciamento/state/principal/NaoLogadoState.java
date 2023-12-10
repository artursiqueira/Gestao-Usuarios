package br.ufes.gerenciamento.state.principal;

import br.ufes.gerenciamento.presenter.MainPresenter;

public class NaoLogadoState extends PrincipalState {

    public NaoLogadoState(MainPresenter presenter) {
        super(presenter);
        this.view.getBtnUsuarios().setVisible(false);
        this.view.getBtnNotificacoes().setVisible(false);
        this.view.getBtnOpcoes().setVisible(false);
    }

}
