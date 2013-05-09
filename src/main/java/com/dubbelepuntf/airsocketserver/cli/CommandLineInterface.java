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
    
    private static final String SPLIT_CHAR = " ";
     
    private Server server;
    private Parser parser = new Parser();
    
    public CommandLineInterface(Server serverToCommand) {
    	
        server = serverToCommand;
        
    }
    
    @Override
    public void run() {
               
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
        
        while (!Thread.currentThread().isInterrupted()) {
             try {
                 
                 CommandDto parsedResult = parser.parse(inputBuffer.readLine(), SPLIT_CHAR);
                 
                 if(parsedResult != null){
                    server.executeCommand(parsedResult);
                 }
                 
             } catch (IOException e) {
            	 log.error(e.getMessage(), e);
                 Thread.currentThread().interrupt();
                 return;
             }
         }
    }
}