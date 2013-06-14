package nl.dpf.airsocketserver.cli;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class CommandLineBuilder {
    private static final int FIELD_NAME = 0;

    public static CommandLine getCommandLine(final String input, final String delimiter) {
        CommandLine line = null;

        if (input == null || delimiter == null)
        {
            return line;
        }

        if (!input.isEmpty() && !delimiter.isEmpty()) {
            List<String> fields = Arrays.asList(input.split(delimiter));

            for (Command c : Command.values()) {
                if (nameIsCorrect(c, fields.get(FIELD_NAME)) && nrOfArgsCorrect(c, fields)) {

                    line = new CommandLine(c);
                }
            }
        }
        return line;
    }

    private static boolean nameIsCorrect(final Command command, final String name) {
        return command.getName().equals(name);
    }

    private static boolean nrOfArgsCorrect(final Command command, final List<String> fields) {
        return command.getNumberOfArgs() == (fields.size() - 1);
    }
}