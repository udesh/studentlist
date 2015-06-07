
package com.studentlist.rest;

import com.studentlist.domain.Student;
import com.studentlist.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/students")
public class StudentResource {
    
     private final StudentRepository studentRepository;

    @Autowired
    public StudentResource(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> submitStory(@RequestBody Student student) {
        studentRepository.save(student);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
        return responseEntity;
    }
    
    @RequestMapping(value = "/{studentId}",consumes = MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> update(@RequestBody Student student,@PathVariable("studentId") String studentId) {
        studentRepository.save(student);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
        return responseEntity;
    }
    
    @RequestMapping(value = "/{studentId}",method=RequestMethod.POST)
    @ResponseBody
    public void delete(@PathVariable("studentId") String studentId) {
        studentRepository.delete(studentId);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Student> allStories() {
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET)
    @ResponseBody
    public Student showStory(@PathVariable("studentId") String studentId) {
        if (studentId.endsWith("&delete")) {
            studentId = studentId.replace("&delete", "");
            studentRepository.delete(studentId);
            return null;
        }
        Student student = studentRepository.findOne(studentId);
        if (student == null) {
            throw new StudentNotFoundException(studentId);
        }
        return student;
    }
    
}
