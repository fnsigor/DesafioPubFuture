/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pubfuture.bean.Conta;
import pubfuture.regra_negocio.RegraNegocio;

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
    
    public void salvar(Conta conta) throws Exception {

        sql = "INSERT INTO CONTA(TIPO, INSTITUICAO, SALDO, NUMEROCONTA) VALUES (?, ?, ?, ?)";
        try {
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, conta.getTipo());
            ps.setString(2, conta.getInstituicao());
            ps.setDouble(3, conta.getSaldo());
            ps.setString(4, conta.getNumeroconta());
            ps.executeUpdate();
            result = ps.getGeneratedKeys();
            result.next();
            conta.setId(result.getInt(1));
        } catch(Exception e){
            System.out.println("erro ao salvar");
            System.out.println(e.getMessage());
            
        }
       
    }

    

    public void alterar(Conta Conta) {

        sql = "UPDATE CONTA SET TIPO=?, INSTITUICAO=?, SALDO=? WHERE IDCONTA=?";
        try {
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql);
            ps.setString(1, conta.getTipo());
            ps.setString(2, conta.getInstituicao());
            ps.setDouble(3, conta.getSaldo());
            ps.setInt(4, conta.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao alterar");
            System.out.println(e.getMessage());

        }
    }

    public Conta pesquisaPorId(Integer id) {
        sql = "SELECT * FROM CONTA WHERE IDCONTA=?";
        try {
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            result = ps.executeQuery();

            if (result.next()) {
                conta = new Conta();
                conta.setId(result.getInt("idconta"));
                conta.setInstituicao(result.getString("instituicao"));
                conta.setTipo(result.getString("tipo"));
                conta.setSaldo(result.getDouble("saldo"));
            }
        } catch (Exception e) {
            System.out.println("erro ao pesquisar por id");
            System.out.println(e.getMessage());
        }
        return conta;
    }

    public void deletar(int id) {
        sql = "DELETE FROM CONTA WHERE IDCONTA  =?";
        try {
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao deletar por id");
            System.out.println(e.getMessage());
        }
    }

    public List<Conta> listar() {
        sql = "SELECT * FROM CONTA";
        List<Conta> contas = new ArrayList<>();
        try {
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql);
            result = ps.executeQuery();

            while (result.next()) {
                conta = new Conta();
                conta.setId(result.getInt("idconta"));
                conta.setInstituicao(result.getString("instituicao"));
                conta.setTipo(result.getString("tipo"));
                conta.setSaldo(result.getDouble("saldo"));
                contas.add(conta);
            }

        } catch (Exception e) {
            System.out.println("erro ao listar");
            System.out.println(e.getMessage());
        }

        return contas;
    }

    public List<Conta> pesquisaPorInstitucao(String instituicao) {
        sql = "SELECT * FROM CONTA WHERE INSTITUICAO LIKE ?";
        List<Conta> contas = new ArrayList<>();

        try {
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + instituicao + "%");
            result = ps.executeQuery();

            while (result.next()) {
                conta = new Conta();
                conta.setId(result.getInt("idconta"));
                conta.setInstituicao(result.getString("instituicao"));
                conta.setTipo(result.getString("tipo"));
                conta.setSaldo(result.getDouble("saldo"));
                conta.setNumeroconta(result.getString("numeroconta0"));
                contas.add(conta);
            }

        } catch (Exception e) {
            System.out.println("erro ao pesquisar por nome");
            System.out.println(e.getMessage());
        }
        return contas;
    }

}
