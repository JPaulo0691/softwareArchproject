package br.com.avesideal.application.usecase;

import br.com.avesideal.application.domain.entity.ClientDomain;
import br.com.avesideal.application.ports.input.IDeleteClienteByIdDomainUseCase;
import br.com.avesideal.application.ports.output.IDeleteClientDomainByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteClientDomainByIdUseCase implements IDeleteClienteByIdDomainUseCase {

    private final IDeleteClientDomainByIdRepository iDeleteClientDomainByIdRepository;

    @Override
    public void execute(Long id) {
        ClientDomain.builder()
                    .id(id)
                    .build()
                    .deleteClientDomainById(iDeleteClientDomainByIdRepository);
    }
}
