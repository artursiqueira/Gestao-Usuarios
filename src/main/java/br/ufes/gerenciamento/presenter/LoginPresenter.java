package br.ufes.gerenciamento.presenter;

import br.ufes.gerenciamento.Application;
import br.ufes.gerenciamento.state.principal.LogadoState;
import br.ufes.gerenciamento.model.Usuario;
import br.ufes.gerenciamento.view.LoginView;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginPresenter {

    //TODO: COMMITAR CLASSE UsuarioService!

    private LoginView view;
    private UsuarioService usuarioService;
    private MainPresenter mainPresenter;

    public LoginPresenter(MainPresenter main) {
        this.mainPresenter = main;
        this.usuarioService = UsuarioService.getInstancia();
        this.view = new LoginView(mainPresenter.getView(), true);
        this.view.getLblErro().setText(" ");

        this.view.getBtnFechar().addActionListener((e) -> {
            fechar();
        });

        this.view.getBtnEntrar().addActionListener((e) -> {
            try {
                entrar();
            }catch(RuntimeException ex) {
                exibeErro(ex.getMessage());
            }
        });

        this.view.getBtnCriarConta().addActionListener((e) -> {
            this.view.dispose();
            new VisualizarUsuarioPresenter(this.mainPresenter, null);
        });

        this.view.setVisible(true);

    }

    private void fechar() {
        this.view.dispose();
        System.exit(0);
    }

    private void entrar() {
        String usuario = this.view.getTxtUsuario().getText();
        String senha = new String(this.view.getTxtSenha().getPassword());

        Usuario u = usuarioService.fazerLogin(usuario, senha);

        Application.getSession().setUsuario(u);
        mainPresenter.setState(new LogadoState(mainPresenter));
        this.view.dispose();

    }

    private void exibeErro(String erro) {
        new Thread() {
            @Override
            public void run() {
                try {
                    view.getLblErro().setText(erro);
                    Thread.sleep(2500);
                    view.getLblErro().setText(" ");
                } catch (InterruptedException ex) {
                    Logger.getLogger(LoginPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();

    }

}
