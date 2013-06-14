package nl.dpf.airsocketserver.connections;

import lombok.extern.log4j.Log4j;

import java.util.Observable;

/**
 * ConnectionHandler: listen socket that accepts new clients.
 */
@Log4j
public class ConnectionHandler extends Observable implements Runnable {

    private static final short DEFAULT_PORT = 13337;

    private boolean running;
    private short port;

    public ConnectionHandler()
    {
        this(DEFAULT_PORT);
        ConnectionHandler.log.info("No port given. Using default.");
    }

    public ConnectionHandler(final short port) {
        running = true;
        this.port = port;
    }

    public synchronized void run() {

        ConnectionHandler.log.info("Starting listensocket.");
        ConnectionHandler.log.info("Accepting new connections on port " + port + ".");

        while (running) {

        }

    }
}