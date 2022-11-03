package Kodlama.io.Devs.dataAccess.abstracts;

import Kodlama.io.Devs.entities.concretes.Language;

import java.util.List;

public interface LanguageRepository {
    void add(Language language) throws Exception;
    void deleteById(int id) throws Exception;
    void deleteAll();
    void updateById(int id, Language language) throws Exception;
    List<Language> getAll();
    Language getById(int id) throws Exception;

}
