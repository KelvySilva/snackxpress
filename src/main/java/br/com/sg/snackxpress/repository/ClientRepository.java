package br.com.sg.snackxpress.repository;

import br.com.sg.snackxpress.domain.person.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
