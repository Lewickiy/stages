package com.lewickiy.products.controller;

import com.lewickiy.products.model.Sex;
import com.lewickiy.products.repository.SexRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SexController {
    private final SexRepository sexRepository;

    public SexController(SexRepository sexRepository) {
        this.sexRepository = sexRepository;
    }

    @GetMapping("/sex")
    public String goSex(Model model) {
        List<Sex> sexList = sexRepository.findAll();
        model.addAttribute("sexList", sexList);
        return "sex";
    }
    @GetMapping("/sex/new")
    public String createSex(Model model) {
        model.addAttribute("sex", new Sex());
        return "sex_form";
    }

    @PostMapping("/sex/save")
    public String saveSex(Sex sex) {
        sexRepository.save(sex);
        return "redirect:/sex";
    }

    @GetMapping("/sex/edit/{id}")
    public String showEditSexForm(@PathVariable("id") Integer id, Model model) {
        Sex sex = sexRepository.findById(id).get();
        model.addAttribute("sex", sex);

        return "sex_form";
    }

    @GetMapping("/sex/delete/{id}")
    public String deleteSex(@PathVariable("id") Integer id) {
        sexRepository.deleteById(id);
        return "redirect:/sex";
    }
}
