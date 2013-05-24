package com.dubbelepuntf.airsocketserver.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.extern.log4j.Log4j;

/**
 * 
 */

@Log4j
public class Parser {
    
    public void Parser() {
        
    }
    
    public CommandDto parse(String input, String splitChar) {
                
        String[] splitInput     = input.split(splitChar);
        List<String> inputList  = new ArrayList<String>();
        
        inputList.addAll(Arrays.asList(splitInput));
        
        for(Command c: Command.values()) {
                        
            if(c.getName().equals(inputList.get(0))) {
                                
                CommandDto commandDto = new CommandDto();
                commandDto.setCommand(c);
                
                List<String> args  = new ArrayList<String>();
                args.addAll(inputList);
                args.remove(0);
                
                if(c.getNumberOfArgs() == args.size()) {
                    
                    commandDto.setArgs(args);
                    
                } else {
                    
                    return null;
                    
                }
                
                return commandDto;
                        
            }
        }
        
        return null;
        
    }
}