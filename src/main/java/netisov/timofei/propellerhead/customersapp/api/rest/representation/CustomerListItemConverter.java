package netisov.timofei.propellerhead.customersapp.api.rest.representation;

import netisov.timofei.propellerhead.customersapp.domain.Customer;

import java.util.function.Function;

/**
 * Converts customer entity to its presentation in list of customers
 */
public class CustomerListItemConverter implements Function<Customer, CustomersListRepresentation.CustomerRepresentation> {
    @Override
    public CustomersListRepresentation.CustomerRepresentation apply(Customer customer) {
        return CustomersListRepresentation.CustomerRepresentation.builder()
                .id(customer.getId())
                .created(customer.getCreated())
                .name(customer.getName())
                .status(customer.getStatus().name())
                .build();
    }
}
