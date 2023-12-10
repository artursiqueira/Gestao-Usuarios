package br.ufes.gerenciamento.state.usuario;

import br.ufes.gerenciamento.Application;
import br.ufes.gerenciamento.command.usuario.AtualizarCommand;
import br.ufes.gerenciamento.model.Usuario;
import br.ufes.gerenciamento.presenter.usuario.VisualizarUsuarioPresenter;

public class EdicaoState extends GerenciarState {
    private final Usuario usuario;

    public EdicaoState(VisualizarUsuarioPresenter presenter, Usuario usuario) {
        super(presenter);
        this.usuario = usuario;
        this.view.setTitle("Editar Usuário");
        this.view.getBtnEditar().setVisible(false);
        this.view.getBtnSalvar().setVisible(true);
        this.view.getBtnExcluir().setVisible(false);
        this.view.getChkAdm().setVisible(true);
        this.view.getTxtSenha().setVisible(true);
        this.view.getLblSenha().setVisible(true);
        this.view.getBtnCancelar().setVisible(true);

        this.view.getTxtDataCadastro().setEnabled(false);

        Usuario usuarioAutenticado = Application.getSession().getUsuario();

        if(usuarioAutenticado.isAdmin()) {
            if(usuarioAutenticado.getUsuario().equals(usuario.getUsuario())) {
                this.view.getChkAdm().setEnabled(false);
            } else{
                this.view.getChkAdm().setEnabled(true);
            }
            this.view.getTxtNome().setEnabled(true);
            this.view.getTxtUsuario().setEnabled(true);
        } else {
            this.view.getChkAdm().setEnabled(false);
            this.view.getTxtNome().setEnabled(false);
            this.view.getTxtUsuario().setEnabled(false);
        }

    }

    @Override
    public void salvar() {
        new AtualizarCommand(presenter, usuario).executar();

    }

    @Override
    public void cancelar() {
        this.presenter.setState(new VisualizacaoState(presenter, usuario));
    }

}
