package nl.dpf.airsocketserver.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */
public class Parser
{
	public CommandLine getCommandLine(final String input, final String delimiter)
	{
		List<String> inputList = Arrays.asList(input.split(delimiter));

		for (Command c : Command.values())
		{
			if (c.getName().equals(inputList.get(0)))
			{
				CommandLine commandDto = new CommandLine(c);

				List<String> args = new ArrayList<>();
				args.addAll(inputList);
				args.remove(0);

				if (c.getNumberOfArgs() == args.size())
				{
					commandDto.setArgs(args);
				}
				else
				{
					return null;
				}
				return commandDto;
			}
		}
		return null;
	}
}