/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivaldojunior
 */
public class ConexaoBD {

    public static Connection ConexaoObter(){
        
        Connection conexao = null;
         
        try{
           Class.forName("com.mysql.jdbc.Driver");
           
           conexao = DriverManager.getConnection("jdbc:mysql://localhost/sd", "root", "");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
         return conexao;
    }
}
