package mikuTest.TestRestApi.controller;

import mikuTest.TestRestApi.entity.UserEntity;
import mikuTest.TestRestApi.exception.UserAlreadyExistException;
import mikuTest.TestRestApi.exception.UserNotFoundException;
import mikuTest.TestRestApi.repository.UserRepo;
import mikuTest.TestRestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("User was add");
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception ex){
            return ResponseEntity.badRequest().body("Something went wrong!");
        }
    }
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("Something went wrong!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("Something went wrong!");
        }
    }

}
