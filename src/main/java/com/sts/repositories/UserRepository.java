package com.sts.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sts.entities.User;

public interface UserRepository extends CrudRepository<User,Long>{
   
}
