package netisov.timofei.propellerhead.customersapp.service;

import netisov.timofei.propellerhead.customersapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

/**
 * Customer service interacting with db repository
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


}
