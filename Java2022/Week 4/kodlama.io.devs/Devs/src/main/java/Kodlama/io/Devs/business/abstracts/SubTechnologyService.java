package Kodlama.io.Devs.business.abstracts;

import Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllSubLanguagesResponse;

import java.util.List;

public interface SubTechnologyService {
    void add(CreateSubTechnologyRequest createSubTechnologyRequest);

    void delete(int id);

    void update(int id, CreateSubTechnologyRequest createSubTechnologyRequest);

    List<GetAllSubLanguagesResponse> getAll();
}
