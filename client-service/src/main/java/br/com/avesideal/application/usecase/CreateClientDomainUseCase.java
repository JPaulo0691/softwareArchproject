package br.com.avesideal.application.usecase;

import br.com.avesideal.application.domain.entity.ClientDomain;
import br.com.avesideal.application.ports.input.ICreateClientDomainUseCase;
import br.com.avesideal.application.ports.output.ICreateClientDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateClientDomainUseCase implements ICreateClientDomainUseCase {

    private final ICreateClientDomainRepository iCreateClientDomainRepository;

    @Override
    public ClientDomain execute(ClientDomain clientDomain) {
        return clientDomain.save(iCreateClientDomainRepository);
    }
}
