package br.com.avesideal.adapters.input.web.controller;

import br.com.avesideal.adapters.input.web.api.IClientApi;
import br.com.avesideal.adapters.input.web.api.exception.errors.ClientNotFoundException;
import br.com.avesideal.adapters.input.web.api.request.ClientRequest;
import br.com.avesideal.adapters.input.web.api.response.ClientResponse;
import br.com.avesideal.application.domain.entity.ClientDomain;
import br.com.avesideal.application.mapper.ConverterDTO;
import br.com.avesideal.application.ports.input.ICreateClientDomainUseCase;
import br.com.avesideal.application.ports.input.IDeleteClienteByIdDomainUseCase;
import br.com.avesideal.application.ports.input.IGetClientDomainByIdUseCase;
import br.com.avesideal.application.ports.input.IListAllClientDomainUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientController implements IClientApi {

    private final ICreateClientDomainUseCase      iCreateClientDomainUseCase; // input
    private final IListAllClientDomainUseCase     iListAllClientDomainUseCase;
    private final IGetClientDomainByIdUseCase     iGetClientDomainByIdUseCase;
    private final IDeleteClienteByIdDomainUseCase iDeleteClienteByIdDomainUseCase;

    //conversor de Objetos
    private final ConverterDTO converterDTO;

    @Override
    public ResponseEntity<ClientResponse> createClient(ClientRequest clientRequest) {

        var domain = (ClientDomain) converterDTO.convertObject(clientRequest, ClientDomain.class); // input
        var response = (ClientResponse) converterDTO.convertObject(this.iCreateClientDomainUseCase.execute(domain)
                                                        , ClientResponse.class);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<ClientResponse>> listAllClients() {

        // Converting a domain List to a client Response
        var response = (List<ClientResponse>) converterDTO.convertListObjects(iListAllClientDomainUseCase.execute()
                                                           , ClientResponse.class);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ClientResponse> getClientById(Long id) {

        try{
            var response = (ClientResponse) converterDTO.convertObject(this.iGetClientDomainByIdUseCase.execute(id),ClientResponse.class);

            return ResponseEntity.ok(response);

        }catch(IllegalArgumentException e){
            throw new ClientNotFoundException(id);
        }

    }

    @Override
    public ResponseEntity<?> deleteClientById(Long id) {
        this.iDeleteClienteByIdDomainUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }


}
