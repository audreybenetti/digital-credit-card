package br.com.ada.application;

import br.com.ada.application.representation.CostumerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("costumers")
public class CostumerController {

    private final CostumerService service;

    public CostumerController(CostumerService service) {
        this.service = service;
    }

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CostumerRequest request){
        var costumer = request.toModel();
        service.save(costumer);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(costumer.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity getCostumer(@RequestParam("cpf") String cpf){
        var costumer = service.getByCpf(cpf);
        if (costumer.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(costumer);
    }

}
