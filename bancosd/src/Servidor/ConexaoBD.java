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

    public static void main(String args[]) {
        new ConexaoBD();
    }

    public ConexaoBD() {
        try {
            connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Connection conexao;

    public Connection connect() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/sd", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Conexão perdida!");
        }return conexao;

    }
    
    public void desconnect(){
        try{
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
