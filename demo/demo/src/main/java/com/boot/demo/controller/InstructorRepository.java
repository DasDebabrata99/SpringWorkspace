package com.boot.demo.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.demo.entity.InstructorDetail;
@Repository
public interface InstructorRepository extends CrudRepository<InstructorDetail, Integer> {

}
