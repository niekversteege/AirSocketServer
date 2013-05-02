package com.dubbelepuntf.airsocketserver;

import com.dubbelepuntf.airsocketserver.cli.CommandLineInterface;

public class AirSocketMain {

    /** 
     * @param args
     */
    public static void main(String[] args) {
        
        Server server               = new Server();
        CommandLineInterface cli    = new CommandLineInterface(server);
        
        new Thread(server).start();
        new Thread(cli).start();

    }
}