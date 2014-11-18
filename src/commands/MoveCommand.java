package commands;

public class MoveCommand extends Command {

	int x, y;
	
	public MoveCommand(int x, int y) {
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
	
		return String.format("[ Move ] : %s, %s | %s", x ,y, id);
	}

}
