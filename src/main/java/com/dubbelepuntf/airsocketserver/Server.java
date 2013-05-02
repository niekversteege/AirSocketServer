package com.dubbelepuntf.airsocketserver;

import org.apache.commons.cli.CommandLine;

/**
 *  The server
 */
public class Server implements Runnable {
    
    public Server () {
        
        
        
    }
    
    public void executeCommand(CommandLine commandLine) {
        
        System.out.println("Server executing command: " + commandLine);
        
    }
    
    public synchronized void run() {
        
        System.out.println("Server booting up...");
        
        try {
            while (!Thread.currentThread().isInterrupted()) {
                
                System.out.println("Server heartbeat!");
                wait(30000);
                
            }
        } catch (InterruptedException ex) {
            System.out.println("Server was interrupted! " + ex);
        }
    }
}