package com.dubbelepuntf.airsocketserver;

import com.dubbelepuntf.airsocketserver.cli.CommandLineInterface;

public class AirSocketMain {

    /** 
     * @param args
     */
    public static void main(String[] args) {

        CommandLineInterface cli = new CommandLineInterface();
        cli.start();

    }
}
