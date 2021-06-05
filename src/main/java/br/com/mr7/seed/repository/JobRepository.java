package br.com.mr7.seed.repository;

import br.com.mr7.seed.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Customer, Long> {




}
