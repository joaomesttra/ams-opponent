package br.com.mesttra.opponent.repository;

import br.com.mesttra.opponent.entity.Opponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpponentRepository extends JpaRepository<Opponent, Long> {

}
