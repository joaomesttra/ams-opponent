package br.com.mesttra.opponent.repository;

import br.com.mesttra.opponent.entity.Opponent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public interface OpponentRepository extends MongoRepository<Opponent, String> {

}
