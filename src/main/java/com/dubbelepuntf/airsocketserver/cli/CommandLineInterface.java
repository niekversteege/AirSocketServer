package com.dubbelepuntf.airsocketserver.cli;

import com.dubbelepuntf.airsocketserver.Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Command Line Interface
 */
public class CommandLineInterface implements Runnable {
    
    private Options options             = new Options();
    private CommandLineParser parser    = new BasicParser();
    private Server server;
    
    public CommandLineInterface(Server serverToCommand) {
        
        server = serverToCommand;
        
        Option help         = new Option( "help", "print this message" );
        Option version      = new Option( "version", "print the version information and exit" );
        
        options.addOption(help);
        options.addOption(version);
        
    }
    
    private void parse(String input) {
        
        String[] args = input.split(" ");
        
        try {
            CommandLine commandLine = parser.parse(options, args);
            System.out.println(commandLine.getOptions().length);
            server.executeCommand(commandLine);
        }
        catch( ParseException exp ) {
            System.err.println( "Parsing exception: " + exp.getMessage() );
        } 
    }
    
    public void run() {
               
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
        
        while (!Thread.currentThread().isInterrupted()) {
             try {
                 parse(inputBuffer.readLine());
                 
             } catch (IOException e) {
                 Thread.currentThread().interrupt();
                 return;
             }
         }
    }
}