package Kodlama.io.Devs.business.concretes;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }

    @Override
    public void add(Language language) throws Exception {
        nameCheck(language);
        languageRepository.add(language);
    }

    @Override
    public void deleteById(int id) throws Exception {
        languageRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        languageRepository.deleteAll();
    }

    @Override
    public void updateById(int id, Language language) throws Exception {
        nameCheck(language);
        languageRepository.updateById(id, language);
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public Language getById(int id) throws Exception {
        return languageRepository.getById(id);
    }

    private void nameCheck(Language language) throws Exception {
        if(language.getName().isEmpty()){
            throw new Exception("Dil ismi boş olamaz!");
        }
        List<Language> languages = getAll();
        for(Language l : languages){
            if(l.getName().equals(language.getName())){
                throw new Exception("Aynı isimde dil listede bulunmaktadır!");
            }
        }
    }
}
