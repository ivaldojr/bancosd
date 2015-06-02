/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Servidor.ErroInternoException;
import Servidor.ConexaoBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author -Denys
 */
public class ClienteDAO {

    private CallableStatement cs;
    private Connection connection;
    private PreparedStatement stmt;
    private ResultSet tupla;
    private java.util.List<Cliente> ListaDeClientes= new ArrayList<Cliente>();
    
    public ClienteDAO() {
      this.connection = ConexaoBD.ConexaoObter();
    }
    
    public void CadastrarCliente(Cliente cliente)throws ErroInternoException, SQLException{
        CallableStatement cs = null;
    String sql = "{call INSERIR_CLIENTE (?, ?, ?, ?, ?, ?, ?, ?, ? ,?,?,?)}";
        try{
            cs = this.connection.prepareCall(sql);
            cs.setString(1, cliente.getNome());
            cs.setString(2, cliente.getCpf());
            cs.setString(3, cliente.getTelefone());
            cs.setString(4, cliente.getEstado());
            cs.setString(5, cliente.getCidade());
            cs.setString(6, cliente.getBairro());
            cs.setString(7, cliente.getRua());
            cs.setInt(8, cliente.getNumero());
            cs.setString(9, cliente.getAgencia());
            cs.setString(10, cliente.getConta());
            cs.setDouble(11, cliente.getSaldo());
            cs.setString(12, cliente.getSenha());
            
            cs.executeQuery();
            
        }catch(SQLException e){
            throw new ErroInternoException(e);
        }finally{
            try{
                cs.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public void AtualizarCleinte(Cliente cliente)throws ErroInternoException{
        CallableStatement cs = null;
      
        String sql = "{call ATUALIZA_CLIENTE (?, ?, ?, ?, ? , ? , ?, ?, ?, ?)}";
        
        try{
            
            cs = this.connection.prepareCall(sql);
            cs.setString(1, cliente.getCpf());
            cs.setString(2, cliente.getNome());
            cs.setString(3, cliente.getTelefone());
            cs.setString(4, cliente.getEstado());
            cs.setString(5, cliente.getCidade());
            cs.setString(6, cliente.getBairro());
            cs.setString(7, cliente.getRua());
            cs.setInt(8, cliente.getNumero());
            cs.setString(9, cliente.getAgencia());
            cs.setString(10, cliente.getSenha());
           
            cs.executeQuery();
            
        }catch(SQLException e){
            throw new ErroInternoException(e);
        }finally{
            try{
                cs.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public void ExcluirCleinte(Cliente cliente)throws ErroInternoException{
        CallableStatement cs = null;
      
        String sql = "{call EXCLUIR_CLIENTE (?)}";
        
        try{
            
            cs = this.connection.prepareCall(sql);
            cs.setString(1, cliente.getCpf());
            cs.executeQuery();
            
        }catch(SQLException e){
            throw new ErroInternoException(e);
        }finally{
            try{
                cs.close();
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
     
    public java.util.List<Cliente> ListarClientes(){
        
        try {
            this.connection.createStatement();
            this.stmt = connection.prepareStatement("SELECT * FROM CLIENTE");
            this.ListaDeClientes.clear();
           
            this.tupla = stmt.executeQuery();
            while(this.tupla.next())
            {
                Cliente cliente = new Cliente();
                cliente.setCpf(this.tupla.getString("CPF"));
                cliente.setNome(this.tupla.getString("NOME"));
                cliente.setTelefone(this.tupla.getString("TELEFONE"));
                cliente.setEstado(this.tupla.getString("ESTADO"));
                cliente.setCidade(this.tupla.getString("CIDADE"));
                cliente.setBairro(this.tupla.getString("BAIRRO"));
                cliente.setRua(this.tupla.getString("RUA"));
                cliente.setNumero(this.tupla.getInt("NUMERO"));
                cliente.setAgencia(this.tupla.getString("AGENCIA"));
                cliente.setConta(this.tupla.getString("CONTA"));
 
                this.ListaDeClientes.add(cliente);
                
            }
            this.tupla.close();
            this.stmt.close();
            
            if(this.ListaDeClientes.size()>0)
            return this.ListaDeClientes;
            else
                return null;
        }
        catch(SQLException e){
            System.out.println("Erro: "+e.toString());
            return null;
        }
         
    }
    
    public Cliente buscarCliente(int cpf) throws ErroInternoException{
            try{
                return this.buscarCliente(cpf);
            }
            catch(ErroInternoException eie){
                throw new ErroInternoException(eie);
            }
        }

}
