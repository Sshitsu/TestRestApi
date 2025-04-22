package mikuTest.TestRestApi.repository;

import mikuTest.TestRestApi.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);

}
