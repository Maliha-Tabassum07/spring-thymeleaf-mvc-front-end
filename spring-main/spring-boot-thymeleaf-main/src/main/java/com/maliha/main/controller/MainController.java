package com.maliha.main.controller;

import com.maliha.main.model.Wizards;
import com.maliha.main.service.WizardsService;
import com.maliha.main.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private WizardsService wizardsService;

    @Autowired
    private HouseService houseService;

    @GetMapping("/")
    public String homePage() {
        return "home-page.html";
    }

    @PostMapping("/find-by-position")
    public String findByPos(@RequestParam Integer position, Model model) {
        model.addAttribute("house", houseService.findByPosition(position));
        return "house-page.html";
    }

    @PostMapping("/find-by-id")
    public String findById(@RequestParam Integer id, Model model) {
        model.addAttribute("wizard", wizardsService.findById(id));
        return "wizard-page.html";
    }

    @GetMapping("/add-wizards")
    public String addWizard() {
        return "add-wizard-page.html";
    }

    @PostMapping("/save-wizard")
    public String saveWizard(@ModelAttribute Wizards wizards) {
        wizardsService.addWizard(wizards);
        return "home-page.html";
    }

    @GetMapping("/list-all-wizards")
    public String listAllWizards(Model model) {
        model.addAttribute("wizardsList", wizardsService.getAllWizards());
        return "all-wizard-page.html";
    }
    @GetMapping("/list-all-houses")
    public String listAllHouses(Model model) {
        model.addAttribute("houseList", houseService.getAllHouse());
        return "all-house-page.html";
    }
    @GetMapping("/update-{id}")
    public String updateForm(@PathVariable int id, Model model) {
        Wizards wz = wizardsService.findById(id);
        if (wz != null) {
            model.addAttribute("wizard", wz);
            return "update-wizard-page.html";
        }
        return null;
    }
    @PostMapping("/update-{id}")
    public String updateWizard(@PathVariable int id, @ModelAttribute Wizards wizards) {
        Wizards wz=wizardsService.findById(id);
        if (wz != null) {
            wz.setName(wizards.getName());
            wz.setId(wizards.getId());
            wz.setHouse(wizards.getHouse());

            return "redirect:/";
        }
        return null;
    }
    @PostMapping("/update-wizard")
    public String upWizard(@ModelAttribute Wizards wizards) {
        wizardsService.addWizard(wizards);
        return "home-page.html";
    }
    @GetMapping("/delete/{id}")
    public String deleteWizard(@PathVariable("id") int id) {
        wizardsService.deleteWizard(id);
        return "redirect:/";
    }

}
