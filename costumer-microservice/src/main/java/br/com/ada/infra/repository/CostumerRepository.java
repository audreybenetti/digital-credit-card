package br.com.ada.infra.repository;

import br.com.ada.domain.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {
    Optional<Costumer> findByCpf(String cpf);

}
