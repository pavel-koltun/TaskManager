package local.koltun.controllers;

import local.koltun.domain.Task;
import local.koltun.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/rest/tasks")
public class TaskRestController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @RequestMapping(value = "/{taskId}", method = RequestMethod.GET)
    public Task getTask(@PathVariable("taskId") Integer id) {
        return taskService.getTask(id);
    }

    @RequestMapping(value = "/{taskId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTask(@PathVariable("taskId") Integer id, @RequestBody Task task) {
        taskService.updateTask(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task, HttpServletResponse response) {
        taskService.addTask(task);

        response.setHeader("Location", "/tasks/" + task.getId());
        return task;
    }
}
