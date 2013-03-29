package com.dubbelepuntf.airsocketserver;

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
    
    private static boolean isAppelTaartLekker = true;
    
    public static void main( String[] args ) {
        
        startCLI();
                
    }
    
    private static void startCLI() {
        
        while(isAppelTaartLekker){
            
            print("Ready for a command...");
            
            String input = getInput();
            
            Command command = Command.find(input);
            
            printCommandMessage(command);
            excuteCommand(command);
                        
            print(" ");
        }
    }
    
    private static void printCommandMessage(Command command) {
        
        print(command.getMessage());
        
    }
    
    private static void excuteCommand(Command command){
        
        switch(command){
                
                case HELP:
                    // excute stuff
                break;
                
                case STOP:
                    // excute stuff
                break;
                
                case COFFEE:
                    // excute stuff
                break;
                
                case NONE:
                    // excute stuff
                break;
        }
    }
    
    private static void print(final String message) {
        
       System.out.println(message);
        
    }
    
    private static String getInput() {

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