package com.dubbelepuntf.airsocketserver.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lombok.extern.log4j.Log4j;

import com.dubbelepuntf.airsocketserver.Server;


/**
 * Command Line Interface
 */
@Log4j
public class CommandLineInterface implements Runnable {
    
    private Server server;
    
    public CommandLineInterface(Server serverToCommand) {
    	
        server = serverToCommand;
        
    }
    
    private void parse(String input) {
        
        
    }
    
    public void run() {
               
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
        
        while (!Thread.currentThread().isInterrupted()) {
             try {
                 parse(inputBuffer.readLine());
                 
             } catch (IOException e) {
            	 log.error(e.getMessage(), e);
                 Thread.currentThread().interrupt();
                 return;
             }
         }
    }
}