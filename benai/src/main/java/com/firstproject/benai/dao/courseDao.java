package com.firstproject.benai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstproject.benai.entities.Course;

public interface courseDao extends JpaRepository<Course, Long> {

}
