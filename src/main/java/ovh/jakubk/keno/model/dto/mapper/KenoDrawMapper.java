package ovh.jakubk.keno.model.dto.mapper;

import ovh.jakubk.keno.model.KenoDraw;
import ovh.jakubk.keno.model.dto.KenoDrawResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class KenoDrawMapper {
    public static KenoDrawResponseDTO mapKenoDrawToKenoDrawResponseDTO(KenoDraw kenoDraw) {
        List<Integer> result = new ArrayList<>();
        result.add(kenoDraw.getDrawResult().getNum1());
        result.add(kenoDraw.getDrawResult().getNum2());
        result.add(kenoDraw.getDrawResult().getNum3());
        result.add(kenoDraw.getDrawResult().getNum4());
        result.add(kenoDraw.getDrawResult().getNum5());
        return KenoDrawResponseDTO.builder()
                .id(kenoDraw.getId())
                .timestamp(kenoDraw.getTimestamp())
                .result(result)
                .build();
    }
}
