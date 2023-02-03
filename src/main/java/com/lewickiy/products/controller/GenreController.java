package com.lewickiy.products.controller;

import com.lewickiy.products.model.Genre;
import com.lewickiy.products.repository.GenreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GenreController {
    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/genres")
    public String goGenre(Model model) {
        List<Genre> genresList = genreRepository.findAll();
        model.addAttribute("genresList", genresList);
        return "genre";
    }
    @GetMapping("/genres/new")
    public String createGenre(Model model) {
        model.addAttribute("genre", new Genre());
        return "genre_form";
    }

    @PostMapping("/genres/save")
    public String saveGenre(Genre genre) {
        genreRepository.save(genre);
        return "redirect:/genres";
    }

    @GetMapping("/genres/edit/{id}")
    public String showEditGenreForm(@PathVariable("id") Integer id, Model model) {
        Genre genre = genreRepository.findById(id).get();
        model.addAttribute("genre", genre);

        return "genre_form";
    }

    @GetMapping("/genres/delete/{id}")
    public String deleteGenre(@PathVariable("id") Integer id) {
        genreRepository.deleteById(id);
        return "redirect:/genres";
    }
}
