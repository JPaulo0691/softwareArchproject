package br.com.avesideal.application.ports.input;

import br.com.avesideal.application.domain.entity.ClientDomain;

import java.util.List;

public interface IListAllClientDomainUseCase {

    List<ClientDomain> execute();
}
