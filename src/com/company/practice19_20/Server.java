package com.company.practice19_20;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.File;

public class Server {
    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[2048];
        StringBuilder history = new StringBuilder();
        HashMap<String, String> names = new HashMap<>();
        ArrayList<InetAddress> addresses = new ArrayList<>();
        ArrayList<Integer> ports = new ArrayList<>();
        DatagramSocket socket = new DatagramSocket(9087);
        DatagramPacket packet = new DatagramPacket(
                buffer,
                0,
                buffer.length);

        System.out.println("Chat for chatting" + "\n");

        Thread server = new Thread(() -> {
            while (true) {
                DatagramPacket toPacket;
                StringBuffer toMessage = new StringBuffer();
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date date;
                try {
                    socket.receive(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String message = new String(buffer, 0, packet.getLength());
                date = new Date();
                toMessage.append(dateFormat.format(date) + " | ");

                if (names.get(packet.getAddress().getHostAddress() + packet.getPort()) == null
                        || ports.indexOf(packet.getPort()) == -1) {
                    names.put(packet.getAddress().getHostAddress() + packet.getPort(), message);
                    toMessage.append("Server: Hi, " + message);
                    addresses.add(packet.getAddress());
                    ports.add(packet.getPort());
                } else {
                    toMessage.append(names.get(packet.getAddress().getHostAddress() + packet.getPort()) + ": " + message);
                }

                for (int i = 0; i < addresses.size(); i++) {
                    if (!(packet.getAddress() == addresses.get(i) && packet.getPort() == ports.get(i))) {
                        toPacket = new DatagramPacket(toMessage.toString().getBytes(),
                                0,
                                toMessage.toString().getBytes().length,
                                addresses.get(i),
                                ports.get(i));
                        try {
                            socket.send(toPacket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                System.out.println("Address: " + packet.getAddress());
                System.out.println("Port: " + packet.getPort());
                System.out.println(toMessage + "\n");

                File file = new File("src/com/company/practice19_20/history.txt");
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                history.append(toMessage.toString() + "\n");
                try (PrintWriter writerFile = new PrintWriter(file)) {
                    writerFile.write(history.toString());
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
        });
        server.start();
    }
}