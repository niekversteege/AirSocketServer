package com.dubbelepuntf.airsocketserver;

import com.dubbelepuntf.airsocketserver.cli.CommandDto;
import java.util.Date;
import lombok.extern.log4j.Log4j;

/**
 *  The server
 */
@Log4j
public class Server implements Runnable {
    
    public Server () {
    	
    }
    
    public void executeCommand(CommandDto commandDto) {
        
        switch(commandDto.getCommand()) {
            
            case HELP:
                printHelp();
                break;
            case TIME:
                printTime();
                break;
            case OPEN:
                try {
                    String arg = (String) commandDto.getArgs().get(0);
                    int number = Integer.parseInt(arg);
                    openSocket(number);
                } catch (NumberFormatException ex) {
                    log.error(ex);
                }
                break;
            default:
                log.info("No method for this command.");
                break;
        }
    }
    
    public synchronized void run() {
        
       log.info("Booting up...");
        
        try {
            while (!Thread.currentThread().isInterrupted()) {
                
                log.info("Heartbeat!");
                wait(30000);
                
            }
        } catch (InterruptedException ex) {
            log.error("interrupted: " + ex.getMessage(), ex);
        }
    }

    private void openSocket(int portNumber) {
        
        log.info("Opening socket on port " +  portNumber);
        
    }

    private void printHelp() {
        
        log.info("lol, help?!");
        
    }

    private void printTime() {
        
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        
        log.info("Current time: " + date);
    }
}