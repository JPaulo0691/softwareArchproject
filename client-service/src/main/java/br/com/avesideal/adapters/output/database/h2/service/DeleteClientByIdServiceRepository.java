package br.com.avesideal.adapters.output.database.h2.service;

import br.com.avesideal.adapters.output.database.h2.repository.ClientRepository;
import br.com.avesideal.application.ports.output.IDeleteClientDomainByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteClientByIdServiceRepository implements IDeleteClientDomainByIdRepository {

    private final ClientRepository clientRepository;

    @Override
    public void execute(Long id) {
        this.clientRepository.deleteById(id);
    }
}
