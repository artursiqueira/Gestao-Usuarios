package br.ufes.gerenciamento.presenter;

import br.ufes.gerenciamento.presenter.usuario.VisualizarUsuarioPresenter;
import br.ufes.gerenciamento.service.UsuarioService;
import br.ufes.gerenciamento.state.principal.NaoLogadoState;
import br.ufes.gerenciamento.state.principal.PrincipalState;
import br.ufes.gerenciamento.observer.Observer;
import br.ufes.gerenciamento.view.PrincipalView;

import javax.swing.*;
import java.awt.*;

public class MainPresenter implements Observer {

    // TODO: COMMITAR CLASSES DE PRESENTER E SERVICE!

    private PrincipalView view;
    private PrincipalState state;

    public MainPresenter() {
        this.view = new PrincipalView();

        setState(new NaoLogadoState(this));

        if(UsuarioService.getInstancia().getListaUsuarios(null).isEmpty()) {
            JOptionPane.showMessageDialog(
                    view,
                    "Não há nenhum administrador cadastrado, realize seu cadastro e se torne um administrador",
                    "Primeiro Acesso!",
                    JOptionPane.INFORMATION_MESSAGE
            );

            new VisualizarUsuarioPresenter(this, null);

        } else {
            new LoginPresenter(this);
        }

        UsuarioService.getInstancia().registerObserver(this);

        this.view.getBtnCadastrar().addActionListener((e) -> {
            try {
                state.cadastrar();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.view.getBtnBuscar().addActionListener((e) -> {
            try {
                state.buscarUsuarios();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.view.getBtnNotificacoes().addActionListener((e) -> {
            try {
                state.buscarNotificacoes();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.view.getBtnConfigurar().addActionListener((e) -> {
            try {
                state.configurar();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.view.getBtnMeuUsuario().addActionListener((e) -> {
            try {
                state.meuUsuario();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.view.setVisible(true);

    }

    public void addToDesktopPane(Component component) {
        this.view.getDesktopPane().add(component);
    }

    public PrincipalView getView() {
        return this.view;
    }

    public void setState(PrincipalState state) {
        this.state = state;
    }

    @Override
    public void update() {
        state.setNumNotificacoes();
    }

}
