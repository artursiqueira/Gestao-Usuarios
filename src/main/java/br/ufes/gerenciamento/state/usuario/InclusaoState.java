package br.ufes.gerenciamento.state.usuario;

import br.ufes.gerenciamento.Application;
import br.ufes.gerenciamento.command.usuario.SalvarCommand;
import br.ufes.gerenciamento.presenter.LoginPresenter;
import br.ufes.gerenciamento.presenter.usuario.VisualizarUsuarioPresenter;

public class InclusaoState extends GerenciarState {

    public InclusaoState(VisualizarUsuarioPresenter presenter) {
        super(presenter);
        this.view.setTitle("Criar Usuário");
        this.view.getLblDataCadastro().setVisible(false);
        this.view.getTxtDataCadastro().setVisible(false);
        this.view.getBtnExcluir().setVisible(false);
        this.view.getBtnEditar().setVisible(false);
        this.view.getBtnCancelar().setVisible(false);
        this.view.getChkAdm().setVisible(false);
    }

    @Override
    public void salvar() {
        new SalvarCommand(presenter).executar();
        if(Application.getSession().isAutenticado()) {
            limpaCampos();
        } else {
            fechar();
            new LoginPresenter(presenter.getMainPresenter());
        }

    }

}
