package br.com.avesideal.application.usecase;

import br.com.avesideal.application.domain.entity.ClientDomain;
import br.com.avesideal.application.ports.input.IGetClientDomainByIdUseCase;
import br.com.avesideal.application.ports.output.IGetClientDomainByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetClientDomainUseCase implements IGetClientDomainByIdUseCase {

    private final IGetClientDomainByIdRepository iGetClientDomainByIdRepository;

    @Override
    public ClientDomain execute(Long id) {
        return ClientDomain.builder()
                           .id(id)
                           .build()
                           .getClientDomainById(iGetClientDomainByIdRepository);
    }
}
