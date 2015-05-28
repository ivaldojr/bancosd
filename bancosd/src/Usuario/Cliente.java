/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

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
public class Cliente {
    public static void main(String[] args){
        try {
            int port = 2525;
            String ip = "225.4.5.6";
            int t = 1;
            
            MulticastSocket s = new MulticastSocket();
            
            byte buf[] = new byte[10];
            for(int i=0; i<buf.length; i++) buf[i] = (byte)i;
            DatagramPacket pacote = new DatagramPacket(buf, buf.length, InetAddress.getByName(ip), port);
            s.send(pacote, (byte)t);
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
