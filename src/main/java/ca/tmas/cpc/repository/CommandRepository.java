package ca.tmas.cpc.repository;

import ca.tmas.cpc.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<Command, String> {
}
