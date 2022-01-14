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
import javax.swing.JOptionPane;
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
    
    
    //metodo para salvar registro no banco
    public void salvar(Conta conta) {

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

    
    //metodo para alterar registro no banco
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

    //metodo para pesquisar registro no banco usanod ID da conta -- retorna instancia de objeto do tipo Conta
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

    
    //metodo para apagar registro do banco pela id
    public void deletar(int id) {
        
        sql = "DELETE FROM CONTA WHERE IDCONTA  =?";
        
        try {
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Conta excluída com sucesso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não é possível excluir essa conta. Existem receitas, despesas ou transferências registradas com ela");
            System.out.println("erro ao deletar por id");
            System.out.println(e.getMessage());
        }
    }

    
    //metodo para listar todos os registros do banco
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
    
    
    //metodo que retorna lista -- serve para pesquisar registros pelo nome da instituicao
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
                conta.setNumeroconta(result.getString("numeroconta"));
                contas.add(conta);
            }
            
        } catch (Exception e) {
            System.out.println("erro ao pesquisar por nome");
            System.out.println(e.getMessage());
        }
        return contas;
    }
    
    //outro metodo que retorna lista, mas esse usa a id para pesquisar registros
    public List<Conta> pesquisaIdLista(int idConta) {
        
        sql = "SELECT * FROM CONTA WHERE IDCONTA=?";
        List<Conta> contas = new ArrayList<>();
        
        try {
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idConta);
            result = ps.executeQuery();
            
            while (result.next()) {
                conta = new Conta();
                conta.setId(result.getInt("idconta"));
                conta.setInstituicao(result.getString("instituicao"));
                conta.setTipo(result.getString("tipo"));
                conta.setSaldo(result.getDouble("saldo"));
                conta.setNumeroconta(result.getString("numeroconta"));
                contas.add(conta);
            }
            
        } catch (Exception e) {
            System.out.println("erro ao listar");
            System.out.println(e.getMessage());
        }
        return contas;
    }

}
