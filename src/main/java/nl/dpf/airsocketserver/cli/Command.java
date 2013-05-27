package nl.dpf.airsocketserver.cli;

/**
 *
 */
public enum Command
{
    HELP("help", 0),
    OPEN("open", 1),
    TIME("time", 0);

    private String name;
    private int numberOfArgs;

    Command(final String name, final int numberOfArgs)
    {
        this.name = name;
        this.numberOfArgs = numberOfArgs;
    }

    public String getName()
    {
        return name;
    }

    public int getNumberOfArgs()
    {
        return numberOfArgs;
    }
}