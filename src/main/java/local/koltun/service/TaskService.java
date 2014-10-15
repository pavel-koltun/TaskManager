package local.koltun.service;

import local.koltun.domain.Task;

import java.util.List;

public interface TaskService {
    void addTask(Task task);
    void updateTask(Task task);
    void archiveTask(Integer id);
    void changeTaskStatus(Integer id, String status);
    void deleteTask(Integer id);
    Task getTask(Integer id);
    List<Task> getAllTasks();
}
