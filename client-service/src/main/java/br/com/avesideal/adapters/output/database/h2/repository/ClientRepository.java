package br.com.avesideal.adapters.output.database.h2.repository;

import br.com.avesideal.adapters.output.database.h2.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
