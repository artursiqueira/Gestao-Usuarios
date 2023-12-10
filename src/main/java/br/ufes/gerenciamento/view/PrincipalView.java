package br.ufes.gerenciamento.view;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public PrincipalView() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblNomeUsuario = new javax.swing.JLabel();
        lblNomeTipoUsuario = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        btnNotificacoes = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        btnUsuarios = new javax.swing.JMenu();
        btnBuscar = new javax.swing.JMenuItem();
        btnCadastrar = new javax.swing.JMenuItem();
        btnOpcoes = new javax.swing.JMenu();
        btnConfigurar = new javax.swing.JMenuItem();
        btnMeuUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão Usuários");

        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(51, 51, 51));
        lblUsuario.setText("Usuario :");

        lblNomeUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNomeUsuario.setForeground(new java.awt.Color(51, 51, 51));
        lblNomeUsuario.setText("Nome Usuario");

        lblNomeTipoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNomeTipoUsuario.setForeground(new java.awt.Color(51, 51, 51));
        lblNomeTipoUsuario.setText("Nivel de acesso");

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(51, 51, 51));
        lblTipo.setText("Tipo :");

        btnNotificacoes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNotificacoes.setForeground(new java.awt.Color(51, 51, 51));
        btnNotificacoes.setText("Notificações - 0");
        btnNotificacoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        btnNotificacoes.setBorderPainted(false);
        btnNotificacoes.setFocusable(false);
        btnNotificacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotificacoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNomeUsuario))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNomeTipoUsuario)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                .addComponent(btnNotificacoes)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuario)
                            .addComponent(lblNomeUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipo)
                            .addComponent(lblNomeTipoUsuario)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNotificacoes)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        menuBar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnUsuarios.setText("Usuarios");
        btnUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnBuscar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnUsuarios.add(btnBuscar);

        btnCadastrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnUsuarios.add(btnCadastrar);

        menuBar.add(btnUsuarios);

        btnOpcoes.setText("Opções");
        btnOpcoes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcoesActionPerformed(evt);
            }
        });

        btnConfigurar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_COMMA, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnConfigurar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnConfigurar.setText("Configurar");
        btnOpcoes.add(btnConfigurar);

        btnMeuUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnMeuUsuario.setText("Dados Pessoais");
        btnOpcoes.add(btnMeuUsuario);

        menuBar.add(btnOpcoes);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(604, 374));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNotificacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNotificacoesActionPerformed

    private void btnOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpcoesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnBuscar;
    private javax.swing.JMenuItem btnCadastrar;
    private javax.swing.JMenuItem btnConfigurar;
    private javax.swing.JMenuItem btnMeuUsuario;
    private javax.swing.JButton btnNotificacoes;
    private javax.swing.JMenu btnOpcoes;
    private javax.swing.JMenu btnUsuarios;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNomeTipoUsuario;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnNotificacoes() {
        return btnNotificacoes;
    }

    public JLabel getLblNomeTipoUsuario() {
        return lblNomeTipoUsuario;
    }

    public JLabel getLblNomeUsuario() {
        return lblNomeUsuario;
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public JMenuItem getBtnBuscar() {
        return btnBuscar;
    }

    public JMenuItem getBtnCadastrar() {
        return btnCadastrar;
    }

    public JMenu getBtnUsuarios() {
        return btnUsuarios;
    }

    public JMenuItem getBtnConfigurar() {
        return btnConfigurar;
    }

    public JMenu getBtnOpcoes() {
        return btnOpcoes;
    }

    public JMenuItem getBtnMeuUsuario() {
        return btnMeuUsuario;
    }

    public JLabel getLblTipo() {
        return lblTipo;
    }

    public JLabel getLblUsuario() {
        return lblUsuario;
    }
    
}
