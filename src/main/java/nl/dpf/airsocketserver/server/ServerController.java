package nl.dpf.airsocketserver.server;

import lombok.extern.log4j.Log4j;
import nl.dpf.airsocketserver.connections.ConnectionHandler;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: niek
 * Date: 6/14/13
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
@Log4j
public class ServerController implements Observer {

    private List<Client> clientList;
    private ConnectionHandler connectionHandler;
    Thread connThread;
    private int nrOfClients;

    public ServerController() {

        log.info("Starting server.");
        connectionHandler = new ConnectionHandler();
        connThread = new Thread(connectionHandler);
        initConnectionHandler();
        nrOfClients = 0;
    }

    private void initConnectionHandler() {
        connectionHandler.addObserver(this);
        connThread.start();

    }

    public synchronized boolean stop()
    {
        boolean success = false;
        try {
            connectionHandler.getServerSocket().close();
            success = true;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return success;
    }

    @Override
    public void update(Observable o, Object arg) {
        /* TODO: receive updates from ConnectionHandler and pass it to the ClientFactory */
        /* TODO: add new client to list */
        log.debug("Connected clients: " + ++nrOfClients);
    }
}
