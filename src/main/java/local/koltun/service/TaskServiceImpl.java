package local.koltun.service;

import local.koltun.dao.TaskDao;
import local.koltun.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;

    @Override
    public void addTask(Task task) {
        taskDao.addTask(task);
    }

    @Override
    public void updateTask(Task task) {
        taskDao.updateTask(task);
    }

    @Override
    public void archiveTask(Integer id) {
        taskDao.archiveTask(id);
    }

    @Override
    public void changeTaskStatus(Integer id, String status) {
        taskDao.changeTaskStatus(id, status);
    }

    @Override
    public Task getTask(Integer id) {
        return taskDao.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDao.getAllTasks();
    }

    @Override
    public void deleteTask(Integer id) {
        taskDao.deleteTask(id);
    }
}
