package netisov.timofei.propellerhead.customersapp.api.rest;

import netisov.timofei.propellerhead.customersapp.api.rest.representation.CustomerListItemConverter;
import netisov.timofei.propellerhead.customersapp.api.rest.representation.CustomerListRepresentation;
import netisov.timofei.propellerhead.customersapp.dto.customer.CustomerListFilter;
import netisov.timofei.propellerhead.customersapp.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for providing operations on customers
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerResource {

    private final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    private final CustomerService customerService;
    private final CustomerListItemConverter customerListItemConverter = new CustomerListItemConverter();


    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/find-all")
    public CustomerListRepresentation findAll(CustomerListFilter filter) {
        log.debug("REST request to get a page of Incidents");
        Page<CustomerListRepresentation.CustomerRepresentation> result = customerService.search(filter, customerListItemConverter);
        return CustomerListRepresentation.builder()
                .count(result.getTotalElements())
                .customers(result.getContent())
                .build();
    }


}
