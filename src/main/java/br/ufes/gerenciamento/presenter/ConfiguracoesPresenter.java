package br.ufes.gerenciamento.presenter;

import br.ufes.gerenciamento.state.configuracao.ConfiguracoesState;
import br.ufes.gerenciamento.state.configuracao.ProntoParaConfigurarConfiguracoesState;
import br.ufes.gerenciamento.view.ConfiguracoesView;

import javax.swing.*;

public class ConfiguracoesPresenter {
    private ConfiguracoesView view;
    private MainPresenter mainPresenter;
    private ConfiguracoesState state;

    public ConfiguracoesPresenter(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
        this.view = new ConfiguracoesView();

        setState(new ProntoParaConfigurarConfiguracoesState(this));

        this.view.getBtnFechar().addActionListener((e) -> {
            try {
                state.fechar();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.view.getBtnSalvar().addActionListener((e) -> {
            try {
                state.salvar();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.mainPresenter.addToDesktopPane(view);
        this.view.setVisible(true);
    }

    public ConfiguracoesView getView() {
        return this.view;
    }

    public ConfiguracoesState getState() {
        return state;
    }

    public void setState(ConfiguracoesState state) {
        this.state = state;
    }

}
