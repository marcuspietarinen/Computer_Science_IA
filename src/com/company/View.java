package com.company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

class AddHomeworkView extends JFrame {
    private HomeworkModel model;
    private JTextField taskField;
    private JTextField deadlineField;

    public AddHomeworkView(HomeworkModel model) {
        this.model = model;

        setTitle("Add Homework");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 720);

        JPanel panel = new JPanel();

        JLabel taskLabel = new JLabel("Task:");
        taskField = new JTextField(20);

        JLabel deadlineLabel = new JLabel("Deadline:");
        deadlineField = new JTextField(20);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                String deadline = deadlineField.getText();
                model.addTask(new HomeworkTask(task, deadline));
                taskField.setText("");
                deadlineField.setText("");
            }
        });

        panel.add(taskLabel);
        panel.add(taskField);
        panel.add(deadlineLabel);
        panel.add(deadlineField);
        panel.add(addButton);

        add(panel);
        setVisible(true);

        // Create the menu bar and menu items
        JMenuBar menuBar = new JMenuBar();
        JMenu switchMenu = new JMenu("Menu");
        JMenuItem listViewItem = new JMenuItem("Homework List");
        listViewItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomeworkListView listView = new HomeworkListView(model);
                setVisible(false);
                listView.setVisible(true);
            }
        });
        switchMenu.add(listViewItem);
        menuBar.add(switchMenu);
        setJMenuBar(menuBar);

        setVisible(true);
    }
}

    // View class for displaying homework tasks

class HomeworkListView extends JFrame {
    private HomeworkModel model;
    private JTextArea taskArea;

    public HomeworkListView(HomeworkModel model) {
        this.model = model;

        setTitle("Homework List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 720);

        JPanel panel = new JPanel();

        taskArea = new JTextArea(10, 20);
        taskArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(taskArea);

        panel.add(scrollPane);

        add(panel);
        // Create the menu bar and menu items
        JMenuBar menuBar = new JMenuBar();
        JMenu switchMenu = new JMenu("Menu");
        JMenuItem addViewMenuItem = new JMenuItem("Add Homework");
        addViewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddHomeworkView addView = new AddHomeworkView(model);
                setVisible(false);
                addView.setVisible(true);
            }
        });
        switchMenu.add(addViewMenuItem);
        menuBar.add(switchMenu);
        setJMenuBar(menuBar);

        setVisible(true);

        updateTaskList();
    }

    public void updateTaskList() {
        List<HomeworkTask> tasks = model.getTasks();
        StringBuilder sb = new StringBuilder();

        for (HomeworkTask task : tasks) {
            sb.append(task.getTask()).append(" - ").append(task.getDeadline()).append("\n");
        }

        taskArea.setText(sb.toString());
    }
}


