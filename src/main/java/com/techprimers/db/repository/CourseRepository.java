package com.techprimers.db.repository;

import com.techprimers.db.model.TCourse;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CourseRepository extends JpaRepository<TCourse, Integer> {
    List<TCourse> findByTeacherId(String teachId);

}
