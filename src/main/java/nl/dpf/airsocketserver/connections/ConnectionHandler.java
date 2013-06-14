package nl.dpf.airsocketserver.connections;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

/**
 * ConnectionHandler: listen socket that accepts new clients.
 */
@Log4j
public class ConnectionHandler extends Observable implements Runnable {

    private static final int DEFAULT_PORT = 13337;

    private volatile boolean running;
    private int port;

    private ServerSocket serverSocket;

    public ConnectionHandler() {
        this(DEFAULT_PORT);
        ConnectionHandler.log.info("No port given. Using default.");
    }

    public ConnectionHandler(final int port) {
        running = true;
        this.port = port;

        initSocket();
    }

    private void initSocket() {
        try {
            serverSocket = new ServerSocket(this.port);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public synchronized void run() {

        ConnectionHandler.log.info("Starting listensocket on port " + port + ".");
        
        while (running) {
            try {
                Socket newSocket = serverSocket.accept();
                setChanged();
                notifyObservers(newSocket);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    public synchronized void stop() {

        try {
            log.debug("closing socket");
            running = false;
            serverSocket.close();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            log.info("No longer accepting new clients. Closing.");
        }
    }
}