package br.com.mesttra.opponent.controller;

import br.com.mesttra.opponent.entity.Opponent;
import br.com.mesttra.opponent.exception.BusinessException;
import br.com.mesttra.opponent.request.AddOpponentRequest;
import br.com.mesttra.opponent.request.AlterOpponentRequest;
import br.com.mesttra.opponent.request.ChangeConcededGoalsRequest;
import br.com.mesttra.opponent.service.OpponentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/opponents")
public class OpponentController {

    OpponentService opponentService;

    public OpponentController(OpponentService opponentService) {
        this.opponentService = opponentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Opponent addOpponent(@Valid @RequestBody AddOpponentRequest addOpponentRequest) {
        return opponentService.addOpponent(addOpponentRequest);
    }

    @GetMapping
    public Page<Opponent> listOpponents(@PageableDefault Pageable pageable) {
        return opponentService.listOpponents(pageable);
    }

    @GetMapping("/{opponentId}")
    public Optional<Opponent> getOpponent(@PathVariable String opponentId) {
        return opponentService.getOpponent(opponentId);
    }

    @PutMapping("/{opponentId}")
    public Opponent alterOpponent(@PathVariable String opponentId,
                                  @RequestBody AlterOpponentRequest alterOpponentRequest) throws BusinessException {
        return opponentService.alterOpponent(opponentId, alterOpponentRequest);
    }

    @PatchMapping("/{opponentId}")
    public Opponent changeGoalsConceded(@PathVariable String opponentId, @RequestBody ChangeConcededGoalsRequest changeConcededGoalsRequest){
        return opponentService.changeGoalsConceded(opponentId, changeConcededGoalsRequest);
    }
}
