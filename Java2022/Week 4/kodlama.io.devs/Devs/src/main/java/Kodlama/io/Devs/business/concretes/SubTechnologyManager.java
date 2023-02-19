package Kodlama.io.Devs.business.concretes;

import Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllSubTechnologiesResponse;
import Kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import Kodlama.io.Devs.entities.concretes.SubTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubTechnologyManager implements SubTechnologyService {
    SubTechnologyRepository subTechnologyRepository;

    @Autowired
    public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository) {
        this.subTechnologyRepository = subTechnologyRepository;
    }

    @Override
    public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {
        SubTechnology subTechnology = new SubTechnology();
        Language language = new Language();
        language.setId(createSubTechnologyRequest.getLanguageId());
        subTechnology.setName(createSubTechnologyRequest.getName());
        subTechnology.setLanguage(language);
        subTechnologyRepository.save(subTechnology);
    }

    @Override
    public void delete(int id) {
        subTechnologyRepository.deleteById(id);
    }

    @Override
    public void update(int id, CreateSubTechnologyRequest createSubTechnologyRequest) {
        Optional<SubTechnology> subTechnology = subTechnologyRepository.findById(id);
        subTechnology.ifPresent(s -> s.setName(createSubTechnologyRequest.getName()));
        subTechnology.ifPresent(s -> subTechnologyRepository.save(s));
    }

    @Override
    public List<GetAllSubTechnologiesResponse> getAll() {
        List<GetAllSubTechnologiesResponse> getAllSubTechnologiesResponses = new ArrayList<>();
        for (SubTechnology subTechnology : subTechnologyRepository.findAll()) {
            GetAllSubTechnologiesResponse subLanguagesResponse = new GetAllSubTechnologiesResponse();
            subLanguagesResponse.setId(subTechnology.getId());
            subLanguagesResponse.setName(subTechnology.getName());
            subLanguagesResponse.setLanguage(subTechnology.getLanguage());
            getAllSubTechnologiesResponses.add(subLanguagesResponse);
        }
        return getAllSubTechnologiesResponses;
    }
}
