package br.com.hildebrando.services;

import br.com.hildebrando.exception.ResourceNotFoundException;
import br.com.hildebrando.model.User;
import br.com.hildebrando.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User user){
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record for this ID"));
    }

    public User update(User user){
        User entity = userRepository.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No record for this ID"));

        entity.setId(user.getId());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setAddress(user.getAddress());
        entity.setGender(user.getGender());

        return userRepository.save(entity);
    }


    public void delete(Long id){
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record for this ID"));

        userRepository.delete(entity);
    }
}
