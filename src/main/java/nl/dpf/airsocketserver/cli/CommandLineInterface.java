package nl.dpf.airsocketserver.cli;

import lombok.extern.log4j.Log4j;
import nl.dpf.airsocketserver.connections.ConnectionHandler;
import nl.dpf.airsocketserver.server.Client;
import nl.dpf.airsocketserver.server.ServerController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Command Line Interface
 */
@Log4j
public class CommandLineInterface {

    private static final String SPLIT_CHAR = " ";

    private final BufferedReader inputBuffer;
    private boolean stop;

    ServerController controller;

    public CommandLineInterface() {
        stop = false;

        inputBuffer = new BufferedReader(new InputStreamReader(
                System.in));
        controller = new ServerController();
    }

    public void run() {

        while (!stop) {
            String input = getInput();
            CommandLine command = CommandLineBuilder.getCommandLine(input, SPLIT_CHAR);

            if (command == null) {
                log.info("Invalid input and/or command. Try again.");
            } else {
                if (invokeCommand(command)) {
                    break;
                }
            }
        }
    }

    private boolean invokeCommand(final CommandLine commandLine) {

        switch (commandLine.getCommand()) {
            case HELP:
                /* Print usage / help message */
                printHelp();
                break;
            case STOP:
                /* Close everything and exit program */
                stop();
                return true;
            case LIST:
                printClients(controller.getClientList());
                break;
            case KICK:
                /* We can assume that commandLine has the correct amount of args, since this checked on creation */
                /* TODO: this construction is still terribly ugly */
                String clientName = commandLine.getArgs().get(0);
                controller.kickClient(clientName);
            default:
                /* print error message */
                break;

        }

        return false;
    }

    private void printClients(List<Client> clientList) {

        if (clientList.size() > 0) {
            log.info("Connected clients:");

            for (Client c : clientList) {
                log.info("\t" + c.toString());
            }
        } else {
            log.info("No clients connected.");
        }
    }

    private void printHelp() {
        /* TODO: print something helpful about the available commands. */
        /* TODO: maybe do this dynamically? */
    }

    private void stop() {

        log.info("Stopping server.");
        stop = true;
        controller.stop();

        try {
            inputBuffer.close();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    private String getInput() {

        String input = null;

        try {
            input = inputBuffer.readLine();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return input;
    }
}