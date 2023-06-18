package br.com.avesideal.application.domain.entity;

import br.com.avesideal.application.ports.input.ICreateClientDomainUseCase;
import br.com.avesideal.application.ports.output.ICreateClientDomainRepository;
import br.com.avesideal.application.ports.output.IDeleteClientDomainByIdRepository;
import br.com.avesideal.application.ports.output.IGetClientDomainByIdRepository;
import br.com.avesideal.application.ports.output.IListAllClientDomainRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDomain {

    private Long id;
    private String name;
    private String document;
    private String phone;

    public ClientDomain save(ICreateClientDomainRepository iCreateClientDomainRepository){
        return iCreateClientDomainRepository.execute(this);
    }

    public List<ClientDomain> list(IListAllClientDomainRepository iListAllClientDomainRepository){
        return iListAllClientDomainRepository.execute();
    }

    public ClientDomain getClientDomainById(IGetClientDomainByIdRepository iGetClientDomainByIdRepository){
        return iGetClientDomainByIdRepository.execute(this.id);
    }

    public void deleteClientDomainById(IDeleteClientDomainByIdRepository iDeleteClientDomainByIdRepository){
        iDeleteClientDomainByIdRepository.execute(this.id);
    }


}
