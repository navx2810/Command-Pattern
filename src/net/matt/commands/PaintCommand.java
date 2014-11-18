package net.matt.commands;

public class PaintCommand extends Command {

	int x, y;
	
	public PaintCommand(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void execute() {

	}

	@Override
	public void undo() {

	}

	@Override
	public String toString() {
		return String.format("[ Painting ] : x(%s), y(%s) | %s", x, y, id);
	}

}
