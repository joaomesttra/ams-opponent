package br.com.mesttra.opponent.request;

import br.com.mesttra.opponent.entity.Opponent;
import br.com.mesttra.opponent.enums.Formation;
import br.com.mesttra.opponent.enums.KeeperLevel;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class AlterOpponentRequest {

    private Integer bestPlayer;

    private KeeperLevel keeperLevel;

    private Formation defaultFormation;

    private boolean rival;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime nextMatchTime;

    public Opponent changeOpponent(Opponent opponent) {
        BeanUtils.copyProperties(this, opponent);
        return opponent;
    }
}
