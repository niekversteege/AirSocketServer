package nl.dpf.airsocketserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Niek
 * Date: 14-6-13
 * Time: 18:48
 * To change this template use File | Settings | File Templates.
 */
public class TestClientMain {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        InetSocketAddress socketAddress = new InetSocketAddress("localhost", 13337);
        socket.connect(socketAddress, 10);
    }
}
