package javaapi.javaapicrudspringboot.Controller;

import javaapi.javaapicrudspringboot.Model.User;
import javaapi.javaapicrudspringboot.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class apiController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
public String getPage(){
    return "hello";
}
@GetMapping("/users")
public List<User> getUsers()
{
    return userRepo.findAll();
}

@PostMapping("/save")
    public String saveUsers(@RequestBody User user){
    userRepo.save(user);
    return "saved";
}

@PutMapping("update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user)
{
    User update = userRepo.findById(id).get();
    update.setFirstName(user.getFirstName());
    update.setLastName(user.getLastName());
    update.setAge(user.getAge());
    update.setOccupation(user.getOccupation());
    userRepo.save(update);
    return "updated";
}

@DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable int id)
{
    User delete = userRepo.findById(id).get();
    userRepo.delete(delete);
    return "deleted user with id" +id;
}


}
