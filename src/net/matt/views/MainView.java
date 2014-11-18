package net.matt.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import net.matt.commands.Command;

public class MainView extends JFrame {

	private static final long serialVersionUID = 5974467548445023136L;
	private DefaultListModel<Command> commandModel, afterModel;
	private JList<Command> commandList, afterList;
	
	private JPanel leftJPanel, leftContainer, rightJPanel;
	private JScrollPane commandListScrollPane, afterListScrollPane;
	
	private JButton redoButton, undoButton, taskButton;

	
	public MainView()
	{
		super("Command Pattern Example");
		setSize(750,400);
		setLayout(new GridLayout(1, 2));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		redoButton = new JButton("Redo");
		undoButton = new JButton("Undo");
		taskButton = new JButton("Do a Task");
		
		leftContainer = new JPanel(new GridLayout(3, 0));
		leftContainer.add(undoButton);
		leftContainer.add(redoButton);
		leftContainer.add(taskButton);
		
		leftJPanel = new JPanel(new BorderLayout());
		leftJPanel.add(leftContainer, BorderLayout.CENTER);
			
		commandModel = new DefaultListModel<Command>();
		commandList = new JList<Command>(commandModel);
		
		afterModel = new DefaultListModel<Command>();
		afterList = new JList<Command>(afterModel);
		
		commandListScrollPane = new JScrollPane(commandList);
		afterListScrollPane = new JScrollPane(afterList);
		
		commandListScrollPane.setBorder(new TitledBorder("Commands"));
		afterListScrollPane.setBorder(new TitledBorder("Commands After Current"));
		
		rightJPanel = new JPanel(new GridLayout(0, 2));
		rightJPanel.add(commandListScrollPane);
		rightJPanel.add(afterListScrollPane);
		
		add(leftJPanel);
		add(rightJPanel);
		
		setVisible(true);
		
	}
	
	public void resetView(LinkedList<Command> commands, int selectedIndex)
	{	
		commandModel.clear();
		for(int x = 0; x <= selectedIndex; x++)
			commandModel.addElement(commands.get(x));
		
		afterModel.clear();
		for(int x = selectedIndex+1; x < commands.size(); x++)
			afterModel.addElement(commands.get(x));
	}
	
	public JButton getUndoButton() {
		return undoButton;
	}

	public JButton getRedoButton() {
		return redoButton;
	}

	public JButton getTaskButton() {
		return taskButton;
	}
	
	public JList<Command> getCommandList(){
		return commandList;
	}
}
