package br.com.ada.application;

import br.com.ada.domain.Costumer;
import br.com.ada.infra.repository.CostumerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CostumerService {

    private final CostumerRepository repository;

    public CostumerService(CostumerRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Costumer save(Costumer costumer){
        return repository.save(costumer);
    }

    public Optional<Costumer> getByCpf (String cpf){
        return repository.findByCpf(cpf);
    }


}
