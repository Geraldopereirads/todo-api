package Geraldo.todo_api.infrastructure.repository;

import Geraldo.todo_api.infrastructure.entity.Tasks;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Tasks, Integer> {

    @Transactional
    void deleteById(Integer id);
}
