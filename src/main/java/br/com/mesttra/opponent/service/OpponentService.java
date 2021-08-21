package br.com.mesttra.opponent.service;

import br.com.mesttra.opponent.entity.Opponent;
import br.com.mesttra.opponent.exception.BusinessException;
import br.com.mesttra.opponent.request.AddOpponentRequest;
import br.com.mesttra.opponent.request.AlterOpponentRequest;
import br.com.mesttra.opponent.request.ChangeConcededGoalsRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OpponentService {

    Opponent addOpponent(AddOpponentRequest addPlayerRequest);

    Page<Opponent> listOpponents(Pageable pageable);

    Opponent getOpponent(Long opponentId);

    Opponent alterOpponent(Long opponentId, AlterOpponentRequest alterOpponentRequest) throws BusinessException;

    Opponent changeGoalsConceded(Long opponentId, ChangeConcededGoalsRequest changeConcededGoalsRequest);

}
