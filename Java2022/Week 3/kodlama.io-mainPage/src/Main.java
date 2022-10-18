import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import core.logger.DatabaseLogger;
import core.logger.FileLogger;
import core.logger.Logger;
import core.logger.MailLogger;
import dataAccess.HibernateCourseDao;
import dataAccess.HibernateInstructorDao;
import dataAccess.JdbcCategoryDao;
import entities.Category;
import entities.Course;
import entities.Instructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Logger[] loggers = {new DatabaseLogger(), new FileLogger()};
        List<Logger> loggerList = new ArrayList<>(
                Arrays.asList(new FileLogger(), new MailLogger())
        );
        System.out.println("=======Course======");
        Course course1 = new Course("Java", 23);
        Course course2 = new Course("Angular", 20);
        Course course3 = new Course("Angular", 22);
        CourseManager courseManager = new CourseManager(new HibernateCourseDao(), loggers);
        courseManager.add(course1);
        courseManager.add(course2);
        //courseManager.add(course3);

        System.out.println("\n=======Category======");
        Category category1 = new Category("Programming");
        Category category2 = new Category("DevOps");
        Category category3 = new Category("DevOps");
        CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(), loggerList);
        categoryManager.add(category1);
        categoryManager.add(category2);
        //categoryManager.add(category3);

        System.out.println("\n=======Instructor======");
        Instructor instructor1 = new Instructor("Engin Demiroğ");
        Instructor instructor2 = new Instructor("Other Educator");
        Instructor instructor3 = new Instructor("Engin Demiroğ");
        InstructorManager instructorManager = new InstructorManager(new HibernateInstructorDao(), loggers);
        instructorManager.add(instructor1);
        instructorManager.add(instructor2);
        //instructorManager.add(instructor3);
    }
}
