package mikuTest.TestRestApi.service;

import mikuTest.TestRestApi.entity.UserEntity;
import mikuTest.TestRestApi.exception.UserAlreadyExistException;
import mikuTest.TestRestApi.exception.UserNotFoundException;
import mikuTest.TestRestApi.model.User;
import mikuTest.TestRestApi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("User with this username has already exist!");
        }
        return userRepo.save(user);
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        for(UserEntity entity: userRepo.findAll()){
            users.add(User.toModel(entity));
        }
        return users;
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User was not found!"));
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
