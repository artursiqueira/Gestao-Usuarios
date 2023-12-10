package br.ufes.gerenciamento.presenter.usuario;

import br.ufes.gerenciamento.model.Usuario;
import br.ufes.gerenciamento.presenter.MainPresenter;
import br.ufes.gerenciamento.state.usuario.GerenciarState;
import br.ufes.gerenciamento.state.usuario.InclusaoState;
import br.ufes.gerenciamento.state.usuario.VisualizacaoState;
import br.ufes.gerenciamento.view.VisualizarUsuarioView;

import javax.swing.*;

public class VisualizarUsuarioPresenter {
    private VisualizarUsuarioView view;
    private MainPresenter mainPresenter;
    private GerenciarState state;
    private Usuario usuario;

    public VisualizarUsuarioPresenter(MainPresenter mainPresenter, Usuario usuario) {
        this.view = new VisualizarUsuarioView();
        this.mainPresenter = mainPresenter;
        this.usuario = usuario;
        if(usuario == null) {
            this.setState(new InclusaoState(this));
        } else {
            this.setState(new VisualizacaoState(this, usuario));
        }

        getView().getBtnSalvar().addActionListener((e) -> {
            try {
                this.state.salvar();
            } catch(RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        getView().getBtnFechar().addActionListener((e) -> {
            try {
                this.state.fechar();
            }catch(RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        getView().getBtnCancelar().addActionListener((e) -> {
            try {
                this.state.cancelar();
            } catch(RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        getView().getBtnEditar().addActionListener((e) -> {
            try {
                this.state.editar();
            } catch(RuntimeException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        });

        getView().getBtnExcluir().addActionListener((e) -> {
            try {
                this.state.excluir();
            } catch(RuntimeException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        });

        this.mainPresenter.addToDesktopPane(view);
        this.view.setVisible(true);
    }

    public MainPresenter getMainPresenter() {
        return mainPresenter;
    }

    public VisualizarUsuarioView getView() {
        return this.view;
    }

    public void setState(GerenciarState state) {
        this.state = state;
    }

}
