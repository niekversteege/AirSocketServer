package nl.dpf.airsocketserver.server;

import lombok.extern.log4j.Log4j;
import nl.dpf.airsocketserver.connections.ConnectionHandler;

import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: niek
 * Date: 6/14/13
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
@Log4j
public class ServerController implements Observer {

    private final List<Client> clientList;
    private ConnectionHandler connectionHandler;
    private Thread connThread;
    private int nrOfClients;

    public ServerController() {

        log.info("Starting server.");

        clientList = new ArrayList<>();
        connectionHandler = new ConnectionHandler();
        connThread = new Thread(connectionHandler);
        initConnectionHandler();
        nrOfClients = 0;
    }

    private void initConnectionHandler() {

        connectionHandler.addObserver(this);
        connThread.start();
    }

    public synchronized boolean stop() {

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

    public final List<Client> getClientList() {
        return Collections.unmodifiableList(clientList);
    }

    public boolean kickClient(final String clientName) {
        Client toRemove = findAndRemoveClientByName(clientName);

        if (toRemove != null) {
            toRemove.kick();

            return true;
        } else {
            log.warn("Tried to kick client that was not found.");
        }

        return false;
    }

    private Client findAndRemoveClientByName(final String clientName) {

        Client c = null;

        int nrClients = clientList.size();

        if (nrClients > 0) {
            int i = 0;
            for (i = 0; i < nrClients; i++) {
                Client a = clientList.get(i);

                if (a.getClientName().equals(clientName)) {

                    break;
                }
            }

            c = clientList.remove(i);
        }

        return c;
    }
}
