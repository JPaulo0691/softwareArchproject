package br.com.avesideal.application.ports.output;

import br.com.avesideal.application.domain.entity.ClientDomain;

public interface ICreateClientDomainRepository {

    ClientDomain execute(ClientDomain clientDomain);
}
