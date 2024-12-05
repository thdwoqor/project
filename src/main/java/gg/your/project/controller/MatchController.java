package gg.your.project.controller;

import gg.your.project.service.MatchService;
import gg.your.project.service.ImageService;
import gg.your.project.service.dto.MatchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;
    private final ImageService imageService;

    @GetMapping("/match")
    public String matchPage(
            final Model model
    ) {
        MatchResponse response = matchService.searchLastMatch("난 우리팀의 노력과 열정을 믿#kr2");
        model.addAttribute("spell", imageService.getAllSpellsByMap());
        model.addAttribute("rune", imageService.getAllRunesByMap());
        model.addAttribute("match", response);
        return "index";
    }


}
