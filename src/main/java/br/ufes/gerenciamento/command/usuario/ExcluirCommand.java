package br.ufes.gerenciamento.command.usuario;

import br.ufes.gerenciamento.model.Usuario;
import br.ufes.gerenciamento.presenter.usuario.VisualizarUsuarioPresenter;

import javax.swing.*;

public class ExcluirCommand extends EditarCommand {
    private Usuario usuario;
    public ExcluirCommand(VisualizarUsuarioPresenter presenter, Usuario usuario) {
        super(presenter);
        this.usuario = usuario;
    }

    @Override
    public void executar() {
        int confirmado = JOptionPane.showConfirmDialog(
                view,
                "Deseja realmente excluir o usuario?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );
        if(confirmado == JOptionPane.YES_OPTION) {
            this.service.deletar(this.usuario);
            JOptionPane.showMessageDialog(
                    view,
                    "Usuario Excluido com sucesso!",
                    "sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );
            this.view.dispose();
        }

    }

}

