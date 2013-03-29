package com.dubbelepuntf.airsocketserver.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Stuff enzo
 * 
 * @author niels
 *
 */
public class Server { 
    
    private boolean isAppelTaartLekker = true;
    
    
    public void startCLI() {
        
        while(isAppelTaartLekker){
            
            print("Ready for a command...");
            
            String input = getInput();
            
            Command command = Command.find(input);
            
            printCommandMessage(command);
            if (!excuteCommand(command))
            {
            	break;
            }
                        
            print(" ");
        }
    }
    
    private void printCommandMessage(Command command) {
        
        print(command.getMessage());
        
    }
    
    private boolean excuteCommand(Command command){
        
    	boolean retVal = false;
    	
        switch(command){
                
                case HELP:
                    // excute stuff
                break;
                
                case STOP:
                    // excute stuff
                	retVal= false;
                break;
                
                case COFFEE:
                    // excute stuff
                break;
                
                case NONE:
                    // excute stuff
                break;
        }
		return retVal;
    }
    
    private void print(final String message) {
        
       System.out.println(message);
        
    }
    
    private String getInput() {

        String input = "";
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            
                input = inputBuffer.readLine();
                
        }
        
        catch (IOException e) {
            
                // TODO: hackerdehax
                e.printStackTrace();
                
        }

        return input;
        
    }
}