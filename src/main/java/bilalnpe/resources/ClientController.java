package bilalnpe.resources;

import bilalnpe.model.Client;
import bilalnpe.persistance.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client/")
@AllArgsConstructor
public class ClientController {

    ClientRepository clientRepository;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{clientId}", produces = "application/json")
    public ResponseEntity<Client> getClientById(@PathVariable long clientId) {
        return ResponseEntity.of(clientRepository.findById(clientId));
    }

    @PostMapping(value = "/")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        client.setId(null);
        Client createdClient = clientRepository.save(client);
        return new ResponseEntity<>(createdClient, HttpStatus.OK);
    }

    @PutMapping(value = "/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable long clientId, @RequestBody Client client) {
        client.setId(clientId);
        Client createdClient = clientRepository.save(client);
        return new ResponseEntity<>(createdClient, HttpStatus.OK);
    }
}
