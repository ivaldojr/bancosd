/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivaldojunior
 */
public class ServidorMulticast extends Thread{
    
    public ServidorMulticast(){
        
    }
    
    public void run(){
        while(true){
            try {
                int port = 13000;
                InetAddress ender = InetAddress.getLocalHost();
                String host = ender.getHostName();
                String endereco = ender.getHostAddress();
                byte[] endB = endereco.getBytes();
                InetAddress addr = InetAddress.getByName("239.0.0.1");
                DatagramSocket ds = new DatagramSocket();
                DatagramPacket pkg = new DatagramPacket(endB, endB.length, addr, port);
                ds.send(pkg);
                Thread.sleep(1000);
                String ip = new String(pkg.getData());
                System.out.println("Server:"+ip);
                
            } catch (UnknownHostException ex) {
                Logger.getLogger(ServidorMulticast.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SocketException ex) {
                Logger.getLogger(ServidorMulticast.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ServidorMulticast.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServidorMulticast.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
