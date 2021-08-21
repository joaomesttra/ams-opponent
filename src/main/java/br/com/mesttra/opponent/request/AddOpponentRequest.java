package br.com.mesttra.opponent.request;

import br.com.mesttra.opponent.entity.Opponent;
import br.com.mesttra.opponent.enums.Formation;
import br.com.mesttra.opponent.enums.KeeperLevel;
import br.com.mesttra.opponent.enums.Result;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class AddOpponentRequest {

    @NotBlank
    private String name;

    @NotNull
    private Integer goalsConceded;

    @NotNull
    private Integer bestPlayer;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private KeeperLevel keeperLevel;

    @Enumerated(EnumType.STRING)
    private Formation defaultFormation;

    @NotNull
    private boolean rival;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime nextMatchTime;

    @Enumerated(EnumType.STRING)
    private Result result;


    public Opponent toEntity() {
        Opponent opponent = new Opponent();
        BeanUtils.copyProperties(this, opponent);
        return opponent;
    }

}
