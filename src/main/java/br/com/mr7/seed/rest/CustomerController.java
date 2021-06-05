package br.com.mr7.seed.rest;

import br.com.mr7.seed.model.Customer;
import br.com.mr7.seed.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody @Valid Customer customer){
       return service.save(customer);
    }

    @GetMapping("{id}")
    public Customer findByID(@PathVariable Long id){
        return  service.findByID(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
     }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id,
                       @RequestBody Customer customerUpdate){

        service.update(id,customerUpdate);
    }
}
