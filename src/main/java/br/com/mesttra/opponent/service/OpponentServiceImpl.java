package br.com.mesttra.opponent.service;

import br.com.mesttra.opponent.entity.Opponent;
import br.com.mesttra.opponent.exception.BusinessException;
import br.com.mesttra.opponent.repository.OpponentRepository;
import br.com.mesttra.opponent.request.AddOpponentRequest;
import br.com.mesttra.opponent.request.AlterOpponentRequest;
import br.com.mesttra.opponent.request.ChangeConcededGoalsRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class OpponentServiceImpl implements OpponentService {

    OpponentRepository opponentRepository;

    public OpponentServiceImpl(OpponentRepository opponentRepository) {
        this.opponentRepository = opponentRepository;
    }

    public Opponent addOpponent(AddOpponentRequest addPlayerRequest) {
        return this.opponentRepository.save(addPlayerRequest.toEntity());
    }

    public Page<Opponent> listOpponents(Pageable pageable) {
        return this.opponentRepository.findAll(pageable);
    }

    public Opponent getOpponent(Long opponentId) {
        return this.opponentRepository.getById(opponentId);
    }

    @Transactional
    public Opponent alterOpponent(Long opponentId, AlterOpponentRequest alterOpponentRequest) throws BusinessException {

        Optional<Opponent> opponentDb = this.opponentRepository.findById(opponentId);

        if (opponentDb.isEmpty()) {
            throw new BusinessException("The opponent could not be found");
        }

        Opponent opponent = alterOpponentRequest.changeOpponent(opponentDb.get());
        return this.opponentRepository.save(opponent);
    }

    @Transactional
    public Opponent changeGoalsConceded(Long opponentId, ChangeConcededGoalsRequest changeConcededGoalsRequest) {
        Opponent opponentDb = this.opponentRepository.getById(opponentId);

        if (isNull(opponentDb)) {
            return null;
        }

        opponentDb.setGoalsConceded(changeConcededGoalsRequest.getGoalsConceded());
        return  this.opponentRepository.save(opponentDb);
    }
}
