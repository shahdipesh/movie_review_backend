package com.example.demo.Repositories;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User,Integer> {
    @Query("SELECT * FROM users where id= ?1")
    public User getUserById(Integer id);

    @Query("SELECT * FROM users where user_name= ?1")
    public User getUserByUserName(String name);

    @Query("SELECT * FROM users where email= ?1")
    public User getUserByEmail(String email);

}
