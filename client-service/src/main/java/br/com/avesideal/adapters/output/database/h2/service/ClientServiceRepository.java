package br.com.avesideal.adapters.output.database.h2.service;

import br.com.avesideal.adapters.output.database.h2.entity.Client;
import br.com.avesideal.adapters.output.database.h2.repository.ClientRepository;
import br.com.avesideal.application.domain.entity.ClientDomain;
import br.com.avesideal.application.mapper.ConverterDTO;
import br.com.avesideal.application.ports.output.ICreateClientDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceRepository implements ICreateClientDomainRepository {

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;

    @Override
    public ClientDomain execute(ClientDomain clientDomain) {

        var entity = (Client) converterDTO.convertObject(clientDomain, Client.class);
        var domain = (ClientDomain) converterDTO.convertObject(this.clientRepository.save(entity), ClientDomain.class);

        return domain;
    }
}
