package br.com.hildebrando.controllers;

import br.com.hildebrando.services.UserService;
import br.com.hildebrando.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return  userService.create(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return  userService.update(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
          userService.delete(id);
          return ResponseEntity.noContent().build();
    }
}
