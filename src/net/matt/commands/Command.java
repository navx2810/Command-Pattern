package net.matt.commands;

import java.util.UUID;

public abstract class Command {
	
	UUID id = UUID.randomUUID();
	abstract public void execute();
	abstract public void undo();
	
	@Override
	abstract public String toString();

}
