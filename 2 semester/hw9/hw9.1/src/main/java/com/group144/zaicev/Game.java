package com.group144.zaicev;

/**
 * interface for two sockets client and server
 */
public interface Game {
    /**
     * sends command
     * @param command your command
     */
    void send(String command);

    /**
     * returns the received command
     */
    String receive();
}
