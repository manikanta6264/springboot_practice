package com.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entities.QuestionAndAnswers;


public interface QuestionAndAnswersRepository extends JpaRepository<QuestionAndAnswers, Integer>{

}
