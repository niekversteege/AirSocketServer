package nl.dpf.airsocketserver;

import nl.dpf.airsocketserver.cli.CommandLineInterface;

public class AirSocketMain
{
    public static void main(String[] args)
    {
        CommandLineInterface cli = new CommandLineInterface();
        cli.run();
    }
}