package br.ufes.gerenciamento.presenter.notificacao;

import br.ufes.gerenciamento.model.Notificacao;
import br.ufes.gerenciamento.model.Usuario;
import br.ufes.gerenciamento.presenter.MainPresenter;
import br.ufes.gerenciamento.state.notificacao.EnvioNotificacaoState;
import br.ufes.gerenciamento.state.notificacao.VisualizacaoNotificacaoState;
import br.ufes.gerenciamento.state.notificacao.VisualizarNotificacaoState;
import br.ufes.gerenciamento.view.VisualizarNotificacaoView;

import javax.swing.*;

public class VisualizarNotificacaoPresenter {
    private VisualizarNotificacaoView view;
    private VisualizarNotificacaoState state;
    private MainPresenter mainPresenter;
    private Notificacao notificacao;
    private Usuario destinatario;

    public VisualizarNotificacaoPresenter(MainPresenter mainPresenter, Notificacao notificacao) {
        this.view = new VisualizarNotificacaoView();
        this.mainPresenter = mainPresenter;
        this.notificacao = notificacao;
        this.state = new VisualizacaoNotificacaoState(this, notificacao);
        exibir();
        configuraBotoes();
    }

    public VisualizarNotificacaoPresenter(MainPresenter mainPresenter, Usuario destinatario) {
        this.view = new VisualizarNotificacaoView();
        this.mainPresenter = mainPresenter;
        this.destinatario = destinatario;
        this.state = new EnvioNotificacaoState(this, this.destinatario);
        exibir();
        configuraBotoes();
    }

    public void configuraBotoes() {
        this.view.getBtnFechar().addActionListener((e) -> {
            try {
                this.state.fechar();
            }catch(RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.view.getBtnEnviar().addActionListener((e) -> {
            try {
                this.state.enviar();
            } catch(RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        });

        this.view.getBtnAprovar().addActionListener((e) -> {
            try {
                this.state.aprovar();
            }catch(RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.view.getBtnRecusar().addActionListener((e) -> {
            try {
                this.state.recusar();
            }catch(RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.view.getBtnExcluir().addActionListener((e) -> {
            try {
                this.state.excluir();
            } catch(RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public VisualizarNotificacaoView getView() {
        return view;
    }

    public VisualizarNotificacaoState getState() {
        return state;
    }

    public void setState(VisualizarNotificacaoState state) {
        this.state = state;
    }

    public void exibir() {
        this.mainPresenter.addToDesktopPane(view);
        this.view.setVisible(true);
    }

}
