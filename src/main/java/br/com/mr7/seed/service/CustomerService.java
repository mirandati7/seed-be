package br.com.mr7.seed.service;

import br.com.mr7.seed.model.Customer;
import br.com.mr7.seed.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerService {

    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository){
        this.repository = repository;
    }

    public Customer save(Customer customer){
        return this.repository.save(customer);
    }

    public Customer findByID(Long id){
        return repository
                    .findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void delete(Long id){
        repository.findById(id)
                .map(customer -> {
                    repository.delete(customer);
                    return Void.TYPE;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }

}
