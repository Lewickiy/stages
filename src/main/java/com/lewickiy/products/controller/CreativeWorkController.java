package com.lewickiy.products.controller;

import com.lewickiy.products.model.CreativeWork;
import com.lewickiy.products.model.Genre;
import com.lewickiy.products.repository.CreativeWorkRepository;
import com.lewickiy.products.repository.GenreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CreativeWorkController {
    private final CreativeWorkRepository creativeWorkRepository;
    private final GenreRepository genreRepository;

    public CreativeWorkController(CreativeWorkRepository creativeWorkRepository, GenreRepository genreRepository) {
        this.creativeWorkRepository = creativeWorkRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/creative_works")
    public String goCreativeWorks(Model model) {
        List<CreativeWork> creativeWorksList = creativeWorkRepository.findAll();
        model.addAttribute("creativeWorksList", creativeWorksList);

        return "creative_work";
    }

    @GetMapping("/creative_works/new")
    public String createCreativeWork(Model model) {
        List<Genre> genresList = genreRepository.findAll();

        model.addAttribute("creativeWork", new CreativeWork());
        model.addAttribute("genresList", genresList);
        return "creative_work_form";
    }
    @PostMapping("/creative_works/save")
    public String saveCreativeWork(CreativeWork creativeWork) {
        creativeWorkRepository.save(creativeWork);
        return "redirect:/creative_works";
    }
    //Запрос на открытие формы редаетирования. Передаётся по запросу из кнопки Edit в таблице спектаклей.
    @GetMapping("/creative_works/edit/{id}")
    public String showEditCreativeWorkForm(@PathVariable("id") Integer id, Model model) {
        CreativeWork creativeWork = creativeWorkRepository.findById(id).get();
        model.addAttribute("creativeWork", creativeWork);

        List<Genre> genresList = genreRepository.findAll();
        model.addAttribute("genresList", genresList);
        return "creative_work_form";
    }
    @GetMapping("/creative_works/delete/{id}")
    public String deleteGenre(@PathVariable("id") Integer id) {
        creativeWorkRepository.deleteById(id);
        return "redirect:/creative_works";
    }
}
