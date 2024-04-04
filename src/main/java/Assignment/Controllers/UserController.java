package Assignment.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Assignment.Entities.User;
import Assignment.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable("userId") Long userId) {
        try{
            User user = userService.getUserById(userId);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    

}
