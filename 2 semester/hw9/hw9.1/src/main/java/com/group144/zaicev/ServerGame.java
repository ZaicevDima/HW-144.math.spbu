package com.group144.zaicev;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class for work with client socket
 */
public class ServerGame implements Game {

    public static final int PORT = 12345;
    private ServerSocket server;
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    /**
     * constructor
     */
    ServerGame() {
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error!");
            System.exit(1);
        }
    }

    @Override
    public synchronized void send(String command) {
        init();

        out.println(command);
        out.flush();

    }

    @Override
    public String receive() {
        init();
        return in.lines().limit(1).findAny().get();
    }

    /** initialization */
    private void init() {
        if (client == null) {
            try {
                client = server.accept();
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream());
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}
