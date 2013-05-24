package nl.dpf.airsocketserver.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import nl.dpf.airsocketserver.Server;

import lombok.extern.log4j.Log4j;

/**
 * Command Line Interface
 */
@Log4j
public class CommandLineInterface
{

	private static final String	SPLIT_CHAR	= " ";
	private boolean				stop;
	private Server				server;
	private Parser				parser;

	public CommandLineInterface()
	{
		stop = false;
		parser = new Parser();
		server = new Server();
		server.run();
	}

	public void run()
	{
		while (!stop)
		{
			String input = getInput();
			CommandLine parsedResult = parser.getCommandLine(input, SPLIT_CHAR);

			if (parsedResult != null)
			{
				/* TODO: Check the given input and call the correct method */
			}
		}
	}

	private String getInput()
	{
		String input = null;
		
		BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(
				System.in));
		try
		{
			input = inputBuffer.readLine();
		}
		catch (IOException e)
		{
			log.error(e.getMessage(), e);
		}
		
		return input;
	}
}