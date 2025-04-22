package mikuTest.TestRestApi.service;

import mikuTest.TestRestApi.entity.TodoEntity;
import mikuTest.TestRestApi.entity.UserEntity;
import mikuTest.TestRestApi.model.Todo;
import mikuTest.TestRestApi.repository.TodoRepo;
import mikuTest.TestRestApi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todoEntity, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todoEntity.setUser(user);
        return Todo.toModel(todoRepo.save(todoEntity));
    }
    public Todo completeTodo(Long id){
        TodoEntity todoEntity = todoRepo.findById(id).get();
        todoEntity.setCompleted(!todoEntity.getCompleted());
        return Todo.toModel(todoRepo.save(todoEntity));
    }
}
