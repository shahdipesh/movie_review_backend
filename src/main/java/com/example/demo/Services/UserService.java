package com.example.demo.Services;

import com.example.demo.Entity.User;
import com.example.demo.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public User createUser(User user){
        return usersRepository.save(user);
    }

    public User login(String email, String password){
        User loggedInUser = this.getUserByEmail(email);
        if(loggedInUser!=null){
            System.out.println("After----------------username verify");
            if(loggedInUser.getPassword().equals(password)){
                return loggedInUser;
            }
            else{
                return null;
            }
        }
        return null;
    }

    public User getUserByUserName(String username){
        return  usersRepository.getUserByUserName(username);
    }

    public User getUserByEmail(String email){
        return  usersRepository.getUserByEmail(email);
    }

    public User getUserById(Integer id){
        return  usersRepository.getUserById(id);
    }

    public Iterable<User> getAllUsers(){
        return usersRepository.findAll();
    }

    public User updateUser(User user){
        User userToUpdate = this.getUserById(user.getId());
        if(userToUpdate==null){
            return null;
        }
        if(user.getPassword()==null){
            user.setPassword(userToUpdate.getPassword());
        }
        return usersRepository.save(user);
    }
}
