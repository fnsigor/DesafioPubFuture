/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.dao;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import pubfuture.bean.Conta;
import pubfuture.bean.Despesas;
import pubfuture.bean.Transferencia;

/**
 *
 * @author Igor Fernandes
 */
public class OperacoesDaoImpl {

    private Connection connection;
    private PreparedStatement psDevedor;
    private PreparedStatement psRecebedor;
    private PreparedStatement psTransferencia;
    private String sqlRecebedor;
    private String sqlDevedor;
    private String SqlTransferencia;
    private Despesas despesa;
    private ContaDaoImpl contaDao;
    private Transferencia transferencia;
     private ResultSet result;

    public void transferencia(int idPagador, int idRecebedor, double valorTransferencia) {

        sqlDevedor = "UPDATE CONTA SET SALDO=? WHERE IDCONTA=?";
        sqlRecebedor = "UPDATE CONTA SET SALDO=? WHERE IDCONTA=?";

        try {

            contaDao = new ContaDaoImpl();
            connection = ConnectionFactory.abreConexao();
            psDevedor = connection.prepareStatement(sqlDevedor);
            psRecebedor = connection.prepareStatement(sqlRecebedor);

            Conta pagador = contaDao.pesquisaPorId(idPagador);
            Conta recebedor = contaDao.pesquisaPorId(idRecebedor);

            double novoSaldoPagador = pagador.getSaldo() - valorTransferencia;
            double novoSaldoRecebedor = recebedor.getSaldo() + valorTransferencia;

            psDevedor.setDouble(1, novoSaldoPagador);
            psDevedor.setInt(2, idPagador);
            psRecebedor.setDouble(1, novoSaldoRecebedor);
            psRecebedor.setInt(2, idRecebedor);

            psDevedor.executeUpdate();
            psRecebedor.executeUpdate();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public void transferenciaHistorico(Transferencia transferencia) {
        
        //comandos sql que serão utilizados no método
        SqlTransferencia = "INSERT INTO TRANSFERENCIAS(VALOR, DTTRANSFERENCIA, IDPAGADOR, IDRECEBEDOR) VALUES(?, ?, ?, ?)";
        sqlDevedor = "UPDATE CONTA SET SALDO=? WHERE IDCONTA=?";
        sqlRecebedor = "UPDATE CONTA SET SALDO=? WHERE IDCONTA=?";

        try {
           
           //preparanndo conexao 
           connection = ConnectionFactory.abreConexao();
           psTransferencia = connection.prepareStatement(SqlTransferencia,PreparedStatement.RETURN_GENERATED_KEYS);
           
            
           //setando os valores na instancia do objeto 
           psTransferencia.setDouble(1, transferencia.getValor());
           psTransferencia.setDate(2, new Date(transferencia.getDtTransferencia().getTime()));
           psTransferencia.setObject(3, transferencia.getPagador().getId());
           psTransferencia.setObject(4, transferencia.getRecebedor().getId());
           
           
           //colocando a instancia de objeto no banco e colocando a id gerada na instancia de objeto
           psTransferencia.executeUpdate();
           result = psTransferencia.getGeneratedKeys();
           result.next();
           transferencia.setIdtransferencia(result.getInt(1));
           
           
           //preparando para atualizar saldos apos transferencia
           psDevedor = connection.prepareStatement(sqlDevedor);
           psRecebedor = connection.prepareStatement(sqlRecebedor);
           
           
           //definindo pagador/recebedor e valor dos saldos atualizados
           Conta pagador = transferencia.getPagador();
           Conta recebedor = transferencia.getRecebedor();
           double novoSaldoPagador = pagador.getSaldo() - transferencia.getValor();
           double novoSaldoRecebedor = recebedor.getSaldo() + transferencia.getValor();
           
           
           //setando valores nos comandos sql para atualizar saldos
           psDevedor.setDouble(1, novoSaldoPagador);
           psDevedor.setInt(2, transferencia.getPagador().getId());
           psRecebedor.setDouble(1, novoSaldoRecebedor);
           psRecebedor.setInt(2, transferencia.getRecebedor().getId());
          
           
           //atualizando saldos
           psDevedor.executeUpdate();
           psRecebedor.executeUpdate();
           
           
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao executar transferência");
            System.out.println("Erro ao executar transferência");
            System.out.println(e.getMessage());
        }

    }

}
