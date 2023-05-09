package com.practice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entities.UserDet;

@Repository
public interface IUserRepository extends JpaRepository<UserDet, Integer>{

	UserDet findByUserEmail(String username);

}
