
package com.studentlist.repository;

import com.studentlist.domain.Student;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String>  {
    
    @Override
    public List<Student> findAll();
}
