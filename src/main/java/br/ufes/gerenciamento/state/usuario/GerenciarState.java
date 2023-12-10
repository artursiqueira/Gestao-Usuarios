package br.ufes.gerenciamento.state.usuario;

import br.ufes.gerenciamento.presenter.usuario.VisualizarUsuarioPresenter;
import br.ufes.gerenciamento.view.VisualizarUsuarioView;

public abstract class GerenciarState {
    protected VisualizarUsuarioPresenter presenter;
    protected VisualizarUsuarioView view;
    public GerenciarState(VisualizarUsuarioPresenter presenter) {
        this.presenter = presenter;
        this.view = this.presenter.getView();
    }

    public void salvar() {
        throw new RuntimeException("Não é possível salvar");
    }
    public void editar() {
        throw new RuntimeException("Não é possível editar");
    }
    public void excluir() {
        throw new RuntimeException("Não é possível excluir");
    }

    public void cancelar() {
        throw new RuntimeException("Não é possível cancelar");
    }

    public void fechar() {
        this.view.dispose();
    }

    public final void limpaCampos() {
        this.view.getTxtNome().setText("");
        this.view.getTxtUsuario().setText("");
        this.view.getTxtSenha().setText("");
        this.view.getChkAdm().setSelected(false);
    }

}
