package com.dubbelepuntf.airsocketserver.cli;

/**
 *  
 */
public enum Command {
    
    HELP("help", 0), 
    OPEN("open", 1),   
    TIME("time", 0);
    
    private String name;
    private int numberOfArgs;
    
    Command(String _name, int _numberOfArgs) {
        
        this.name = _name;
        this.numberOfArgs = _numberOfArgs;
        
    }
    
    public String getName() {
        
        return name;
        
    }
    
    public int getNumberOfArgs() {
        
        return numberOfArgs;
        
    }
}