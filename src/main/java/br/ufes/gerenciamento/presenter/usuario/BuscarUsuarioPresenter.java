package br.ufes.gerenciamento.presenter.usuario;

import br.ufes.gerenciamento.model.Usuario;
import br.ufes.gerenciamento.observer.Observer;
import br.ufes.gerenciamento.presenter.MainPresenter;
import br.ufes.gerenciamento.presenter.notificacao.VisualizarNotificacaoPresenter;
import br.ufes.gerenciamento.service.UsuarioService;
import br.ufes.gerenciamento.view.BuscarUsuarioView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;

public class BuscarUsuarioPresenter implements Observer {
    private BuscarUsuarioView view;
    private MainPresenter mainPresenter;
    private JTable tabelaUsuarios;
    private UsuarioService service;

    public BuscarUsuarioPresenter(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
        this.view = new BuscarUsuarioView();
        this.tabelaUsuarios = getView().getTabelaUsuarios();
        this.service = UsuarioService.getInstancia();
        this.service.registerObserver(this);

        lerTabelaUsuarios(null);

        getView().getBtnVisualizar().setEnabled(false);
        getView().getBtnEnviarNotificacao().setEnabled(false);

        getView().getBtnFechar().addActionListener((e) -> {
            fechar();
            this.service.removeObserver(this);
        });

        getView().getBtnBuscar().addActionListener((e) -> {
            try {
                buscar();
            } catch(RuntimeException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        });

        getView().getBtnVisualizar().addActionListener((e) -> {
            try {
                visualizar();
            } catch(RuntimeException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        });

        getView().getBtnEnviarNotificacao().addActionListener((e) -> {
            try {
                enviarNotificacao();
            } catch(RuntimeException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        getView().getBtnNovo().addActionListener((e) -> {
            try {
                novo();
            } catch(RuntimeException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(getView(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        tabelaUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(tabelaUsuarios.getSelectedRow() > -1) {
                    getView().getBtnVisualizar().setEnabled(true);
                    getView().getBtnEnviarNotificacao().setEnabled(true);
                }else{
                    getView().getBtnVisualizar().setEnabled(false);
                    getView().getBtnEnviarNotificacao().setEnabled(false);
                }
            }
        });

        this.mainPresenter.addToDesktopPane(view);
        this.view.setVisible(true);
    }

    private void lerTabelaUsuarios(String filtro) {
        DefaultTableModel modelo = (DefaultTableModel) this.tabelaUsuarios.getModel();
        modelo.setNumRows(0);

        for(Usuario u: this.service.getListaUsuarios(filtro)) {
            modelo.addRow(new Object[]{
                    u.getId(),
                    u.getNome(),
                    u.getDataCadastro().format(
                            DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    ),
                    service.getNotificacoes(u).size(),
                    service.getNotificacoesLidas(u).size()
            });
        }

    }

    private BuscarUsuarioView getView() {
        return this.view;
    }

    private void fechar() {
        this.view.dispose();
    }

    private void visualizar() {
        new VisualizarUsuarioPresenter(
                mainPresenter,
                service.lerPorId(
                        (Long) tabelaUsuarios.getValueAt(
                                tabelaUsuarios.getSelectedRow(),
                                0
                        )
                )
        );
    }

    private void enviarNotificacao() {
        Usuario destinatario = service.lerPorId(
                (Long) tabelaUsuarios.getValueAt(
                        tabelaUsuarios.getSelectedRow(),
                        0
                )
        );

        new VisualizarNotificacaoPresenter(
                mainPresenter,
                destinatario
        );

    }

    private void buscar() {
        String nomeBuscado = this.view.getTxtNome().getText();
        if(nomeBuscado.trim().isEmpty()) {
            lerTabelaUsuarios(null);
        } else {
            lerTabelaUsuarios(nomeBuscado);
        }
    }

    private void novo() {
        new VisualizarUsuarioPresenter(mainPresenter, null);
    }

    @Override
    public void update() {
        lerTabelaUsuarios(null);
    }

}
