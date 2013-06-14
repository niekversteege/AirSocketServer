package nl.dpf.airsocketserver.cli;

import lombok.extern.log4j.Log4j;
import nl.dpf.airsocketserver.connections.ConnectionHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Command Line Interface
 */
@Log4j
public class CommandLineInterface {

    private static final String SPLIT_CHAR = " ";
    private boolean stop;
    private  Thread connectionHandlerThread;

    public CommandLineInterface() {
        stop = false;
        connectionHandlerThread = new Thread(new ConnectionHandler());
        connectionHandlerThread.start();
    }

    public void run() {

        while (!stop) {
            String input = getInput();
            CommandLine command = CommandLineBuilder.getCommandLine(input, SPLIT_CHAR);

            if (command == null) {
                log.info("Invalid input and/or command. Try again.");
            } else {
                if (invokeCommand(command)){
                    break;
                }
            }
        }
    }

    private boolean invokeCommand(final CommandLine commandLine) {
        switch (commandLine.getCommand()) {
            case HELP:
                /* Print usage / help message */
                break;
            case STOP:
                /* Close everything and exit program */
                connectionHandlerThread.interrupt();
                log.info("Stopping server.");
                return true;
            default:
                /* print error message */
                break;

        }

        return false;
    }

    private String getInput() {
        String input = null;

        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(
                System.in));
        try {
            input = inputBuffer.readLine();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return input;
    }
}