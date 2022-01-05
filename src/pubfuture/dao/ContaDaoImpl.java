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

/**
 *
 * @author Igor Fernandes
 */
public class ContaDaoImpl {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet result;
    private String sql;
    private Conta conta;

    public void salvar(Conta conta) {

        sql = "INSERT INTO CONTA(TIPO, INSTITUICAO, SALDO) VALUES (?, ?, ?)";
        try {
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, conta.getTipo());
            ps.setString(2, conta.getInstituicao());
            ps.setDouble(3, conta.getSaldo());
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
            result.next();
            conta.setId(result.getInt(1));

        } catch (Exception e) {
            System.out.println("Erro ao salvar" + e.getMessage());
        }
    }

}
