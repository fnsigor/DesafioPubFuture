/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pubfuture.bean.Conta;
import pubfuture.dao.ContaDaoImpl;
import pubfuture.regra_negocio.RegraNegocio;

/**
 *
 * @author Igor Fernandes
 */
public class ContaTela extends javax.swing.JFrame {
    
    ContaDaoImpl dao = new ContaDaoImpl();
    Conta objeto = new Conta();
    RegraNegocio regraNegocio = new RegraNegocio();
    
    public ContaTela() {
        initComponents();
        pesquisaInstituicao("");
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        panelPrincipal = new javax.swing.JPanel();
        panelDados = new javax.swing.JPanel();
        varInstituicao = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox<>();
        varSaldo = new javax.swing.JFormattedTextField();
        btCadastrar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        varPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        varIdPesquisa = new javax.swing.JFormattedTextField();
        btPesquisaId = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PanelScrollTabela = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFinancas = new javax.swing.JMenu();
        menuReceitas = new javax.swing.JMenuItem();
        menuDespesas = new javax.swing.JMenuItem();
        menuOperações = new javax.swing.JMenu();
        menuTransferencia = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal - Contas");

        comboTipo.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carteira ", "Conta Corrente", "Poupança" }));
        comboTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btCadastrar.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        btCadastrar.setText("Cadastrar Conta");
        btCadastrar.setToolTipText("Cadastrar Conta");
        btCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pubfuture/icons/vire-a-direita.png"))); // NOI18N
        btAtualizar.setToolTipText("Atualizar");
        btAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAtualizar.setMaximumSize(new java.awt.Dimension(81, 23));
        btAtualizar.setMinimumSize(new java.awt.Dimension(81, 23));
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pubfuture/icons/lixo.png"))); // NOI18N
        btDeletar.setToolTipText("Excluir");
        btDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btDeletar.setMaximumSize(new java.awt.Dimension(81, 23));
        btDeletar.setMinimumSize(new java.awt.Dimension(81, 23));
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pubfuture/icons/procurar (2).png"))); // NOI18N
        btPesquisar.setToolTipText("Pesquisar");
        btPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel1.setText("Instituição:");

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel2.setText("Tipo de Conta:");

        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel3.setText("Saldo:");

        jLabel4.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel4.setText("Pesquisa por Instituição:");

        btPesquisaId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pubfuture/icons/procurar (2).png"))); // NOI18N
        btPesquisaId.setToolTipText("Pesquisar");
        btPesquisaId.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPesquisaId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaIdActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel5.setText("Pesquisa por ID:");

        jLabel6.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Excluir");

        jLabel7.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel7.setText("Atualizar");

        javax.swing.GroupLayout panelDadosLayout = new javax.swing.GroupLayout(panelDados);
        panelDados.setLayout(panelDadosLayout);
        panelDadosLayout.setHorizontalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosLayout.createSequentialGroup()
                                .addComponent(varInstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(varPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(varIdPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(panelDadosLayout.createSequentialGroup()
                                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(varSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(comboTipo, 0, 130, Short.MAX_VALUE)
                                    .addComponent(btCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(38, 38, 38)))
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDadosLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btPesquisaId, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41))))
        );
        panelDadosLayout.setVerticalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(varPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varInstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btPesquisar))
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3))
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varIdPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btPesquisaId, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addComponent(varSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabela.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tipo", "Instituição", "Saldo", "Número Conta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        tabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaKeyReleased(evt);
            }
        });
        PanelScrollTabela.setViewportView(tabela);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelScrollTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelScrollTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
        );

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

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        //Setando valores na instancia de objeto após validação dos mesmos
        if (!temErro()) {
            objeto.setInstituicao(varInstituicao.getText().trim());
            objeto.setTipo((String) comboTipo.getSelectedItem());
            objeto.setSaldo(Double.parseDouble(varSaldo.getText().replace(",", ".")));
            objeto.setNumeroconta(regraNegocio.gerarNumeroConta());
            dao.salvar(objeto);
            
            JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso!");
            varInstituicao.setText("");
            varSaldo.setText("");
            pesquisaInstituicao(varPesquisa.getText());
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        pesquisaInstituicao(varPesquisa.getText().trim());
    }//GEN-LAST:event_btPesquisarActionPerformed

    
    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        if (tabela.getSelectedRow() != -1) {
            objeto = dao.pesquisaPorId((int) tabela.getValueAt(tabela.getSelectedRow(), 0));
            objeto.setInstituicao(varInstituicao.getText().trim());
            objeto.setTipo((String) comboTipo.getSelectedItem());
            objeto.setSaldo(Double.parseDouble(varSaldo.getText().replace(",", ".")));
            dao.alterar(objeto);
            
            JOptionPane.showMessageDialog(null, "Conta alterada com sucesso!");
            varInstituicao.setText("");
            varSaldo.setText("");
            pesquisaInstituicao(varPesquisa.getText());
        }
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void tabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyReleased
        if (tabela.getSelectedRow() != -1) {
            comboTipo.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
            varInstituicao.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
            varSaldo.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_tabelaKeyReleased

    
    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (tabela.getSelectedRow() != -1) {
            comboTipo.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
            varInstituicao.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
            varSaldo.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_tabelaMouseClicked

    
    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
        if (tabela.getSelectedRow() != -1) {
            int id = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);
            dao.deletar(id);
            pesquisaInstituicao(varPesquisa.getText().trim());
        }
    }//GEN-LAST:event_btDeletarActionPerformed

    
    private void btPesquisaIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaIdActionPerformed
        pesquisaId(Integer.parseInt(varIdPesquisa.getText().trim()));
    }//GEN-LAST:event_btPesquisaIdActionPerformed

    
    private void menuTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTransferenciaActionPerformed
        new TransferenciaTela().setVisible(true);
    }//GEN-LAST:event_menuTransferenciaActionPerformed

    
    private void menuDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDespesasActionPerformed
        new DespesasTela().setVisible(true);
    }//GEN-LAST:event_menuDespesasActionPerformed

    
    private void menuReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReceitasActionPerformed
    new ReceitasTela().setVisible(true);
    }//GEN-LAST:event_menuReceitasActionPerformed
    
    
    public boolean temErro() {
        
        if (campoMenorQue3(varInstituicao.getText())) {
            JOptionPane.showMessageDialog(null, "Insira uma instituição válida");
            return true;
        }
        
        if (validarSaldo()) {
            JOptionPane.showMessageDialog(null, "Insira um saldo válido");
            return true;
        }
        
        return false;
    }
    
    
    private boolean validarSaldo() {
        String saldo = varSaldo.getText().trim();
        if (saldo.equals("")) {
            return true;
        } else {
            saldo = saldo.replace(",", ".");
            double valorSalario = Double.parseDouble(saldo);
            if (valorSalario < 0) {
                return true;
            }
        }
        
        return false;
    }

    //METODOS AUXILIARES
    private boolean campoMenorQue3(String campoValor) {
        return campoValor.length() < 3;
        
    }
    
    public void pesquisaInstituicao(String instituicao) {
        
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        
        for (Conta objetos : dao.pesquisaPorInstitucao(instituicao)) {
            modelo.addRow(new Object[]{
                objetos.getId(),
                objetos.getTipo(),
                objetos.getInstituicao(),
                objetos.getSaldo(),
                objetos.getNumeroconta()
            });
            
        }
        
    }
    
    public void pesquisaId(int idConta) {
        
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        
        for (Conta objetos : dao.pesquisaIdLista(idConta)) {
            modelo.addRow(new Object[]{
                objetos.getId(),
                objetos.getTipo(),
                objetos.getInstituicao(),
                objetos.getSaldo(),
                objetos.getNumeroconta()
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
            java.util.logging.Logger.getLogger(ContaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContaTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane PanelScrollTabela;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btPesquisaId;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuItem menuDespesas;
    private javax.swing.JMenu menuFinancas;
    private javax.swing.JMenu menuOperações;
    private javax.swing.JMenuItem menuReceitas;
    private javax.swing.JMenuItem menuTransferencia;
    private javax.swing.JPanel panelDados;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tabela;
    private javax.swing.JFormattedTextField varIdPesquisa;
    private javax.swing.JTextField varInstituicao;
    private javax.swing.JTextField varPesquisa;
    private javax.swing.JFormattedTextField varSaldo;
    // End of variables declaration//GEN-END:variables
}
