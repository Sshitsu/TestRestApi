package mikuTest.TestRestApi.service;

import mikuTest.TestRestApi.entity.UserEntity;
import mikuTest.TestRestApi.exception.UserAlreadyExistException;
import mikuTest.TestRestApi.exception.UserNotFoundException;
import mikuTest.TestRestApi.model.User;
import mikuTest.TestRestApi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null) throw new UserNotFoundException("User was not found!");
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
