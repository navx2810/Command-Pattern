import java.util.Random;

import net.matt.commands.Command;
import net.matt.commands.MainCommand;
import net.matt.commands.MoveCommand;
import net.matt.commands.PaintCommand;
import net.matt.models.TasksModel;
import net.matt.views.MainView;


public class TasksController
{
	private TasksModel tasksModel;
	private MainView mainView;
	
	private Random random;
	
	public TasksController() 
	{
		tasksModel = new TasksModel();
		mainView = new MainView();
		
		random = new Random();
		
		mainView.getUndoButton().addActionListener(event -> undoAction());
		mainView.getRedoButton().addActionListener(event -> redoAction());
		mainView.getTaskButton().addActionListener(event -> addNewAction());
	}

	private void undoAction() {
		tasksModel.getCommandBefore();
		mainView.resetView(tasksModel.getCommands(), tasksModel.getCurrentPointer());
	}
	
	private void redoAction(){
		tasksModel.getCommandAfter();
		mainView.resetView(tasksModel.getCommands(), tasksModel.getCurrentPointer());
	}
	
	private void addNewAction(){
		int localChance = random.nextInt(3);
		Command toAdd = null;
		
		switch(localChance)
		{
			case 0:
				toAdd = new MainCommand(); break;
			case 1:
				toAdd = new MoveCommand(random.nextInt(255), random.nextInt(255)); break;
			default:
				toAdd = new PaintCommand(random.nextInt(255), random.nextInt(255)); break;
		}
		
		tasksModel.addCommand(toAdd);
		mainView.resetView(tasksModel.getCommands(), tasksModel.getCurrentPointer());
	}

	public static void main(String[] args) {
		new TasksController();
	}
}
