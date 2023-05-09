package com.practice.english;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entities.LanguageTense;
import com.practice.entities.UserDet;
@Repository
public interface ITenseRepository extends JpaRepository<LanguageTense, Integer>{

	List<LanguageTense> findByUserDet(UserDet sessionUser);

}
