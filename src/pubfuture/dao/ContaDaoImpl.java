/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pubfuture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pubfuture.bean.Conta;

/**
 *
 * @author Igor Fernandes
 */
public class ContaDaoImpl {

    //variaveis globais para não ter que ficar criando toda hora
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet result;
    private String sql;
    private Conta conta;

    
    //metodo para salvar registro no banco
    public void salvar(Conta conta) {

        //definindo comando sql
        sql = "INSERT INTO CONTA(TIPO, INSTITUICAO, SALDO, NUMEROCONTA) VALUES (?, ?, ?, ?)";
        
        try {
            //abrindo conexao com o banco e definindo comando a ser utilizado
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql);
            
            //setando valores no comando de acordo com a posição das colunas do comando
            ps.setString(1, conta.getTipo());
            ps.setString(2, conta.getInstituicao());
            ps.setDouble(3, conta.getSaldo());
            ps.setString(4, conta.getNumeroconta());
            
            //executando comando
            ps.executeUpdate();
            
        } catch(Exception e){
            System.out.println("erro ao salvar");
            System.out.println(e.getMessage());
        }
    }

    
    //metodo para alterar registro no banco
    public void alterar(Conta objeto) {
        
        //definindo comando sql
        sql = "UPDATE CONTA SET TIPO=?, INSTITUICAO=?, SALDO=? WHERE IDCONTA=?";
        
        try {
            //abrindo conexao com o banco e definindo comando a ser utilizado
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql);
            
            //setando valores no registro
            ps.setString(1, objeto.getTipo());
            ps.setString(2, objeto.getInstituicao());
            ps.setDouble(3, objeto.getSaldo());
            ps.setInt(4, objeto.getId());
            
            //executando atualização
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("erro ao alterar");
            System.out.println(e.getMessage());
        }
    }
    

    //metodo para pesquisar registro no banco usanod ID da conta -- retorna instancia de objeto do tipo Conta
    public Conta pesquisaPorId(Integer id) {
        
        //definindo comando sql
        sql = "SELECT * FROM CONTA WHERE IDCONTA=?";
        
        try {
            //abrindo conexao com o banco e definindo comando a ser utilizado
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql);
            
            //setando valor da id informada no comando
            ps.setInt(1, id);
            
            //executando comando de pesquisa no banco
            result = ps.executeQuery();
            
            //caso o comando retornar algum registro do banco
            if (result.next()) {
                //criar instancia de objeto e colocar valores do registro que retornou nessa instancia de objeto
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
        
        //definindo comando sql
        sql = "DELETE FROM CONTA WHERE IDCONTA  =?";
        
        try {
            //abrindo conexao com o banco e definindo comando a ser utilizado
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql);
            
            //setando valor da id informada no comando e executando comando de exclusão
            ps.setInt(1, id);
            ps.executeUpdate();
            
            //esse JOptionPane está aqui pois se estivesse na classe TelaConta, seria informado que o processo foi bem sucedido mesmo se desse erro
            JOptionPane.showMessageDialog(null, "Conta excluída com sucesso");
            
        } catch (Exception e) {
            
            //caso ocorrer um erro, o sistema avisa o usuário através do catch
            JOptionPane.showMessageDialog(null, "Não é possível excluir essa conta. Existem receitas, despesas ou transferências registradas com ela");
            System.out.println("erro ao deletar por id");
            System.out.println(e.getMessage());
        }
    }

    
    //metodo para listar todos os registros do banco
    public List<Conta> listar() {
        
        //definindo comando sql e criando lista que vai receber o resultado do retorno desse metodo
        sql = "SELECT * FROM CONTA";
        List<Conta> contas = new ArrayList<>();
        
        try {
            //abrindo conexao com o banco, definindo comando a ser utilizado e executando comando
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql);
            result = ps.executeQuery();
              
            //enquanto o método trouxer registros do banco
            while (result.next()) {
                //criar instancia de objeto e colocar valores do registro que retornou nessa instancia de objeto
                conta = new Conta();
                conta.setId(result.getInt("idconta"));
                conta.setInstituicao(result.getString("instituicao"));
                conta.setTipo(result.getString("tipo"));
                conta.setSaldo(result.getDouble("saldo"));
                
                //adicionando instancia de objeto na lista que vai retornar
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
        
        //definindo comando sql e criando lista que vai receber o resultado do retorno desse metodo
        sql = "SELECT * FROM CONTA WHERE INSTITUICAO LIKE ?";
        List<Conta> contas = new ArrayList<>();

        try {
            //abrindo conexao com o banco, definindo comando a ser utilizado e executando comando
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql);
            
            //setando valor do parametro em uma string e colocando essa string no comando sql
            ps.setString(1, "%" + instituicao + "%");
            
            //executando comando
            result = ps.executeQuery();
            
            //enquanto o método trouxer registros do banco
            while (result.next()) {
                //criar instancia de objeto e colocar valores do registro que retornou nessa instancia de objeto
                conta = new Conta();
                conta.setId(result.getInt("idconta"));
                conta.setInstituicao(result.getString("instituicao"));
                conta.setTipo(result.getString("tipo"));
                conta.setSaldo(result.getDouble("saldo"));
                conta.setNumeroconta(result.getString("numeroconta"));
                
                //adicionando instancia de objeto na lista que vai retornar
                contas.add(conta);
            }
            
        } catch (Exception e) {
            System.out.println("erro ao pesquisar por nome");
            System.out.println(e.getMessage());
        }
        return contas;
    }
    
    //outro metodo que retorna lista, mas esse usa a id da conta para pesquisar registros
    public List<Conta> pesquisaIdLista(int idConta) {
        
        //definindo comando sql e criando lista que vai receber o resultado do retorno desse metodo
        sql = "SELECT * FROM CONTA WHERE IDCONTA=?";
        List<Conta> contas = new ArrayList<>();
        
        try {
            //abrindo conexao com o banco, definindo comando a ser utilizado e setando valor do parametro no comando
            connection = ConnectionFactory.abreConexao();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idConta);
            
            //executando comando
            result = ps.executeQuery();
            
            //enquanto o método trouxer registros do banco
            while (result.next()) {
                //criar instancia de objeto e colocar valores do registro que retornou nessa instancia de objeto
                conta = new Conta();
                conta.setId(result.getInt("idconta"));
                conta.setInstituicao(result.getString("instituicao"));
                conta.setTipo(result.getString("tipo"));
                conta.setSaldo(result.getDouble("saldo"));
                conta.setNumeroconta(result.getString("numeroconta"));
                
                //adicionando instancia de objeto na lista que vai retornar
                contas.add(conta);
            }
            
        } catch (Exception e) {
            System.out.println("erro ao listar");
            System.out.println(e.getMessage());
        }
        return contas;
    }

}
