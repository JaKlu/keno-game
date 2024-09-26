package ovh.jakubk.keno.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ovh.jakubk.keno.db.KenoDrawDAO;
import ovh.jakubk.keno.model.DrawResult;
import ovh.jakubk.keno.model.KenoDraw;
import ovh.jakubk.keno.model.dto.KenoDrawResponseDTO;
import ovh.jakubk.keno.model.dto.mapper.KenoDrawMapper;
import ovh.jakubk.keno.service.KenoDrawService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static ovh.jakubk.keno.constants.KenoConstants.*;

@AllArgsConstructor
@Service
public class KenoDrawServiceImpl implements KenoDrawService {
    private KenoDrawDAO kenoDrawDAO;

    @Override
    public KenoDraw save(KenoDraw kenoDraw) {
        return this.kenoDrawDAO.save(kenoDraw);
    }

    public KenoDrawResponseDTO newDraw() {
        KenoDraw kenoDraw = new KenoDraw();
        DrawResult drawResult = new DrawResult();
        kenoDraw.setTimestamp(LocalDateTime.now());

        List<Integer> list = ThreadLocalRandom.current()
                .ints(MIN, MAX + 1).distinct()
                .limit(DRAW_LIMIT)
                .boxed().toList();
        drawResult.setNum1(list.get(0));
        drawResult.setNum2(list.get(1));
        drawResult.setNum3(list.get(2));
        drawResult.setNum4(list.get(3));
        drawResult.setNum5(list.get(4));

        kenoDraw.setDrawResult(drawResult);

        KenoDraw savedKenoDraw = this.kenoDrawDAO.save(kenoDraw);
        return KenoDrawMapper.mapKenoDrawToKenoDrawResponseDTO(savedKenoDraw);

    }


    @Override
    public KenoDrawResponseDTO findById(Long id) {
        return kenoDrawDAO.findById(id)
                .map(KenoDrawMapper::mapKenoDrawToKenoDrawResponseDTO)
                .orElseThrow();
    }

    @Override
    public KenoDrawResponseDTO findLastDraw() {
        return kenoDrawDAO.findFirstByOrderByIdDesc()
                .map(KenoDrawMapper::mapKenoDrawToKenoDrawResponseDTO)
                .orElseThrow();
    }


}
