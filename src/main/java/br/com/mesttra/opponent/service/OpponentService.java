package br.com.mesttra.opponent.service;

import br.com.mesttra.opponent.entity.Opponent;
import br.com.mesttra.opponent.exception.BusinessException;
import br.com.mesttra.opponent.request.AddOpponentRequest;
import br.com.mesttra.opponent.request.AlterOpponentRequest;
import br.com.mesttra.opponent.request.ChangeConcededGoalsRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OpponentService {

    Opponent addOpponent(AddOpponentRequest addPlayerRequest);

    Page<Opponent> listOpponents(Pageable pageable);

    Optional<Opponent> getOpponent(String opponentId);

    Opponent alterOpponent(String opponentId, AlterOpponentRequest alterOpponentRequest) throws BusinessException;

    Opponent changeGoalsConceded(String opponentId, ChangeConcededGoalsRequest changeConcededGoalsRequest);

}
