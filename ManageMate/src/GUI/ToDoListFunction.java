package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ToDoListFunction extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JTextField inputTask;
	private JPanel tasksScroll;
	private JCheckBox checkStatus;
	private String taskText;
	private ArrayList<String> taskList = new ArrayList<>();
	
	public ToDoListFunction(JPanel taskFunction){
		//ADDING TASK
		inputTask = new JTextField(20);
		inputTask.setBounds(95, 124, 750, 65);
		inputTask.setOpaque(true);
		inputTask.setBorder(null);
		inputTask.setFont(new Font("Arial", Font.PLAIN,16));
		taskFunction.add(inputTask);
	
		//button
		Dimension buttonSize = new Dimension(176,82);
		
		JButton addButton = new JButton("+ Add");
		addButton.setFont(new Font("Arial", Font.BOLD,20));
        addButton.setBounds(726, 199, 120, 45);
        addButton.setFocusable(false);
        addButton.setBackground(new Color(238, 238, 238));
        addButton.setPreferredSize(buttonSize);
        addButton.addActionListener(e -> {
            String task = inputTask.getText();
            if (!task.isEmpty()) {
                taskList.add(task);
                addTaskToPanel(task, taskFunction);
                inputTask.setText("");
            }
        });
        taskFunction.add(addButton);
        
        JButton editButton = new JButton("Edit");
        editButton.setFont(new Font("Arial", Font.BOLD,20));
        editButton.setBounds(599, 199, 120, 45);
        editButton.setFocusable(false);
        editButton.setBackground(new Color(238, 238, 238));
        editButton.setPreferredSize(buttonSize);
        editButton.addActionListener(e -> {
            String task = inputTask.getText();
            if (!task.isEmpty()) {
                taskList.add(task);
                addTaskToPanel(task, taskFunction);
                inputTask.setText("");
            }
        });
        taskFunction.add(editButton);
        
        //scroll
        tasksScroll = new JPanel();
        tasksScroll.setLayout(null);
        tasksScroll.setBackground(new Color(84, 107, 127));
        
        JScrollPane scrollPanel = new JScrollPane(tasksScroll);
        scrollPanel.setBounds(75, 260, 800, 400);
        scrollPanel.setBorder(null);
        taskFunction.add(scrollPanel);
	}

	private void addTaskToPanel(String task, JPanel taskFunction) {
		// TODO Auto-generated method stub
		int taskCount = taskList.size() - 1;
        int addingTask = taskCount * 60;
        
        JPanel taskPanel = new JPanel();
        taskPanel.setBounds(5, addingTask, 770, 45);
        taskPanel.setBackground(new Color(0, 0, 0));
        taskPanel.setOpaque(false);
        taskPanel.setLayout(null);
        
        taskText = task;
        
        // check status button
        checkStatus = new JCheckBox(taskText);
        checkStatus.setLayout(null);
        checkStatus.setBounds(10, 15, 20, 20);
        checkStatus.setOpaque(false);
        taskPanel.add(checkStatus);
        
        //inputting task
        JLabel taskLabel = new JLabel(taskText);
        taskLabel.setFont(new Font("San Francisco", Font.PLAIN, 25));
        taskLabel.setForeground(Color.WHITE);
        taskLabel.setBounds(45, 10, 700, 25);
        taskPanel.add(taskLabel);
        
        tasksScroll.add(taskPanel);
        tasksScroll.setPreferredSize(new java.awt.Dimension(750, Math.max(380, (taskList.size() * 60))));
        tasksScroll.revalidate();
        tasksScroll.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
