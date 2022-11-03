package Kodlama.io.Devs.webApi.controllers;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService){
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<Language> getAll(){
        return languageService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public Language getById(@PathVariable int id) throws Exception {
        return languageService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Language language) throws Exception {
        languageService.add(language);
    }

    @DeleteMapping("/deleteall")
    public void deleteAll(){
        languageService.deleteAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) throws Exception {
        languageService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void updateById(@PathVariable int id, @RequestBody Language language) throws Exception {
        languageService.updateById(id, language);
    }
}
