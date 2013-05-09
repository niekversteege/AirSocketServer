/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dubbelepuntf.airsocketserver.cli;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 */
public class CommandDto {
    
    @Getter @Setter
    private Command command;
    
    @Getter @Setter
    private List args;
    
    public void CommandDto() {
        
    }
}
