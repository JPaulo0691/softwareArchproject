package br.com.avesideal.application.ports.output;

import br.com.avesideal.application.domain.entity.ClientDomain;

import java.util.List;

public interface IListAllClientDomainRepository {

    List<ClientDomain> execute();
}
