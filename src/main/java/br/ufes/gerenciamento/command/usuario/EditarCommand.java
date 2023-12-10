package br.ufes.gerenciamento.command.usuario;

import br.ufes.gerenciamento.command.ICommand;
import br.ufes.gerenciamento.model.Usuario;
import br.ufes.gerenciamento.presenter.usuario.VisualizarUsuarioPresenter;
import br.ufes.gerenciamento.service.UsuarioService;
import br.ufes.gerenciamento.view.VisualizarUsuarioView;
import com.pss.senha.validacao.ValidadorSenha;

import java.util.List;

public abstract class EditarCommand implements ICommand {

    protected UsuarioService service = UsuarioService.getInstancia();
    protected VisualizarUsuarioPresenter presenter;
    protected VisualizarUsuarioView view;

    public EditarCommand(VisualizarUsuarioPresenter presenter) {
        this.presenter = presenter;
        this.view = presenter.getView();
    }

    @Override
    public abstract void executar();

    public final void validar(Usuario usuario, boolean validarSenha) {
        if(usuario.getNome().trim().isEmpty()) {
            throw new RuntimeException("Informe um nome para o usuário!");
        }

        if(usuario.getNome().length() > 60 || usuario.getNome().length() < 3) {
            throw new RuntimeException("O nome deve possuir entre 3 e 60 caracteres!");
        }

        if(usuario.getUsuario().length() > 45 || usuario.getUsuario().length() < 3) {
            throw new RuntimeException("O nome de usuario deve possuir entre 3 e 45 caracteres!");
        }

        if(validarSenha) {
            List<String> errosSenha = new ValidadorSenha().validar(usuario.getSenha());
            if(!errosSenha.isEmpty()) {
                throw new RuntimeException(errosSenha.get(0));
            }
        }

    }
}
