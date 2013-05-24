package nl.dpf.airsocketserver;

import lombok.extern.log4j.Log4j;

/**
 *  The server
 */
@Log4j
public class Server implements GameServer {
    
    public Server () {
    	
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
}