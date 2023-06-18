package br.com.avesideal.adapters.output.database.h2.service;

import br.com.avesideal.adapters.output.database.h2.repository.ClientRepository;
import br.com.avesideal.application.domain.entity.ClientDomain;
import br.com.avesideal.application.mapper.ConverterDTO;
import br.com.avesideal.application.ports.output.IGetClientDomainByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetClientByIdServiceRepository implements IGetClientDomainByIdRepository {

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;

    @Override
    public ClientDomain execute(Long id) {
        return (ClientDomain) converterDTO.convertObject(this.clientRepository.findById(id)
                                                       , ClientDomain.class);
    }
}
