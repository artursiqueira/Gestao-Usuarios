package br.ufes.gerenciamento.presenter.notificacao;

import br.ufes.gerenciamento.Application;
import br.ufes.gerenciamento.model.NotificacaoTableModel;
import br.ufes.gerenciamento.observer.Observer;
import br.ufes.gerenciamento.presenter.MainPresenter;
import br.ufes.gerenciamento.service.UsuarioService;
import br.ufes.gerenciamento.view.BuscarNotificacaoView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BuscarNotificacaoPresenter implements Observer {
    private BuscarNotificacaoView view;
    private MainPresenter mainPresenter;
    private JTable tabelaNotificacoes;
    private NotificacaoTableModel modelo;
    private UsuarioService usuarioService;

    public BuscarNotificacaoPresenter(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
        this.view = new BuscarNotificacaoView();
        this.tabelaNotificacoes = this.view.getTabelaNotificacoes();
        this.usuarioService = UsuarioService.getInstancia();
        this.usuarioService.registerObserver(this);
        lerTabela();

        this.view.getBtnVisualizar().setEnabled(false);

        getView().getBtnFechar().addActionListener((e) -> {
            this.view.dispose();
            this.usuarioService.removeObserver(this);
        });

        getView().getBtnVisualizar().addActionListener((e) -> {
            new VisualizarNotificacaoPresenter(
                    mainPresenter,
                    modelo.getNotificacao(tabelaNotificacoes.getSelectedRow())
            );
        });

        tabelaNotificacoes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(tabelaNotificacoes.getSelectedRow() > -1) {
                    getView().getBtnVisualizar().setEnabled(true);
                }else{
                    getView().getBtnVisualizar().setEnabled(false);
                }
            }
        });

        this.mainPresenter.addToDesktopPane(view);
        this.view.setVisible(true);
    }

    public BuscarNotificacaoView getView() {
        return this.view;
    }

    private void lerTabela() {
        try {
            modelo = new NotificacaoTableModel(Application.getSession().getUsuario().getNotificacoes());
            tabelaNotificacoes.setModel(modelo);
        } catch(RuntimeException ex) {
            JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update() {
        lerTabela();
    }


}
