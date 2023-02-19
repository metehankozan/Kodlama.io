package Kodlama.io.Devs.webApi.controllers;

import Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import Kodlama.io.Devs.business.requests.CreateSubTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllSubTechnologiesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subtechnology")
public class SubTechnologyController {
    SubTechnologyService subTechnologyService;

    @Autowired
    public SubTechnologyController(SubTechnologyService subTechnologyService) {
        this.subTechnologyService = subTechnologyService;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateSubTechnologyRequest createSubTechnologyRequest) {
        subTechnologyService.add(createSubTechnologyRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        subTechnologyService.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody CreateSubTechnologyRequest createSubTechnologyRequest) {
        subTechnologyService.update(id, createSubTechnologyRequest);
    }

    @GetMapping("/getall")
    public List<GetAllSubTechnologiesResponse> getAll() {
        return subTechnologyService.getAll();
    }
}
