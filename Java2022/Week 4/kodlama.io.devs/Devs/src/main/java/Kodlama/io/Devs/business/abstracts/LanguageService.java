package Kodlama.io.Devs.business.abstracts;

import Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.entities.concretes.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageService {
    void add(CreateLanguageRequest createLanguageRequest) throws Exception;

    void deleteById(int id) throws Exception;

    void deleteAll();

    void updateById(int id, CreateLanguageRequest createLanguageRequest) throws Exception;

    List<GetAllLanguagesResponse> getAll();

    Optional<Language> getById(int id) throws Exception;
}
