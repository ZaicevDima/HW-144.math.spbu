package com.group144.zaicev;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import static com.group144.zaicev.GameController.ipAddress;

/**
 * Class for work with client socket
 */
public class ClientGame implements Game {

    private Socket client;
    private PrintWriter out;
    private BufferedReader in;

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

    /** initialization **/
    private void init() {
        InetAddress inetAddress = null;
        if (client == null) {
            try {
                client = new Socket(inetAddress = InetAddress.getByName(ipAddress.getText()), ServerGame.PORT);
                out = new PrintWriter(client.getOutputStream());
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            } catch (UnknownHostException uhe) {
                assert ipAddress != null;
                System.err.println("Don't know about host: " + inetAddress.getHostAddress());
                System.exit(1);
            } catch (IOException ioe) {
                System.err.println("Couldn't get I/O for the connection to: " + inetAddress.getHostAddress());
                System.exit(1);
            }
        }
    }
}
