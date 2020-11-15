package com.company.practice19_20;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        System.out.println("Enter your name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        byte[] username = name.getBytes();
        socket.send(new DatagramPacket(username, 0, username.length, InetAddress.getByName("192.168.1.2"), 9087));
        Thread receive = new Thread(() -> receiveMessage(socket));
        receive.start();
        Thread send = new Thread(() -> sendMessage(socket));
        send.start();
    }

    public static void receiveMessage(DatagramSocket socket) {
        while (true) {
            try {
                byte[] dataRec = new byte[2048];
                DatagramPacket packet = new DatagramPacket(dataRec, 0, dataRec.length);
                socket.receive(packet);
                String received = new String(
                        dataRec, 0, packet.getLength());
                System.out.println(received);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendMessage(DatagramSocket socket) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                byte[] dataSend = scanner.nextLine().getBytes();
                DatagramPacket packet = new DatagramPacket(
                        dataSend,
                        0, dataSend.length,
                        InetAddress.getByName("255.255.255.255"),
                        9087
                );
                socket.send(packet);
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }
}