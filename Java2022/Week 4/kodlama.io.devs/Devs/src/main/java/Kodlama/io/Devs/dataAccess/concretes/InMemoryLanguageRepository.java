package Kodlama.io.Devs.dataAccess.concretes;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
    List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<>();
    }

    @Override
    public void add(Language language) throws Exception {
        if(idPresent(language.getId())){
            throw new Exception("Aynı id ile kayıt bulunmaktadır!");
        }
        languages.add(language);
    }

    @Override
    public void deleteById(int id) throws Exception {
        Language language = getById(id);
        languages.remove(language);
    }

    @Override
    public void deleteAll() {
        languages.clear();
    }

    @Override
    public void updateById(int id, Language language) throws Exception {
        Language languageInMemory = getById(id);
        if(id == language.getId()){
            languages.set(languages.indexOf(languageInMemory), language);
        }else{
            throw new Exception("İletilen id ile iletilen dil id aynı olmalıdır!");
        }

    }

    @Override
    public List<Language> getAll() {
        Collections.sort(languages);
        return languages;
    }

    @Override
    public Language getById(int id) throws Exception {
        for (Language language : languages) {
            if (language.getId() == id) {
                return language;
            }
        }
        throw new Exception("İletilen id ile bir kayıt bulunmamaktadır.");
    }

    private int findIndex(int id) {
        for (int i = 0; i < languages.size(); i++) {
            if (languages.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private boolean idPresent(int id) {
        for (Language language : languages) {
            if (language.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
