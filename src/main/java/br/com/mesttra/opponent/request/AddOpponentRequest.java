package br.com.mesttra.opponent.request;

import br.com.mesttra.opponent.entity.Opponent;
import br.com.mesttra.opponent.enums.Formation;
import br.com.mesttra.opponent.enums.KeeperLevel;
import br.com.mesttra.opponent.enums.Result;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

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
    private KeeperLevel keeperLevel;

    private Formation defaultFormation;

    @NotNull
    private boolean rival;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime nextMatchTime;

    private Result result;


    public Opponent toEntity() {
        Opponent opponent = new Opponent();
        BeanUtils.copyProperties(this, opponent);
        return opponent;
    }

}
