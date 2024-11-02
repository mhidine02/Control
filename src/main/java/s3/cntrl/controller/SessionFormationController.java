package s3.cntrl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import s3.cntrl.model.SessionFormation;
import s3.cntrl.service.FormateurService;
import s3.cntrl.service.SessionFormationService;

@Controller
@RequestMapping("/sessions")
public class SessionFormationController {

    @Autowired
    private SessionFormationService sessionFormationService;

    @Autowired
    private FormateurService formateurService;

    @GetMapping("/session/{id}")
    public String detailSession(@PathVariable Long id, Model model) {
        model.addAttribute("sessionFormation", sessionFormationService.findById(id));
        return "detail-session";
    }

    @GetMapping
    public String listSessions(Model model) {
        model.addAttribute("sessionFormations", sessionFormationService.findAll());
        return "sessions/liste";
    }

    @GetMapping("/ajouter")
    public String showAddSessionForm(Model model) {
        model.addAttribute("sessionFormation", new SessionFormation());
        model.addAttribute("formateurs", formateurService.findAll());
        return "sessions/ajouter";
    }

    @PostMapping("/ajouter")
    public String addSession(@ModelAttribute SessionFormation sessionFormation) {
        sessionFormationService.save(sessionFormation);
        return "redirect:/sessions";
    }

    @GetMapping("/modifier/{id}")
    public String showEditSessionForm(@PathVariable("id") Long id, Model model) {
        SessionFormation sessionFormation = sessionFormationService.findById(id);
        if (sessionFormation == null) {
            throw new IllegalArgumentException("Session non trouvée : " + id);
        }
        model.addAttribute("sessionFormation", sessionFormation);
        model.addAttribute("formateurs", formateurService.findAll());
        return "sessions/modifier";
    }

    @PostMapping("/modifier/{id}")
    public String updateSession(@PathVariable("id") Long id, @ModelAttribute SessionFormation sessionFormation) {
        sessionFormationService.save(sessionFormation);
        return "redirect:/sessions";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteSession(@PathVariable("id") Long id) {
        sessionFormationService.deleteById(id);
        return "redirect:/sessions";
    }

}
