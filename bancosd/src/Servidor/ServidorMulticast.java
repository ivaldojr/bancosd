/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivaldojunior
 */
public class ServidorMulticast {
    public static void main(String [] args){
        try {
            int port = 2525;
            String ip = "225.4.5.6";
            
            MulticastSocket s  = new MulticastSocket(port);
            s.joinGroup(InetAddress.getByName(ip));
            
            byte buf[] = new byte[1024];
            
            DatagramPacket pacote = new DatagramPacket(buf, buf.length);
            s.receive(pacote);
            
            System.out.println("Dados recebido de:"+ pacote.getAddress().toString()+
                    ":"+ pacote.getPort() + "com tamanho:"+pacote.getLength());
            System.out.write(pacote.getData(),0,pacote.getLength());
            System.out.println("");
            s.leaveGroup(InetAddress.getByName(ip));
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorMulticast.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
