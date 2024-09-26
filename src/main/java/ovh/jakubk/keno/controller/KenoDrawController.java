package ovh.jakubk.keno.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ovh.jakubk.keno.model.DrawResult;
import ovh.jakubk.keno.model.KenoDraw;
import ovh.jakubk.keno.model.dto.KenoDrawResponseDTO;
import ovh.jakubk.keno.service.KenoDrawService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static ovh.jakubk.keno.constants.KenoConstants.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/draw")
public class KenoDrawController {
    private KenoDrawService kenoDrawService;

    @GetMapping("/new")
    public ResponseEntity<KenoDrawResponseDTO> newDraw() {
        return ResponseEntity.ok(this.kenoDrawService.newDraw());
    }


    @GetMapping("/new/{quantity}")          //only for mocking db
    public void newDraws(@PathVariable String quantity) {
        int q;
        try {
            q = Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            return;
        }

        for (int i = 0; i < q; i++) {
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
            kenoDrawService.save(kenoDraw);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<KenoDrawResponseDTO> getKenoDraw(@PathVariable("id") Long id) {
        return ResponseEntity.ok(kenoDrawService.findById(id));
    }


    @GetMapping("/last")
    public ResponseEntity<KenoDrawResponseDTO> getLastDraw() {
        return ResponseEntity.ok(kenoDrawService.findLastDraw());
    }
}
