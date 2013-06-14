package nl.dpf.airsocketserver.server;

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
public class ServerController implements Observer {

    private List<Client> clientList;


    @Override
    public void update(Observable o, Object arg) {
        /* TODO: receive updates from ConnectionHandler and pass it to the ClientFactory */
        /* TODO: add new client to list */
    }
}
