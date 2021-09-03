package br.com.mesttra.opponent.entity;

import br.com.mesttra.opponent.enums.Formation;
import br.com.mesttra.opponent.enums.KeeperLevel;
import br.com.mesttra.opponent.enums.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "opponent")
public class Opponent {

    @Id
    private String id;

    private String name;

    private Integer goalsConceded;

    private Integer bestPlayer;

    private KeeperLevel keeperLevel;

    private Formation defaultFormation;

    private boolean rival;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime nextMatchTime;

    private Result result;

}
