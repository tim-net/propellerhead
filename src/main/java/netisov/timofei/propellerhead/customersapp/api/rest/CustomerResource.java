package netisov.timofei.propellerhead.customersapp.api.rest;

import netisov.timofei.propellerhead.customersapp.api.rest.representation.CustomerDetailsRepresentation;
import netisov.timofei.propellerhead.customersapp.api.rest.representation.CustomerListItemConverter;
import netisov.timofei.propellerhead.customersapp.api.rest.representation.CustomersListRepresentation;
import netisov.timofei.propellerhead.customersapp.dto.customer.CustomerListFilter;
import netisov.timofei.propellerhead.customersapp.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for providing operations on customers
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerResource {

    private final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    private final CustomerService customerService;
    /**
     * Converter for converting entities to the customer representation object
     */
    private final CustomerListItemConverter customerListItemConverter = new CustomerListItemConverter();


    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Returns a representation object which contains
     * a list of found customers whithin a range of a page's size
     * and the total number of
     * customers found using a filter.
     * @param filter filter containing search conditions
     * @return
     */
    @GetMapping("/find-all")
    public CustomersListRepresentation findAll(CustomerListFilter filter) {
        log.debug("REST request to get a page of Customers");
        Page<CustomersListRepresentation.CustomerRepresentation> result = customerService.search(filter, customerListItemConverter);
        return CustomersListRepresentation.builder()
                .count(result.getTotalElements())
                .customers(result.getContent())
                .build();
    }

    /**
     * Returns one customer found by its id
     * @param id id of a customer
     * @return
     */
    @GetMapping("/details/{id}")
    public CustomerDetailsRepresentation getDetails(@PathVariable Integer id) {
        log.debug("REST request to get details of a Customer");
        return customerService.getOneWithNotes(id);
    }

    /**
     * Saves a customer.
     * @param customer
     * @return true if the operation was successful
     */
    @PostMapping("/save")
    public boolean save(@RequestBody CustomerDetailsRepresentation customer) {
        try {
            customerService.save(customer);
        } catch (RuntimeException e) {
            log.error("Exception during saving a customer", e);
            return false;
        }
        return true;
    }

}
