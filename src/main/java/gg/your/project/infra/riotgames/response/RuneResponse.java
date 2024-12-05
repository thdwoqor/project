package gg.your.project.infra.riotgames.response;

import gg.your.project.infra.riotgames.response.dto.SlotDto;
import java.util.List;
import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;

public record RuneResponse(
        String id,
        String key,
        String icon,
        String name,
        List<SlotDto> slots
) {
}
