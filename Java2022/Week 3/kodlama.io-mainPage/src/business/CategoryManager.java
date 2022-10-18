package business;

import core.logger.Logger;
import dataAccess.CategoryDao;
import entities.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryManager {
    private CategoryDao categoryDao;
    private List<Logger> loggers;
    private List<Category> categories;

    public CategoryManager(CategoryDao categoryDao, List<Logger> loggers) {
        this.categoryDao = categoryDao;
        this.loggers = loggers;
        categories = new ArrayList<>();
    }

    public void add(Category newCategory) throws Exception {
        for (Category category : categories){
            if (category.equals(newCategory)){
                throw new Exception("Aynı isimde bir kategori bulunmaktadır: " + newCategory.getName());
            }
        }
        categoryDao.add(newCategory);
        categories.add(newCategory);
        loggers.forEach(logger -> logger.log(newCategory.toString()));
    }
}
