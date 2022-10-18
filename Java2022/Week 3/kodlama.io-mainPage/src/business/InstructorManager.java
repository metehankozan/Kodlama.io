package business;

import core.logger.Logger;
import dataAccess.InstructorDao;
import entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorManager {
    private InstructorDao instructorDao;
    private Logger[] loggers;
    private List<Instructor> instructors;

    public InstructorManager(InstructorDao instructorDao, Logger[] loggers){
        this.instructorDao = instructorDao;
        this.loggers = loggers;
        this.instructors = new ArrayList<>();
    }

    public void add(Instructor newInstructor) throws Exception {
        for (Instructor instructor : instructors){
            if (instructor.equals(newInstructor)){
                throw new Exception("Aynı isimde bir eğitmen bulunmaktadır: " + newInstructor.getName());
            }
        }
        instructorDao.add(newInstructor);
        instructors.add(newInstructor);
        for(Logger logger : loggers){
            logger.log(newInstructor.toString());
        }
    }
}
