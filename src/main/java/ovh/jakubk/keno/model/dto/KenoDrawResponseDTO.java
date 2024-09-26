package ovh.jakubk.keno.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class KenoDrawResponseDTO {
    private Long id;
    private LocalDateTime timestamp;
    private List<Integer> result;
}
