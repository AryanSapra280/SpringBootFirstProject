package com.sts.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sts.entities.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long>{
   List<User> findByName(String name);
   @Query("Select u from User u")
   List<User>getAllUser();
   @Query("Select u from User u where u.name= :name")
   List<User>getUserByName(@Param("name")String name);
}
