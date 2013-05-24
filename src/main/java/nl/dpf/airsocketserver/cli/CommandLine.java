/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dpf.airsocketserver.cli;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 */
public class CommandLine {
    
    @Getter
    private Command command;
    
    @Getter @Setter
    private List<String> args;
    
    public CommandLine(final Command command)
	{
		this.command = command;
	}

	
}
