package br.com.avesideal.application.ports.input;

import br.com.avesideal.application.domain.entity.ClientDomain;

public interface ICreateClientDomainUseCase {

    ClientDomain execute(ClientDomain clientDomain);
}
