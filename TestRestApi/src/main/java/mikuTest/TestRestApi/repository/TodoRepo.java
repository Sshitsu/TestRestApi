package mikuTest.TestRestApi.repository;

import mikuTest.TestRestApi.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
