package br.com.avesideal.adapters.input.web.api;

import br.com.avesideal.adapters.input.web.api.request.ClientRequest;
import br.com.avesideal.adapters.input.web.api.response.ClientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/avesideal/client")
public interface IClientApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ClientResponse> createClient(@RequestBody ClientRequest clientRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ClientResponse>> listAllClients();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ClientResponse> getClientById(@PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<?> deleteClientById(@PathVariable("id") Long id);
}
