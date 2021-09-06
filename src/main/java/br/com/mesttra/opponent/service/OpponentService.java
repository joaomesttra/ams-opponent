package br.com.mesttra.opponent.service;

import br.com.mesttra.opponent.entity.Opponent;
import br.com.mesttra.opponent.exception.BusinessException;
import br.com.mesttra.opponent.request.AddOpponentRequest;
import br.com.mesttra.opponent.request.AlterOpponentRequest;
import br.com.mesttra.opponent.request.ChangeConcededGoalsRequest;

import java.util.List;
import java.util.Optional;

public interface OpponentService {

    Opponent addOpponent(AddOpponentRequest addPlayerRequest);

    List<Opponent> listOpponents();

    Optional<Opponent> getOpponent(String opponentId);

    Opponent alterOpponent(String opponentId, AlterOpponentRequest alterOpponentRequest) throws BusinessException;

    Opponent changeGoalsConceded(String opponentId, ChangeConcededGoalsRequest changeConcededGoalsRequest);

}
