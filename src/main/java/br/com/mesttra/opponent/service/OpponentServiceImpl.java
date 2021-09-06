package br.com.mesttra.opponent.service;

import br.com.mesttra.opponent.entity.Opponent;
import br.com.mesttra.opponent.exception.BusinessException;
import br.com.mesttra.opponent.repository.OpponentRepository;
import br.com.mesttra.opponent.request.AddOpponentRequest;
import br.com.mesttra.opponent.request.AlterOpponentRequest;
import br.com.mesttra.opponent.request.ChangeConcededGoalsRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OpponentServiceImpl implements OpponentService {

    OpponentRepository opponentRepository;

    public OpponentServiceImpl(OpponentRepository opponentRepository) {
        this.opponentRepository = opponentRepository;
    }

    public Opponent addOpponent(AddOpponentRequest addPlayerRequest) {
        return this.opponentRepository.save(addPlayerRequest.toEntity());
    }

    public List<Opponent> listOpponents() {
        return (List<Opponent>) this.opponentRepository.findAll();
    }

    public Optional<Opponent> getOpponent(String opponentId) {
        return this.opponentRepository.findById(opponentId);
    }

    public Opponent alterOpponent(String opponentId, AlterOpponentRequest alterOpponentRequest) throws BusinessException {

        Optional<Opponent> opponentDb = this.opponentRepository.findById(opponentId);

        if (opponentDb.isEmpty()) {
            throw new BusinessException("The opponent could not be found");
        }

        Opponent opponent = alterOpponentRequest.changeOpponent(opponentDb.get());
        return this.opponentRepository.save(opponent);
    }

    public Opponent changeGoalsConceded(String opponentId, ChangeConcededGoalsRequest changeConcededGoalsRequest) {
        Optional<Opponent> opponentDb = this.opponentRepository.findById(opponentId);

        if (opponentDb.isEmpty()) {
            return null;
        }

        Opponent opponent = opponentDb.get();
        opponent.setGoalsConceded(changeConcededGoalsRequest.getGoalsConceded());
        return  this.opponentRepository.save(opponent);
    }
}
