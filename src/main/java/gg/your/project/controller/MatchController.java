package gg.your.project.controller;

import gg.your.project.service.ImageService;
import gg.your.project.service.MatchFacadeService;
import gg.your.project.service.dto.MatchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class MatchController {

    private final MatchFacadeService matchFacadeService;
    private final ImageService imageService;

    @GetMapping(value = {"/", "/match"})
    public String indexPage(
    ) {
        return "index";
    }

    @GetMapping("/match/{fullName}")
    public String matchPage(
            @PathVariable("fullName") String fullName,
            final Model model
    ) {
        MatchResponse response = matchFacadeService.findLastMatch(fullName);
        model.addAttribute("spell", imageService.getAllSpellsByMap());
        model.addAttribute("rune", imageService.getAllRunesByMap());
        model.addAttribute("champion", imageService.getAllChampionByMap());
        model.addAttribute("match", response);
        return "match";
    }

}
