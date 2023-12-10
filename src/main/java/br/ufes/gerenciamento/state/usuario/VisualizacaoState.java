package br.ufes.gerenciamento.state.usuario;

import br.ufes.gerenciamento.Application;
import br.ufes.gerenciamento.command.usuario.ExcluirCommand;
import br.ufes.gerenciamento.model.Usuario;
import br.ufes.gerenciamento.presenter.usuario.VisualizarUsuarioPresenter;

import java.time.format.DateTimeFormatter;

public class VisualizacaoState extends GerenciarState {
    private final Usuario usuario;
    public VisualizacaoState(VisualizarUsuarioPresenter presenter, Usuario usuario) {
        super(presenter);
        this.usuario = usuario;
        this.view.setTitle("Visualizar Usuário");
        this.view.getBtnEditar().setVisible(true);
        this.view.getBtnCancelar().setVisible(false);
        this.view.getBtnSalvar().setVisible(false);
        this.view.getChkAdm().setVisible(true);
        this.view.getTxtSenha().setVisible(false);
        this.view.getLblSenha().setVisible(false);
        this.view.getLblDataCadastro().setVisible(true);

        this.view.getChkAdm().setEnabled(false);
        this.view.getTxtDataCadastro().setEnabled(false);
        this.view.getTxtNome().setEnabled(false);
        this.view.getTxtUsuario().setEnabled(false);

        if(!Application.getSession().getUsuario().getUsuario().equals(usuario.getUsuario())) {
            this.view.getBtnExcluir().setVisible(true);
        } else {
            this.view.getBtnExcluir().setVisible(false);
        }

        putUsuario();

    }

    private void putUsuario() {
        this.view.getChkAdm().setSelected(usuario.isAdmin());
        this.view.getTxtNome().setText(this.usuario.getNome());
        this.view.getTxtUsuario().setText(this.usuario.getUsuario());
        this.view.getTxtDataCadastro().setText(
                this.usuario.getDataCadastro()
                        .format(
                                DateTimeFormatter.ofPattern("dd/MM/yyyy")
                        )
        );
    }

    @Override
    public void editar() {
        this.presenter.setState(new EdicaoState(presenter, usuario));
    }

    @Override
    public void excluir() {
        new ExcluirCommand(presenter, usuario).executar();
    }

}
