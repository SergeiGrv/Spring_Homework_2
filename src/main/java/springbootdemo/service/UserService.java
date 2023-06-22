package springbootdemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootdemo.model.User;
import springbootdemo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository ;

    @Autowired
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository ;
    }
    public User findById (Long id){
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(String.format("user with id %d not found", id))
                );
    }
    public List<User> findAll(){
        return userRepository .findAll() ;
    }
    public User saveUser (User user){
        return userRepository .save(user) ;
    }
    public void deleteById (Long id){
        userRepository .deleteById(id) ;
    }
}
