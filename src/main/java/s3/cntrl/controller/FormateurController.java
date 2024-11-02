package s3.cntrl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import s3.cntrl.model.Formateur;
import s3.cntrl.repository.FormateurRepository;
import s3.cntrl.service.FormateurService;

@Controller
@RequestMapping("/formateurs")
public class FormateurController {

    @Autowired
    private FormateurService formateurService;

    @GetMapping("/formateur/{id}")
    public String detailFormateur(@PathVariable Long id, Model model) {
        model.addAttribute("formateur", formateurService.findById(id));
        return "detail-formateur";
    }

    @GetMapping
    public String listFormateurs(Model model) {
        model.addAttribute("formateurs", formateurService.findAll());
        return "formateurs/liste";
    }

    @GetMapping("/ajouter")
    public String showAddFormateurForm(Model model) {
        model.addAttribute("formateur", new Formateur());
        return "formateurs/ajouter";
    }

    @PostMapping("/ajouter")
    public String addFormateur(@ModelAttribute Formateur formateur) {
        formateurService.save(formateur);
        return "redirect:/formateurs";
    }

    @GetMapping("/modifier/{id}")
    public String showEditFormateurForm(@PathVariable("id") Long id, Model model) {
        Formateur formateur = formateurService.findById(id);
        if (formateur == null) {
            throw new IllegalArgumentException("Formateur non trouvé : " + id);
        }
        model.addAttribute("formateur", formateur);
        return "formateurs/modifier";
    }

    @PostMapping("/modifier/{id}")
    public String updateFormateur(@PathVariable("id") Long id, @ModelAttribute Formateur formateur) {
        formateurService.save(formateur);
        return "redirect:/formateurs";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteFormateur(@PathVariable("id") Long id) {
        formateurService.deleteById(id);
        return "redirect:/formateurs";
    }




}
