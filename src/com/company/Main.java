package com.company;

public class Main {

    public static void main(String[] args) {
        HomeworkModel model = new HomeworkModel();
        AddHomeworkView addView = new AddHomeworkView(model);
        HomeworkListView listView = new HomeworkListView(model);
        HomeworkController controller = new HomeworkController(model, addView, listView);
    }
}
class HomeworkController {
    private HomeworkModel model;
    private AddHomeworkView addView;
    private HomeworkListView listView;

    public HomeworkController(HomeworkModel model, AddHomeworkView addView, HomeworkListView listView) {
        this.model = model;
        this.addView = addView;
        this.listView = listView;

        addView.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                listView.updateTaskList();
            }
        });
    }
}