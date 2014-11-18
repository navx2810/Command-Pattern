package net.matt.models;
import java.util.LinkedList;

import net.matt.commands.Command;

public class TasksModel 
{

	private LinkedList<Command> commands;
	private int currentPointer;
	
	
	public TasksModel()
	{
		commands = new LinkedList<Command>();
		currentPointer = -1;
	}
	
	
	public Command getCommandBefore()
	{
		if ( commands.size() == 0 )
			return null;
		else if ( currentPointer <= 0 && commands.get(0) != null)
			return commands.get(0);
		else
		{
			currentPointer--;
			return commands.get(currentPointer);
		}		
	}
	
	public Command getCommandCurrent()
	{
		if( commands.size() == 0 )
			return null;
		return commands.get(currentPointer);
	}
	
	public Command getCommandAfter()
	{
		if( commands.size() == 0)
			return null;
		else if( currentPointer+1 != commands.size() )
		{
			currentPointer++;
			return commands.get(currentPointer);
		}
		else
		{
			return commands.get(currentPointer);
		}
	}
	
	public LinkedList<Command> getCommands()
	{
		return commands;
	}
	
	public void addCommand(Command command)
	{
		if ( commands.size() == 0)
		{
			commands.add(command);
			currentPointer++;
		}
		else if ( currentPointer + 1 >= commands.size() )
		{
			currentPointer++;
			commands.add(command);
		}
		else
		{
			currentPointer++;
			commands.set(currentPointer, command);
			
			for(int x = commands.size()-1; x > currentPointer; x--)
				commands.remove(x);
		}
	}

	public int getCurrentPointer()
	{
		return currentPointer;
	}
	
}
