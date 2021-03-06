/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pubfuture.bean.Conta;
import pubfuture.bean.Receitas;
import pubfuture.dao.ContaDaoImpl;
import pubfuture.dao.ReceitasDaoImpl;
import sun.font.TrueTypeFont;

/**
 *
 * @author Igor Fernandes
 */

//TENTAR EXIBIR DESCRIÇÃO COMPLETA AO PASSAR O MOUSE POR CIMA DO REGISTRO

public class ReceitasTela extends javax.swing.JFrame {
    
    //declarados globalmente para evitar repetições
    Receitas receita = new Receitas();
    ReceitasDaoImpl daoReceita = new ReceitasDaoImpl();
    Conta conta = new Conta();
    ContaDaoImpl daoConta = new ContaDaoImpl();
    List<Receitas> receitas;
    DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

    public ReceitasTela() {
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

        panelDados = new javax.swing.JPanel();
        varDtRecebimento = new javax.swing.JFormattedTextField();
        varDtRecEsperado = new javax.swing.JFormattedTextField();
        varValor = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        varDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btPesquisa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        varPesquisa = new javax.swing.JFormattedTextField();
        varIdConta = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        btVizualizar = new javax.swing.JButton();
        btPesquisaIdConta = new javax.swing.JButton();
        varPesquisaIdConta = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jMenuBar4 = new javax.swing.JMenuBar();
        menuFinancas3 = new javax.swing.JMenu();
        menuDespesas = new javax.swing.JMenuItem();
        menuOperações = new javax.swing.JMenu();
        menuTransferencia = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Receitas");

        try {
            varDtRecebimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            varDtRecEsperado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel1.setText("Data de recebimento:");

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel2.setText("Data esperada de recebimento:");

        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel3.setText("Descrição:");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Salário", "Presente", "Prêmio", "Outros" }));

        jLabel4.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel4.setText("Tipo:");

        jLabel5.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel5.setText("Valor:");

        btPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pubfuture/icons/procurar (2).png"))); // NOI18N
        btPesquisa.setToolTipText("Pesquisar receita por ID");
        btPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel6.setText("ID Receita:");

        btCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pubfuture/icons/adicionar.png"))); // NOI18N
        btCadastrar.setToolTipText("Registrar Receita");
        btCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pubfuture/icons/vire-a-direita.png"))); // NOI18N
        btAtualizar.setToolTipText("Atualizar receita");
        btAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pubfuture/icons/lixo.png"))); // NOI18N
        btDeletar.setToolTipText("Excluir receita");
        btDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel7.setText("ID Conta:");

        btVizualizar.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        btVizualizar.setText("Vizualizar todas as receitas");
        btVizualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btVizualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVizualizarActionPerformed(evt);
            }
        });

        btPesquisaIdConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pubfuture/icons/procurar (2).png"))); // NOI18N
        btPesquisaIdConta.setToolTipText("Pesquisar receita por ID da conta");
        btPesquisaIdConta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPesquisaIdConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaIdContaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel8.setText("ID Conta:");

        javax.swing.GroupLayout panelDadosLayout = new javax.swing.GroupLayout(panelDados);
        panelDados.setLayout(panelDadosLayout);
        panelDadosLayout.setHorizontalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varDtRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(70, 70, 70)
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(varDtRecEsperado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDadosLayout.createSequentialGroup()
                                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelDadosLayout.createSequentialGroup()
                                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50))
                                    .addGroup(panelDadosLayout.createSequentialGroup()
                                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)))
                                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(varIdConta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(21, 21, 21)
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varValor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(varPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btVizualizar)
                    .addGroup(panelDadosLayout.createSequentialGroup()
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(varPesquisaIdConta, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisaIdConta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        panelDadosLayout.setVerticalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosLayout.createSequentialGroup()
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(btPesquisaIdConta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(varDtRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varDtRecEsperado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(varDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosLayout.createSequentialGroup()
                                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(varIdConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varPesquisaIdConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGap(1, 1, 1)))
                .addGap(18, 18, 18)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btVizualizar)
                    .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tabela.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Receita", "Dt Recebimento", "Dt Recebimento esperado", "Descrição", "Tipo", "ID Conta", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true
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
        jScrollPane1.setViewportView(tabela);

        menuFinancas3.setText("Finanças");
        menuFinancas3.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N

        menuDespesas.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        menuDespesas.setText("Despesas");
        menuDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDespesasActionPerformed(evt);
            }
        });
        menuFinancas3.add(menuDespesas);

        jMenuBar4.add(menuFinancas3);

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

        jMenuBar4.add(menuOperações);

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

        jMenuBar4.add(jMenu1);

        setJMenuBar(jMenuBar4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //botao para pesquisar receita pelo id da receita
    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        pesquisaId(Integer.parseInt(varPesquisa.getText().trim()));
    }//GEN-LAST:event_btPesquisaActionPerformed

    
    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        //se os valores informados passrem pela validação
        if (!temErro()) {
            try {
                //setando valores formatados das datas nas variaveis -- foi necessário usar um Try-Catch para isso
                String dataString = varDtRecebimento.getText();
                receita.setDtrecebimento(new java.sql.Date(fmt.parse(dataString).getTime()));
                dataString = varDtRecEsperado.getText();
                receita.setDtrecesperado(new java.sql.Date(fmt.parse(dataString).getTime()));
                
                //setando o restante dos valores nas variaveis
                receita.setDescricao(varDescricao.getText().trim());
                receita.setTipo((String) comboTipo.getSelectedItem());
                receita.setValor(Double.parseDouble(varValor.getText().trim().replace(",", ".")));
                conta = daoConta.pesquisaPorId(Integer.parseInt(varIdConta.getText()));
                receita.setConta(conta);
                
                //salvando no banco
                daoReceita.registarReceita(receita);
                
                //informando que o processo foi bem sucedido, limpando os campos e mostrando os novos registros no banco
                JOptionPane.showMessageDialog(null, "Receita registrada com sucesso");
                limparCampos();
                listar();
            } catch (ParseException ex) {
                Logger.getLogger(ReceitasTela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    
    //Coloca dados da tabela nos campos das variáveis, para realizar a atualização
    //Não foi possível incluir as datas nos campos das varíveis devido a formatação dos campos
    //Sempre que for atualizar algo terá que informar as datas manualmente
    private void tabelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyReleased
        //se um registro foi selecionado
        if (tabela.getSelectedRow() != -1) {
            varDtRecebimento.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
            varDtRecEsperado.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
            varDescricao.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
            comboTipo.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
            varIdConta.setText(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
            varValor.setText(tabela.getValueAt(tabela.getSelectedRow(), 6).toString());
        }
    }//GEN-LAST:event_tabelaKeyReleased

    
    //Coloca dados da tabela nos campos das variáveis, para realizar a atualização
    //Não foi possível incluir as datas nos campos das varíveis devido a formatação dos campos
    //Sempre que for atualizar algo terá que informar as datas manualmente
    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        //se um registro foi selecionado
        if (tabela.getSelectedRow() != -1) {
            varDtRecebimento.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
            varDtRecEsperado.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
            varDescricao.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
            comboTipo.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
            varIdConta.setText(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
            varValor.setText(tabela.getValueAt(tabela.getSelectedRow(), 6).toString());
        }
    }//GEN-LAST:event_tabelaMouseClicked

    //Método para atualizar dados da receita. É possível alterar tudo menos a conta a qual a receita pertence
    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
       //para verificar se as datas foram preenchidas antes de executar o método      
        if (validarDtRecebimento()) {
            JOptionPane.showMessageDialog(null, "Insira a data de recebimento");
        }
        if (validarDtRecEsperado()) {
            JOptionPane.showMessageDialog(null, "Insira a data esperada de recebimento");
        }
        
        //se um registro foi selecionado
        if (tabela.getSelectedRow() != 1) {
            try {
                //pesquisando registros da despesa e conta pelo id na tabela
                receita = daoReceita.pesquisaPorId((int) tabela.getValueAt(tabela.getSelectedRow(), 0));
                conta = daoConta.pesquisaPorId((int) tabela.getValueAt(tabela.getSelectedRow(), 5));
                
                String dataString = varDtRecebimento.getText();
                receita.setDtrecebimento(new java.sql.Date(fmt.parse(dataString).getTime()));
                dataString = varDtRecEsperado.getText();
                receita.setDtrecesperado(new java.sql.Date(fmt.parse(dataString).getTime()));
                receita.setDescricao(varDescricao.getText().trim());
                receita.setTipo((String) comboTipo.getSelectedItem());
                
                //alterando valor no saldo da conta após valor da receita ser alterado
                double contaSaldoAnterior = conta.getSaldo() - receita.getValor();
                double contaNovoSaldo = contaSaldoAnterior + Double.parseDouble(varValor.getText().replace(",", "."));
                conta.setSaldo(contaNovoSaldo);
                daoConta.alterar(conta);
                receita.setValor(Double.parseDouble(varValor.getText().replace(",", ".")));
                
                //informando que o processo foi bem sucedido, limpando os campos e mostrando os novos registros no banco
                daoReceita.alterar(receita);
                JOptionPane.showMessageDialog(null, "Receita atualizada com sucesso");
                limparCampos();
                listar();

            } catch (ParseException ex) {
                Logger.getLogger(ReceitasTela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btAtualizarActionPerformed

    
    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
        //se um registro foi selecionado
        if (tabela.getSelectedRow() != -1) {
           //pegando o id da despesa na tabela
           int id = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);
           
          //alterando o saldo ao excluir receita
          receita = daoReceita.pesquisaPorId(id);
          double novoSaldo = receita.getConta().getSaldo() - receita.getValor();
          int idConta = receita.getConta().getId();
          conta = daoConta.pesquisaPorId(idConta);
          conta.setSaldo(novoSaldo);
          daoConta.alterar(conta);
          
          //informando que o processo foi bem sucedido, limpando os campos e mostrando os novos registros no banco
          daoReceita.deletar(id);
          JOptionPane.showMessageDialog(null, "Conta deletada com sucesso");
          listar();
        }
    }//GEN-LAST:event_btDeletarActionPerformed

    
    //botao para listar todas as receitas no banco 
    private void btVizualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVizualizarActionPerformed
        listar();
    }//GEN-LAST:event_btVizualizarActionPerformed

    
    //botao para pesquisar receita pelo id da conta
    private void btPesquisaIdContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaIdContaActionPerformed
        pesquisaIdConta(Integer.parseInt(varPesquisaIdConta.getText()));
    }//GEN-LAST:event_btPesquisaIdContaActionPerformed

    
    //menu
    private void menuTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTransferenciaActionPerformed
        new TransferenciaTela().setVisible(true);
    }//GEN-LAST:event_menuTransferenciaActionPerformed
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ContaTela().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void menuDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDespesasActionPerformed
        new DespesasTela().setVisible(true);
    }//GEN-LAST:event_menuDespesasActionPerformed
    //meu
    
    
    //METODO PARA VALIDAÇÃO DE DADOS INFORMADOS PARA REGISTRAR RECEITA
    private boolean temErro() {

        if (validarDtRecebimento()) {
            JOptionPane.showMessageDialog(null, "Insira a data de recebimento");
            return true;
        }

        if (validarDtRecEsperado()) {
            JOptionPane.showMessageDialog(null, "Insira a data esperada de recebimento");
            return true;
        }

        if (campoMenorQue3Digitos(varDescricao.getText())) {
            JOptionPane.showMessageDialog(null, "Insira uma descrição válida");
            return true;
        }

        if (validarValor()) {
            JOptionPane.showMessageDialog(null, "Insira um valor válido");
            return true;
        }

        if (varIdConta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Insira uma conta válida");
            return true;
        }
        return false;
    }

    
    //METODOS AUXILIARES
    private boolean validarDtRecebimento() {
        String dataRecebimento = varDtRecebimento.getText().trim();
        String primeiroCaracter = dataRecebimento.substring(0, 1);
        return primeiroCaracter.equals("/");
    }

    
    private boolean validarDtRecEsperado() {
        String dtRecEsperado = varDtRecEsperado.getText().trim();
        String primeiroCaracter = dtRecEsperado.substring(0, 1);
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

    
    private boolean campoMenorQue3Digitos(String valorCampo) {
        return valorCampo.length() < 3;
    }

    //metodo para pesquisar receita pelo id da receita
    private void pesquisaId(int idReceita) {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        for (Receitas objetos : daoReceita.pesquisaIdLista(idReceita)) {
            modelo.addRow(new Object[]{
                objetos.getIdreceitas(),
                objetos.getDtrecebimento(),
                objetos.getDtrecesperado(),
                objetos.getDescricao(),
                objetos.getTipo(),
                objetos.getConta().getId(),
                objetos.getValor()
            });
        }
    }

    //metodo para listar todos os registros no banco
    private void listar() {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        for (Receitas objetos : daoReceita.listar()) {
            modelo.addRow(new Object[]{
                objetos.getIdreceitas(),
                objetos.getDtrecebimento(),
                objetos.getDtrecesperado(),
                objetos.getDescricao(),
                objetos.getTipo(),
                objetos.getConta().getId(),
                objetos.getValor()
            });
        }
    }
    
    //metodo para pesquisar receita pelo id da conta
    private void pesquisaIdConta(int idConta) {

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        for (Receitas objetos : daoReceita.pesquisaIdContaLista(idConta)) {
            modelo.addRow(new Object[]{
                objetos.getIdreceitas(),
                objetos.getDtrecebimento(),
                objetos.getDtrecesperado(),
                objetos.getDescricao(),
                objetos.getTipo(),
                objetos.getConta().getId(),
                objetos.getValor()
            });
        }
    }

    //metodo para limpar os campos das variavéis
    private void limparCampos() {
        varDtRecebimento.setText("");
        varDtRecEsperado.setText("");
        varDescricao.setText("");
        varIdConta.setText("");
        varValor.setText("");
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
            java.util.logging.Logger.getLogger(ReceitasTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceitasTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceitasTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceitasTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceitasTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btPesquisa;
    private javax.swing.JButton btPesquisaIdConta;
    private javax.swing.JButton btVizualizar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuDespesas;
    private javax.swing.JMenu menuFinancas3;
    private javax.swing.JMenu menuOperações;
    private javax.swing.JMenuItem menuTransferencia;
    private javax.swing.JPanel panelDados;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField varDescricao;
    private javax.swing.JFormattedTextField varDtRecEsperado;
    private javax.swing.JFormattedTextField varDtRecebimento;
    private javax.swing.JFormattedTextField varIdConta;
    private javax.swing.JFormattedTextField varPesquisa;
    private javax.swing.JFormattedTextField varPesquisaIdConta;
    private javax.swing.JFormattedTextField varValor;
    // End of variables declaration//GEN-END:variables
}
