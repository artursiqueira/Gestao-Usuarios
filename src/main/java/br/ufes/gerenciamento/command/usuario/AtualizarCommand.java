package br.ufes.gerenciamento.command.usuario;

import br.ufes.gerenciamento.model.Usuario;
import br.ufes.gerenciamento.presenter.usuario.VisualizarUsuarioPresenter;
import br.ufes.gerenciamento.state.usuario.VisualizacaoState;

import javax.swing.*;
import java.time.LocalDate;

public class AtualizarCommand extends EditarCommand {
    private Usuario usuario;

    public AtualizarCommand(VisualizarUsuarioPresenter presenter, Usuario usuario) {
        super(presenter);
        this.usuario = usuario;
    }
    @Override
    public void executar() {
        String nome = this.view.getTxtNome().getText();
        String usuario = this.view.getTxtUsuario().getText();
        String senha = this.view.getTxtSenha().getText();
        boolean admin = this.view.getChkAdm().isSelected();

        Usuario usuarioAtualizado = new Usuario(nome, usuario, senha, LocalDate.now(), admin);
        usuarioAtualizado.setId(this.usuario.getId());
        usuarioAtualizado.setDataCadastro(this.usuario.getDataCadastro());

        if(usuarioAtualizado.getSenha().trim().isEmpty()) {
            usuarioAtualizado.setSenha(this.usuario.getSenha());
            validar(usuarioAtualizado, false);
            service.atualizar(usuarioAtualizado);
            this.presenter.setState(new VisualizacaoState(presenter, usuarioAtualizado));
        } else {
            int escolha = JOptionPane.showConfirmDialog(
                    view,
                    "Deseja realmente alterar a senha?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );
            if(escolha == JOptionPane.YES_OPTION) {
                validar(usuarioAtualizado, true);
                service.atualizar(usuarioAtualizado);
                service.alterarSenha(usuarioAtualizado);
                this.presenter.setState(new VisualizacaoState(presenter, usuarioAtualizado));
            } else {
                this.presenter.setState(new VisualizacaoState(presenter, this.usuario));
                return;
            }

        }
        JOptionPane.showMessageDialog(
                this.view,
                "Usuario Atualizado",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
