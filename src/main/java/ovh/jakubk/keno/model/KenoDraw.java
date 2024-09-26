package ovh.jakubk.keno.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "keno_draw")
public class KenoDraw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "draw_result_id", referencedColumnName = "id")
    private DrawResult drawResult;
}
