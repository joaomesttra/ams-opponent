package br.com.mesttra.opponent.repository;

import br.com.mesttra.opponent.entity.Opponent;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface OpponentRepository extends CrudRepository<Opponent, String> {
}
