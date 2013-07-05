package nl.dpf.airsocketserver.server;

import sun.security.util.BigInt;

import java.net.InetAddress;

/**
 * Created with IntelliJ IDEA.
 * User: niek
 * Date: 6/14/13
 * Time: 4:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    private final String clientName;
    private final InetAddress inetAddress;

    public Client(final String clientName, final InetAddress inetAddress) {
        this.clientName = clientName;
        this.inetAddress = inetAddress;
    }

    public String getClientName() {
        return clientName;
    }

    public void kick() {
        /* TODO: Notify the client that it is going to be removed. */

        stop();
    }

    public void stop() {

        /* TODO: Stop the connections to the client */
    }
}
