package ovh.jakubk.keno.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ovh.jakubk.keno.model.dto.KenoDrawResponseDTO;
import ovh.jakubk.keno.service.KenoDrawService;

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
        this.kenoDrawService.newDraws(quantity);
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
