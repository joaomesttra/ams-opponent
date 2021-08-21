package br.com.mesttra.opponent.entity;

import br.com.mesttra.opponent.enums.Formation;
import br.com.mesttra.opponent.enums.KeeperLevel;
import br.com.mesttra.opponent.enums.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Opponent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "goals_conceded")
    private Integer goalsConceded;

    @Column(name = "best_player")
    private Integer bestPlayer;


    @Column(name =  "keeper_level")
    @Enumerated(EnumType.ORDINAL)
    private KeeperLevel keeperLevel;

    @Column(name = "default_formation")
    @Enumerated(EnumType.STRING)
    private Formation defaultFormation;

    private boolean rival;

    @Column(name = "next_match_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime nextMatchTime;

    @Enumerated(EnumType.STRING)
    private Result result;

}
