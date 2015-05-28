/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivaldojunior
 */
public class ServidorSocket {

    public static void main(String args[]) throws SocketException {

        try {
            int port = 2525;
            DatagramSocket socket = new DatagramSocket(port);
            byte[] buffer = new byte[1000];
            System.out.println("Servidor aguardando request");
            DatagramPacket r = new DatagramPacket(buffer, buffer.length);
            socket.receive(r);
            System.out.println("Request recebido de: "+ r.getAddress());
            DatagramPacket resp = new DatagramPacket(r.getData(), r.getLength(), r.getAddress(), r.getPort());
            socket.send(resp);
            socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ServidorSocket.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
