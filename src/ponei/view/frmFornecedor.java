/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponei.view;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ponei.model.bean.Fornecedor;
import ponei.model.dao.FornecedorDAO;

/**
 *
 * @author Computador
 */
public class frmFornecedor extends javax.swing.JFrame {

    /**
     * Creates new form frmUsuarios
     */
    enum PHASE {
        NONE,
        NEW,
        VIEW,
        EDIT
    }

    PHASE registerPhase = PHASE.NONE;

    public frmFornecedor() {
        initComponents();
        this.getContentPane().setBackground(new Color(20, 20, 20));
        populateUsersTable();
    }

    private boolean checkParameters() {
        //algum campo de texto (sem ser id)ta vazio
        if (txtSocialReason.getText().isEmpty() || txtFantasyName.getText().isEmpty() || txtPhone.getText().isEmpty() || txtEmail.getText().isEmpty() || txtManager.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Algum campo está vazio.");
            return false;
        }
        return true;
    }

    private void populateUsersTable() {
        DefaultTableModel model = (DefaultTableModel) tableSuppliers.getModel();
        model.setNumRows(0);

        FornecedorDAO dao = new FornecedorDAO();

        for (Fornecedor f : dao.findAll()) {
            model.addRow(new Object[]{
                f.getId(),
                f.getSocialReason(),
                f.getFantasyName(),
                f.getPhone(),
                f.getEmail(),
                f.getManager()
            });

        }
    }

    private void populateUsersTableCustom() {
        DefaultTableModel model = (DefaultTableModel) tableSuppliers.getModel();
        model.setNumRows(0);

        FornecedorDAO dao = new FornecedorDAO();

        for (Fornecedor f : dao.findAllByFilter(String.valueOf(comboSearch.getSelectedItem()), txtSearch.getText())) {
            model.addRow(new Object[]{
                f.getId(),
                f.getSocialReason(),
                f.getFantasyName(),
                f.getPhone(),
                f.getEmail(),
                f.getManager()
            });

        }

    }

