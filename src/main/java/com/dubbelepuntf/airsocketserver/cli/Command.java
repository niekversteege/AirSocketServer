package com.dubbelepuntf.airsocketserver.cli;

/**
 * Commands enzo
 * 
 * @author niels
 */
public enum Command {
    
    HELP    ("help",    "Possible commands: help, stop, coffee, none"),
    STOP    ("stop",    "Stopping..."),
    COFFEE  ("coffee",  "Hmmmm!"),
    NONE(   "none",     "nopes!");
    
    private final String code;
    private final String message;
    
    Command(final String code, final String message) {
        
        this.code       = code;
        this.message    = message;
        
    }
    
    public static Command find(final String phrase){

        for (Command c : Command.values()) {
            
            if(c.getCode().equals(phrase)){
                
                return c;
                
            }
        }

        return NONE;

    }
    
    public final String getMessage() {
        
        return message;
        
    }
    
    private String getCode() {
        
        return this.code;
        
    }
}