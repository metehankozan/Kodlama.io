package Kodlama.io.Devs.webApi.controllers;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<GetAllLanguagesResponse> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Language> findById(@PathVariable int id) throws Exception {
        return languageService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
        languageService.add(createLanguageRequest);
    }

    @DeleteMapping("/deleteall")
    public void deleteAll() {
        languageService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) throws Exception {
        languageService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void updateById(@PathVariable int id, @RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
        languageService.updateById(id, createLanguageRequest);
    }
}
