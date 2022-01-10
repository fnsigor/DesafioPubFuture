/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pubfuture.bean.Conta;
import pubfuture.bean.Despesas;

/**
 *
 * @author Igor Fernandes
 */
public class OperacoesDaoImpl {

    private Connection connection;
    private PreparedStatement psDevedor;
    private PreparedStatement psRecebedor;
    private String sqlRecebedor;
    private String sqlDevedor;
    private Despesas despesa;
    private ContaDaoImpl contaDao;

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

}
