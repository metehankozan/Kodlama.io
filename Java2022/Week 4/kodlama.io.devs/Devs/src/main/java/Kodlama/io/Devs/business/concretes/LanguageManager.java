package Kodlama.io.Devs.business.concretes;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.business.responses.GetByIdLanguageResponse;
import Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;
    private ModelMapperService modelMapperService;

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
        List<Language> languages = languageRepository.findAll();
        List<GetAllLanguagesResponse> languagesResponse = languages.stream()
                .map(language -> modelMapperService.forResponse().map(language, GetAllLanguagesResponse.class))
                .collect(Collectors.toList());
        return languagesResponse;
    }

    @Override
    public GetByIdLanguageResponse getById(int id) {
        Language language = languageRepository.findById(id).orElseThrow(NullPointerException::new);
        return modelMapperService.forResponse().map(language, GetByIdLanguageResponse.class);
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
