package br.com.avesideal.adapters.output.database.h2.service;

import br.com.avesideal.adapters.output.database.h2.repository.ClientRepository;
import br.com.avesideal.application.domain.entity.ClientDomain;
import br.com.avesideal.application.mapper.ConverterDTO;
import br.com.avesideal.application.ports.output.IListAllClientDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ListAllClientsServiceRepository implements IListAllClientDomainRepository {

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;

    @Override
    public List<ClientDomain> execute() {

        return (List<ClientDomain>) converterDTO.convertListObjects(this.clientRepository.findAll(), ClientDomain.class);
    }
}
