package br.ufes.gerenciamento.state.notificacao;

import br.ufes.gerenciamento.presenter.notificacao.VisualizarNotificacaoPresenter;
import br.ufes.gerenciamento.view.VisualizarNotificacaoView;

public abstract class VisualizarNotificacaoState {
    protected VisualizarNotificacaoPresenter presenter;
    protected VisualizarNotificacaoView view;
    public VisualizarNotificacaoState(VisualizarNotificacaoPresenter presenter) {
        this.presenter = presenter;
        this.view = this.presenter.getView();
    }

    public void enviar() {
        throw new RuntimeException("Método enviar não pode ser executado");
    }

    public void excluir() {
        throw new RuntimeException("Método excluir não pode ser executado");
    }

    public void aprovar() {
        throw new RuntimeException("Método aprovar não pode ser executado");
    }

    public void recusar() {
        throw new RuntimeException("Método recusar não pode ser executado");
    }

    public void fechar() {
        this.view.dispose();
    }

}
