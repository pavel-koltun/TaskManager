package local.koltun.dao;

import local.koltun.domain.Task;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void addTask(Task task) {
        sessionFactory.getCurrentSession().save(task);
    }

    @Transactional
    @Override
    public void updateTask(Task task) {
        System.out.println("Title: " + task.getTitle());
        sessionFactory.getCurrentSession().update(task);
    }

    @Transactional
    @Override
    public void archiveTask(Integer id) {
        Task taskToArchive = getTask(id);

        if (taskToArchive != null) {
            taskToArchive.setArchived(true);
            updateTask(taskToArchive);
        }
    }

    @Transactional
    @Override
    public void changeTaskStatus(Integer id, String status) {
        Task taskToChange = getTask(id);

        if (taskToChange != null) {
            taskToChange.setArchived(true);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Task getTask(Integer id) {
        Task task = (Task) sessionFactory.getCurrentSession().get(Task.class, id);
        return task;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings(value = "unchecked")
    @Override
    public List<Task> getAllTasks() {
        return sessionFactory.getCurrentSession().createQuery("from Task").list();
    }

    @Transactional
    @Override
    public void deleteTask(Integer id) {
        Task taskToDelete = getTask(id);

        if (taskToDelete != null) {
            sessionFactory.getCurrentSession().delete(taskToDelete);
        }
    }
}
