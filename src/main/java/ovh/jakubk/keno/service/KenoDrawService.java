package ovh.jakubk.keno.service;

import ovh.jakubk.keno.model.KenoDraw;
import ovh.jakubk.keno.model.dto.KenoDrawResponseDTO;


public interface KenoDrawService {

    KenoDrawResponseDTO newDraw();

    KenoDraw save(KenoDraw kenoDraw);

    KenoDrawResponseDTO findById(Long id);

    KenoDrawResponseDTO findLastDraw();
}
