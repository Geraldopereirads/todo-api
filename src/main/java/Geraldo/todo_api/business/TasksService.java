package Geraldo.todo_api.business;


import Geraldo.todo_api.infrastructure.entity.Tasks;
import Geraldo.todo_api.infrastructure.repository.TasksRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

@Service
public class TasksService {

    private final TasksRepository repository;

    public TasksService(TasksRepository repository) {
        this.repository = repository;
    }

    public void createTasks(Tasks tasks) {
        repository.saveAndFlush(tasks);
    }

    public Tasks searchTasksById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found with id")
        );
    }

    public void deletById(Integer id) {
        repository.deleteById(id);
    }

    public void updateTasks(Integer id, Tasks tasks) {
        Tasks tasksEntity = searchTasksById(id);

        Tasks updatedTasks = Tasks.builder()
                .name(tasks.getName() != null ? tasks.getName() : tasksEntity.getName())
                .responsible(tasks.getResponsible() != null ? tasks.getResponsible() : tasksEntity.getResponsible())
                .deliveryDate(tasks.getDeliveryDate() != null ? tasks.getDeliveryDate() : tasksEntity.getDeliveryDate())
                .id(tasksEntity.getId())
                .build();

        repository.saveAndFlush(updatedTasks);
    }
}
