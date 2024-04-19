package edu.iu.habahram.DinerPancakeHouseMerge.controllers;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Customer;
import org.springframework.web.bind.annotation.*;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CustomerRepository;


@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthenticationController {
    CustomerRepository customerRepository;

    public AuthenticationController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer) throws Exception {
        customerRepository.save(customer);
    }
}