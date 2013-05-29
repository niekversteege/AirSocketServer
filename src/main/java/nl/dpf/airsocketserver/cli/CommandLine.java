/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dpf.airsocketserver.cli;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CommandLine
{
    @Getter
    private Command command;

    @Getter
    private List<String> args;

    public CommandLine(final Command command)
    {
        args = new ArrayList<>();
        this.command = command;
    }

    public void addArgs(final List<String> newArgs)
    {
        args.addAll(newArgs);
    }
}
