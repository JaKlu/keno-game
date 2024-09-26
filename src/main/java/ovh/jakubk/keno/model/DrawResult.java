package ovh.jakubk.keno.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "draw_result")
public class DrawResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "num1")
    private int num1;

    @Column(name = "num2")
    private int num2;

    @Column(name = "num3")
    private int num3;

    @Column(name = "num4")
    private int num4;

    @Column(name = "num5")
    private int num5;

    @OneToOne(mappedBy = "drawResult")
    private KenoDraw kenoDraw;
}
