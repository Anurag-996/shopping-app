package Assignment.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Assignment.Entities.User;
import Assignment.Repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long userId) throws Exception{
        Optional<User> optionalUser = userRepository.findById(userId);


        if(!optionalUser.isPresent()){
            throw new Exception("User Not found");
        }

        User user = optionalUser.get();

        return user;
        
    }

}
