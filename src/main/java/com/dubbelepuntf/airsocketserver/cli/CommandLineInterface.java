package com.dubbelepuntf.airsocketserver.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lombok.extern.log4j.Log4j;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.dubbelepuntf.airsocketserver.Server;

/**
 * Command Line Interface
 */
@Log4j
public class CommandLineInterface implements Runnable {
    
    private Options options;
    private CommandLineParser parser;
    private Server server;
    
    public CommandLineInterface(Server serverToCommand) {
    	
    	options             = new Options();
    	parser    = new BasicParser();    
        server = serverToCommand;
        
        Option help         = new Option( "help", "print this message" );
        Option version      = new Option( "version", "print the version information and exit" );
        
        options.addOption(help);
        options.addOption(version);
        
    }
    
    private void parse(String input) {
        
        String[] args = input.split(" ");
        System.out.println(args.length);
        try {
            CommandLine commandLine = parser.parse(options, args);
            
            if (commandLine.hasOption("help"))
            {
            	log.debug("found help message");
            }
            
            server.executeCommand(commandLine);
        }
        catch( ParseException exp ) {
           log.error( "Parsing exception: " + exp.getMessage() , exp);
        } 
    }
    
    public void run() {
               
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
        
        while (!Thread.currentThread().isInterrupted()) {
             try {
                 parse(inputBuffer.readLine());
                 
             } catch (IOException e) {
            	 log.error(e.getMessage(), e);
                 Thread.currentThread().interrupt();
                 return;
             }
         }
    }
}