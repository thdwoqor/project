package gg.your.project.domain.champion;

import gg.your.project.domain.rune.Rune;
import java.util.List;

public interface ChampionRepository {
    List<Champion> findAll();
}
