package br.com.avesideal.application.usecase;

import br.com.avesideal.application.domain.entity.ClientDomain;
import br.com.avesideal.application.ports.input.IListAllClientDomainUseCase;
import br.com.avesideal.application.ports.output.ICreateClientDomainRepository;
import br.com.avesideal.application.ports.output.IListAllClientDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListAllClientDomainUseCase implements IListAllClientDomainUseCase {

    private final IListAllClientDomainRepository iListAllClientDomainRepository;

    @Override
    public List<ClientDomain> execute() {

        return ClientDomain.builder()
                           .build()
                           .list(iListAllClientDomainRepository);
    }
}
