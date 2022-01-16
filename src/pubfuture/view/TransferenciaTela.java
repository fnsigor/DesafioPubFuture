/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pubfuture.bean.Conta;
import pubfuture.bean.Transferencia;
import pubfuture.dao.ContaDaoImpl;
import pubfuture.dao.OperacoesDaoImpl;

/**
 *
 * @author Igor Fernandes
 */
public class TransferenciaTela extends javax.swing.JFrame {
    
    //declaração global para evitar repetições
    Conta conta = new Conta();
    ContaDaoImpl daoConta = new ContaDaoImpl();
    DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    Transferencia transferencia = new Transferencia();
    OperacoesDaoImpl Operacao = new OperacoesDaoImpl();

    public TransferenciaTela() {
        initComponents();
        listar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        varDtTransferencia = new javax.swing.JFormattedTextField();
        varIdPagador = new javax.swing.JFormattedTextField();
        varIdRecebedor = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btRealizarTransferencia = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        varValor = new javax.swing.JFormattedTextField();
        btVizualizar = new javax.swing.JButton();
        varPesquisaIdPagador = new javax.swing.JFormattedTextField();
        btPesquisaIdPagador = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFinancas = new javax.swing.JMenu();
        menuReceitas = new javax.swing.JMenuItem();
        menuDespesas = new javax.swing.JMenuItem();
        menuOperações = new javax.swing.JMenu();
        menuTransferencia = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transferências");

        try {
            varDtTransferencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel1.setText("Data da transferência:");

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel2.setText("ID da conta do pagador:");

        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel3.setText("ID da conta do recebedor:");

        btRealizarTransferencia.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        btRealizarTransferencia.setText("Transferir");
        btRealizarTransferencia.setToolTipText("Realizar Transferência");
        btRealizarTransferencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btRealizarTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRealizarTransferenciaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel5.setText("Valor da transferência:");

        btVizualizar.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        btVizualizar.setText("Vizualizar Transferências");
        btVizualizar.setToolTipText("Ver todas as transferências no banco");
        btVizualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btVizualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVizualizarActionPerformed(evt);
            }
        });

        btPesquisaIdPagador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pubfuture/icons/procurar (2).png"))); // NOI18N
        btPesquisaIdPagador.setToolTipText("Pesquisar transferêncvia pelo ID");
        btPesquisaIdPagador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPesquisaIdPagador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaIdPagadorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel6.setText("ID do Pagador:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(varIdPagador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(varDtTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(varValor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(varPesquisaIdPagador, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addComponent(btPesquisaIdPagador, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(varIdRecebedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btRealizarTransferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btVizualizar)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(varDtTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(varPesquisaIdPagador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btPesquisaIdPagador))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(varIdPagador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varIdRecebedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 57, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btVizualizar)
                            .addComponent(btRealizarTransferencia))))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel4.setText("Histórico de transferências:");

        jScrollPane1.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N

        tabela.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Transferência", "Data Transferência", "Valor Transferência", "ID Pagador", "ID Recebedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

        menuFinancas.setText("Finanças");
        menuFinancas.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N

        menuReceitas.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        menuReceitas.setText("Receitas");
        menuReceitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReceitasActionPerformed(evt);
            }
        });
        menuFinancas.add(menuReceitas);

        menuDespesas.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        menuDespesas.setText("Despesas");
        menuDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDespesasActionPerformed(evt);
            }
        });
        menuFinancas.add(menuDespesas);

        jMenuBar1.add(menuFinancas);

        menuOperações.setText("Operações");
        menuOperações.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N

        menuTransferencia.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        menuTransferencia.setText("Transferência");
        menuTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTransferenciaActionPerformed(evt);
            }
        });
        menuOperações.add(menuTransferencia);

        jMenuBar1.add(menuOperações);

        jMenu1.setText("Usuário");
        jMenu1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jMenuItem1.setText("Contas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //metodo para realizar transferencia
    private void btRealizarTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRealizarTransferenciaActionPerformed
         //se os valores informados passrem pela validação
        if (!temErro()) {
            //se o pagador tem saldo suficiente para realizar transação
            if (!saldoInsuficiente()) {
                try {
                    //setando valores nas variaveis
                    transferencia.setValor(Double.parseDouble(varValor.getText().trim().replace(",", ".")));
                    conta = daoConta.pesquisaPorId(Integer.parseInt(varIdPagador.getText().trim()));
                    transferencia.setPagador(conta);
                    conta = daoConta.pesquisaPorId(Integer.parseInt(varIdRecebedor.getText().trim()));
                    transferencia.setRecebedor(conta);

                    //para inserir a datas formatada foi necessário um try-catch
                    String dataString = varDtTransferencia.getText();
                    transferencia.setDtTransferencia(new java.sql.Date(fmt.parse(dataString).getTime()));

                    //realizando transferecnia
                    Operacao.transferenciaHistorico(transferencia);
           
                } catch (ParseException ex) {
                    Logger.getLogger(TransferenciaTela.class.getName()).log(Level.SEVERE, null, ex);
                }
             JOptionPane.showMessageDialog(null, "Transfêrencia realizada com sucesso");
             limpar();
             listar();
            }
        }
    }//GEN-LAST:event_btRealizarTransferenciaActionPerformed

    
    //botao para vizualizar todas as transferencias no banco
    private void btVizualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVizualizarActionPerformed
        listar();
    }//GEN-LAST:event_btVizualizarActionPerformed

    
    //botao para pesquisar transferencias no banco de acordo com a ID do pagador informada
    private void btPesquisaIdPagadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaIdPagadorActionPerformed
        pesquisaId(Integer.parseInt(varPesquisaIdPagador.getText().trim()));
    }//GEN-LAST:event_btPesquisaIdPagadorActionPerformed

    
    //menu
    private void menuReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReceitasActionPerformed
        new ReceitasTela().setVisible(true);
    }//GEN-LAST:event_menuReceitasActionPerformed
    private void menuDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDespesasActionPerformed
        new DespesasTela().setVisible(true);
    }//GEN-LAST:event_menuDespesasActionPerformed
    private void menuTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTransferenciaActionPerformed
        new TransferenciaTela().setVisible(true);
    }//GEN-LAST:event_menuTransferenciaActionPerformed
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ContaTela().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    //menu
    
    //metodo para validar se dados estão ok antes de realizar transferencia
    private Boolean temErro() {
        if (validarDtTransferencia()) {
            JOptionPane.showMessageDialog(null, "Informe uma data válida");
            return true;
        }

        if (validarValor()) {
            JOptionPane.showMessageDialog(null, "Informe um valor válido");
            return true;
        }

        if (varIdPagador.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um ID válido");
            return true;
        }

        if (varIdRecebedor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um ID válido");
            return true;
        }
        return false;
    }

    
    //MÉTODOS AUXILIARES 
    private boolean validarDtTransferencia() {
        String dtTransferencia = varDtTransferencia.getText().trim();
        String primeiroCaracter = dtTransferencia.substring(0, 1);
        return primeiroCaracter.equals("/");
    }

    
    private boolean validarValor() {
        String valor = varValor.getText().trim();
        if (valor.equals("")) {
            return true;
        } else {
            valor = valor.replace(",", ".");
            double valorSalario = Double.parseDouble(valor);
            if (valorSalario < 0) {
                return true;
            }
        }
        return false;
    }

    
    //metodo para verificar se pagador tem saldo suficiente para realizar transferencia 
    private boolean saldoInsuficiente() {

        double valorTransferencia = Double.parseDouble(varValor.getText().replace(",", "."));
        conta = daoConta.pesquisaPorId(Integer.parseInt(varIdPagador.getText().trim()));

        if (valorTransferencia > conta.getSaldo()) {
            JOptionPane.showMessageDialog(null, "O pagador não possui saldo suficiente para essa operação");
            return true;
        }
        return false;
    }
    
    
    //metodo para limpar campos das variaveis
    private void limpar() {
        varDtTransferencia.setText("");
        varIdPagador.setText("");
        varIdRecebedor.setText("");
        varValor.setText("");
    }

    
    //metodo para vizualizar todas as transferencias no banco de daods
    public void listar() {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        for (Transferencia objetos : Operacao.listar()) {
            modelo.addRow(new Object[]{
                objetos.getIdtransferencia(),
                objetos.getDtTransferencia(),
                objetos.getValor(),
                objetos.getPagador().getId(),
                objetos.getRecebedor().getId()
            });
        }
    }

    //metodo para pesquisar transferencia de acordo com o id do pagador
    public void pesquisaId(int idTransferencia) {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        for (Transferencia objetos : Operacao.pesquisaIdPagador(idTransferencia)) {
            modelo.addRow(new Object[]{
                objetos.getIdtransferencia(),
                objetos.getDtTransferencia(),
                objetos.getValor(),
                objetos.getPagador().getId(),
                objetos.getRecebedor().getId()
            });
        }
    }

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
            java.util.logging.Logger.getLogger(TransferenciaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransferenciaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransferenciaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransferenciaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransferenciaTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisaIdPagador;
    private javax.swing.JButton btRealizarTransferencia;
    private javax.swing.JButton btVizualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuDespesas;
    private javax.swing.JMenu menuFinancas;
    private javax.swing.JMenu menuOperações;
    private javax.swing.JMenuItem menuReceitas;
    private javax.swing.JMenuItem menuTransferencia;
    private javax.swing.JTable tabela;
    private javax.swing.JFormattedTextField varDtTransferencia;
    private javax.swing.JFormattedTextField varIdPagador;
    private javax.swing.JFormattedTextField varIdRecebedor;
    private javax.swing.JFormattedTextField varPesquisaIdPagador;
    private javax.swing.JFormattedTextField varValor;
    // End of variables declaration//GEN-END:variables
}