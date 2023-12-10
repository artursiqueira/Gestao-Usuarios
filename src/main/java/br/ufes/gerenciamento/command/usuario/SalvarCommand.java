package br.ufes.gerenciamento.command.usuario;

import br.ufes.gerenciamento.model.Usuario;
import br.ufes.gerenciamento.service.UsuarioService;
import br.ufes.gerenciamento.session.Session;

import javax.swing.*;
import java.time.LocalDate;

public class SalvarCommand extends EditarCommand {
    private Usuario novoUsuario;
    public SalvarCommand(VisualizarUsuarioPresenter presenter) {
        super(presenter);
    }

    @Override
    public void executar() {
        if(Session.isAutenticado()) {
            salvarUsuario(false);
            JOptionPane.showMessageDialog(this.view, "Usuario Inserido e aprovado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if(UsuarioService.getInstancia().getListaUsuarios(null).isEmpty()) {
                salvarUsuario(true);
                service.aprovarUsuario(novoUsuario.getId());
                JOptionPane.showMessageDialog(
                        this.view,
                        "Usuario Administrador criado com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                salvarUsuario(false);
                JOptionPane.showMessageDialog(
                        this.view,
                        "Uma solicitação de aprovação foi enviada ao administrador",
                        "Solicitação enviada",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        }

    }

    private void salvarUsuario(boolean admin) {
        String nome = this.view.getTxtNome().getText();
        String usuario = this.view.getTxtUsuario().getText();
        String senha = this.view.getTxtSenha().getText();

        novoUsuario = new Usuario(nome, usuario, senha, LocalDate.now(), admin);

        validar(novoUsuario, true);

        this.service.criarUsuario(novoUsuario);
    }

}
