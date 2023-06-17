package com.company;

import java.util.ArrayList;
import java.util.List;

class HomeworkModel {
    private List<HomeworkTask> tasks;

    public HomeworkModel() {
        tasks = new ArrayList<>();
    }

    public void addTask(HomeworkTask task) {
        tasks.add(task);
    }

    public List<HomeworkTask> getTasks() {
        return tasks;
    }
}

class HomeworkTask {
    private String task;
    private String deadline;

    public HomeworkTask(String task, String deadline) {
        this.task = task;
        this.deadline = deadline;
    }

    public String getTask() {
        return task;
    }

    public String getDeadline() {
        return deadline;
    }
}