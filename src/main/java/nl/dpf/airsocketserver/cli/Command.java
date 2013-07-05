package nl.dpf.airsocketserver.cli;

/**
 *
 */
public enum Command {
    HELP("help", 0),
    STOP("stop", 0),
    LIST("list", 0),
    KICK("kick", 1);

    private String name;
    private int numberOfArgs;

    Command(final String name, final int numberOfArgs) {
        this.name = name;
        this.numberOfArgs = numberOfArgs;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfArgs() {
        return numberOfArgs;
    }
}