package Kodlama.io.Devs.business.concretes;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
        nameCheck(createLanguageRequest);
        Language language = new Language();
        language.setName(createLanguageRequest.getName());
        languageRepository.save(language);
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
    public void updateById(int id, CreateLanguageRequest createLanguageRequest) throws Exception {
        nameCheck(createLanguageRequest);
        Optional<Language> language = languageRepository.findById(id);
        language.ifPresent(l -> l.setName(createLanguageRequest.getName()));
        language.ifPresent(l -> languageRepository.save(l));
    }

    @Override
    public List<GetAllLanguagesResponse> getAll() {
        List<GetAllLanguagesResponse> getAllLanguagesResponses = new ArrayList<>();
        List<Language> languages = languageRepository.findAll();
        for (Language language : languages) {
            GetAllLanguagesResponse languagesResponse = new GetAllLanguagesResponse();
            languagesResponse.setId(language.getId());
            languagesResponse.setName(language.getName());
            getAllLanguagesResponses.add(languagesResponse);
        }
        return getAllLanguagesResponses;
    }

    @Override
    public Optional<Language> getById(int id) throws Exception {
        return languageRepository.findById(id);
    }

    private void nameCheck(CreateLanguageRequest createLanguageRequest) throws Exception {
        if (createLanguageRequest.getName().isEmpty()) {
            throw new Exception("Dil ismi boş olamaz!");
        }
        List<GetAllLanguagesResponse> languages = getAll();
        for (GetAllLanguagesResponse l : languages) {
            if (l.getName().equals(createLanguageRequest.getName())) {
                throw new Exception("Aynı isimde dil listede bulunmaktadır!");
            }
        }
    }
}
