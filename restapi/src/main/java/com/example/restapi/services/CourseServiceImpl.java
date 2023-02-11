package com.example.restapi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.dao.CourseDao;
import com.example.restapi.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private CourseDao courseDao;
    
    /*
     * List<Course>list;
     * public CourseServiceImpl(){
     * list= new ArrayList<>();
     * list.add(new Course(145,"Java Core Course","this course for java"));
     * list.add(new Course(147, "Java Spring Course",
     * "this course for Spring introduction"));
     * list.add(new Course(149, "Java SpringBoot Course",
     * "this course for SpringBoot introduction"));
     * }
     */
    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }
    @Override
    public Course getCourse(long courseId) {
        /*
         * Course c=null;
         * for(Course course:list){
         * if(course.getId()==courseId){
         * c=course;
         * break;
         * }
         * }
         */
        return courseDao.getReferenceById(courseId);
    }
    @Override
    public Course addCourse(Course course) {
       // list.add(course);
       courseDao.save(course);
        return course;
    }
    @Override
    public Course updateCourse(Course course) {
        /*
         * list.forEach(e->{
         * if(e.getId()==course.getId()){
         * e.setTitle(course.getTitle());
         * e.setDescription(course.getDescription());
         * }
         * });
         */
        courseDao.save(course);
        return course;
    }
    @Override
    public void deleteCourse(long courseId) {
        /*
         * list=this.list.stream().filter(e->e.getId()!=courseId)
         * .collect(Collectors.toList());
         */
        Course entity= courseDao.getReferenceById(courseId);
        courseDao.delete(entity);
    }
    
    
}
