package business;

import core.logger.Logger;
import dataAccess.CourseDao;
import entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private CourseDao courseDao;
    private Logger[] loggers;
    private List<Course> courseList;

    public CourseManager(CourseDao courseDao, Logger[] loggers) {
        this.courseDao = courseDao;
        this.loggers = loggers;
        courseList = new ArrayList<>();
    }

    public void add(Course newCourse) throws Exception {
        if (newCourse.getPrice() < 0) {
            throw new Exception("Kurs ücreti 0'dan büyük olmalıdır.");
        }
        for (Course course : courseList) {
            if (course.equals(newCourse)) {
                throw new Exception("Aynı isimde bir kurs bulunmaktadır: " + newCourse.getName());
            }
        }
        courseDao.add(newCourse);
        courseList.add(newCourse);
        for (Logger logger : loggers) {
            logger.log(newCourse.toString());
        }

    }
}