    private void updateControls(PHASE phase) {
        switch (phase) {
            case NONE:
                //sem treco de texto
                txtSocialReason.setEditable(false);
                txtFantasyName.setEditable(false);
                txtPhone.setEditable(false);
                txtEmail.setEditable(false);
                txtManager.setEditable(false);
                //só novo user pode ser feito
                btNew.setEnabled(true);
                btSave.setEnabled(false);
                btEdit.setEnabled(false);
                btDelete.setEnabled(false);
                btCancel.setEnabled(false);

                txtId.setText("");
                txtSocialReason.setText("");
                txtFantasyName.setText("");
                txtPhone.setText("");
                txtEmail.setText("");
                txtManager.setText("");
                break;

            case NEW:
                //pode colocar novo treco
                txtSocialReason.setEditable(true);
                txtFantasyName.setEditable(true);
                txtPhone.setEditable(true);
                txtEmail.setEditable(true);
                txtManager.setEditable(true);
                //cancelar ou criar novo
                btNew.setEnabled(false);
                btSave.setEnabled(true);
                btEdit.setEnabled(false);
                btDelete.setEnabled(false);
                btCancel.setEnabled(true);
                break;

            case VIEW:
                //só vendo, veio da tabela
                //nao pode editar
                txtSocialReason.setEditable(false);
                txtFantasyName.setEditable(false);
                txtPhone.setEditable(false);
                txtEmail.setEditable(false);
                txtManager.setEditable(false);
                //deletar o usuario ou editar
                btNew.setEnabled(false);
                btSave.setEnabled(false);
                btEdit.setEnabled(true);
                btDelete.setEnabled(true);
                btCancel.setEnabled(true);
                break;

            case EDIT:
                //pode editar
                txtSocialReason.setEditable(true);
                txtFantasyName.setEditable(true);
                txtPhone.setEditable(true);
                txtEmail.setEditable(true);
                txtManager.setEditable(true);
                //salvar o user editado ou cancelar
                btNew.setEnabled(false);
                btSave.setEnabled(true);
                btEdit.setEnabled(false);
                btDelete.setEnabled(false);
                btCancel.setEnabled(true);
                break;

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabcFornecedores = new javax.swing.JTabbedPane();
        tabFornecedoresReg = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();
        lbSocialReason = new javax.swing.JLabel();
        txtSocialReason = new javax.swing.JTextField();
        lbFantasyName = new javax.swing.JLabel();
        txtFantasyName = new javax.swing.JTextField();
        lbPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btNew = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        lbEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lbManager = new javax.swing.JLabel();
        txtManager = new javax.swing.JTextField();
        tabFornecedoresList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSuppliers = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        comboSearch = new javax.swing.JComboBox<>();
        btSearch = new javax.swing.JButton();
        btSearchReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabFornecedoresReg.setBackground(new java.awt.Color(30, 30, 30));

        txtId.setEditable(false);

        lbId.setForeground(new java.awt.Color(153, 153, 153));
        lbId.setText("id");

        lbSocialReason.setForeground(new java.awt.Color(153, 153, 153));
        lbSocialReason.setText("razão social");

        txtSocialReason.setEditable(false);

        lbFantasyName.setForeground(new java.awt.Color(153, 153, 153));
        lbFantasyName.setText("nome fantasia");

        txtFantasyName.setEditable(false);

        lbPhone.setForeground(new java.awt.Color(153, 153, 153));
        lbPhone.setText("telefone");

        txtPhone.setEditable(false);

        btNew.setText("novo");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        btSave.setText("salvar");
        btSave.setEnabled(false);
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btEdit.setText("editar");
        btEdit.setEnabled(false);
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btDelete.setText("excluir");
        btDelete.setEnabled(false);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btCancel.setText("cancelar");
        btCancel.setEnabled(false);
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        lbEmail.setForeground(new java.awt.Color(153, 153, 153));
        lbEmail.setText("email");

        txtEmail.setEditable(false);

        lbManager.setForeground(new java.awt.Color(153, 153, 153));
        lbManager.setText("gerente");

        txtManager.setEditable(false);

        javax.swing.GroupLayout tabFornecedoresRegLayout = new javax.swing.GroupLayout(tabFornecedoresReg);
        tabFornecedoresReg.setLayout(tabFornecedoresRegLayout);
        tabFornecedoresRegLayout.setHorizontalGroup(
            tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                        .addComponent(lbManager)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtManager))
                    .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                        .addComponent(lbEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail))
                    .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                        .addComponent(lbPhone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
                    .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                        .addComponent(lbFantasyName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFantasyName))
                    .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                        .addComponent(lbSocialReason)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSocialReason))
                    .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                        .addComponent(lbId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId)))
                .addGap(21, 21, 21)
                .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btCancel)
                    .addComponent(btDelete)
                    .addComponent(btNew)
                    .addComponent(btSave)
                    .addComponent(btEdit))
                .addContainerGap())
        );
        tabFornecedoresRegLayout.setVerticalGroup(
            tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                        .addComponent(btNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancel))
                    .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                        .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSocialReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSocialReason))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFantasyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFantasyName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPhone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbManager))))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        tabcFornecedores.addTab("cadastrar", tabFornecedoresReg);

        tabFornecedoresList.setBackground(new java.awt.Color(30, 30, 30));

        tableSuppliers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "razaoSocial", "nomeFantasia", "telefone", "email", "gerente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSuppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSuppliersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSuppliers);

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "socialReason", "fantasyName", "phone", "email", "manager" }));

        btSearch.setText("procurar");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        btSearchReset.setText("reset");
        btSearchReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabFornecedoresListLayout = new javax.swing.GroupLayout(tabFornecedoresList);
        tabFornecedoresList.setLayout(tabFornecedoresListLayout);
        tabFornecedoresListLayout.setHorizontalGroup(
            tabFornecedoresListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
            .addGroup(tabFornecedoresListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSearchReset)
                .addContainerGap())
        );
        tabFornecedoresListLayout.setVerticalGroup(
            tabFornecedoresListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabFornecedoresListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabFornecedoresListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearch)
                    .addComponent(btSearchReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
        );

        tabcFornecedores.addTab("listar", tabFornecedoresList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabcFornecedores)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabcFornecedores)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableSuppliersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSuppliersMouseClicked

        if (tableSuppliers.getSelectedRow() != -1) {

            txtId.setText(tableSuppliers.getValueAt(tableSuppliers.getSelectedRow(), 0).toString());
            txtSocialReason.setText(tableSuppliers.getValueAt(tableSuppliers.getSelectedRow(), 1).toString());
            txtFantasyName.setText(tableSuppliers.getValueAt(tableSuppliers.getSelectedRow(), 2).toString());
            txtPhone.setText(tableSuppliers.getValueAt(tableSuppliers.getSelectedRow(), 3).toString());
            txtEmail.setText(tableSuppliers.getValueAt(tableSuppliers.getSelectedRow(), 4).toString());
            txtManager.setText(tableSuppliers.getValueAt(tableSuppliers.getSelectedRow(), 5).toString());
            

            registerPhase = PHASE.VIEW;
            updateControls(registerPhase);

            tabcFornecedores.setSelectedIndex(0);
        }
    }//GEN-LAST:event_tableSuppliersMouseClicked

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        registerPhase = PHASE.NEW;
        updateControls(registerPhase);
    }//GEN-LAST:event_btNewActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        if (checkParameters()) {
            Fornecedor f = new Fornecedor();
            FornecedorDAO dao = new FornecedorDAO ();
            switch (registerPhase) {
                case EDIT:
                    f.setId(Integer.parseInt(txtId.getText()));
                case NEW:
                    f.setSocialReason(txtSocialReason.getText());
                    f.setFantasyName(txtFantasyName.getText());
                    f.setPhone(txtPhone.getText());
                    f.setEmail(txtEmail.getText());
                    f.setManager(txtManager.getText());

                    dao.save(f); //cria/update o treco
                    break;
            }

            registerPhase = PHASE.NONE;
            updateControls(registerPhase);
            populateUsersTable();
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        registerPhase = PHASE.EDIT;
        updateControls(registerPhase);
    }//GEN-LAST:event_btEditActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        FornecedorDAO dao = new FornecedorDAO ();

        dao.remove(Integer.parseInt(txtId.getText())); //deleta o user

        registerPhase = PHASE.NONE;
        updateControls(registerPhase);

        populateUsersTable();
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        registerPhase = PHASE.NONE;
        updateControls(registerPhase);
    }//GEN-LAST:event_btCancelActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        if (txtSearch.getText() != "") {
            populateUsersTableCustom();
        }
    }//GEN-LAST:event_btSearchActionPerformed

    private void btSearchResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchResetActionPerformed
        populateUsersTable();
    }//GEN-LAST:event_btSearchResetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btSearchReset;
    private javax.swing.JComboBox<String> comboSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbFantasyName;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbManager;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbSocialReason;
    private javax.swing.JPanel tabFornecedoresList;
    private javax.swing.JPanel tabFornecedoresReg;
    private javax.swing.JTabbedPane tabcFornecedores;
    private javax.swing.JTable tableSuppliers;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFantasyName;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtManager;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSocialReason;
    // End of variables declaration//GEN-END:variables
}
