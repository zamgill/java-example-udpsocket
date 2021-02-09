package com.zgill.udpexample;

import java.net.*;
import java.io.*;

public class UDPServer {
    public static void main(String[] args) {
        try (DatagramSocket aSocket = new DatagramSocket(6789)) {
            byte[] buffer = new byte[1000];

            while(true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);

                // Build the reply
                DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), request.getAddress(), request.getPort());
                aSocket.send(reply);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}
