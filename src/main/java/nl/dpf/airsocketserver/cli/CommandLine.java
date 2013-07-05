/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dpf.airsocketserver.cli;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class CommandLine {
    private boolean argsSet = false;

    @Getter
    private final Command command;

    private final List<String> args;

    public CommandLine(final Command command) {
        args = new ArrayList<>();
        this.command = command;
    }

    public CommandLine(final Command command, final List<String> rawFields) {
        this(command);
        addArgs(rawFields.subList(1, rawFields.size()));
    }

    public void addArgs(final List<String> newArgs) {
        if (!argsSet) {
            args.addAll(newArgs);
            argsSet = true;
        }
    }

    public List<String> getArgs() {
        return Collections.unmodifiableList(args);
    }
}
