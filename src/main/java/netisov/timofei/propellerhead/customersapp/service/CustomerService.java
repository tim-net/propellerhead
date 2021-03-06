package netisov.timofei.propellerhead.customersapp.service;

import netisov.timofei.propellerhead.customersapp.api.rest.representation.CustomerDetailsRepresentation;
import netisov.timofei.propellerhead.customersapp.domain.Customer;
import netisov.timofei.propellerhead.customersapp.domain.CustomerNote;
import netisov.timofei.propellerhead.customersapp.domain.CustomerStatus;
import netisov.timofei.propellerhead.customersapp.dto.PagingAndSortingRequest;
import netisov.timofei.propellerhead.customersapp.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Customer service interacting with db repository
 */
@Service
@Validated
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Returns a page object containing found customers by search conditions
     * got from a filter. Uses converter to convert entities to customer representation objects.
     * @param filter search conditions
     * @param converter converter to a representation object
     * @param <R> class of a representation object.
     * @return
     */
    public <R> Page<R> search(@NotNull @Valid PagingAndSortingRequest filter, @NotNull Function<Customer, R> converter) {
        return customerRepository.findAll(filter.predicate(), filter.pageable()).map(converter);
    }

    /**
     * Returns a customer with its notes as a representation object.
     * @param id id of a customer
     * @return
     */
    public CustomerDetailsRepresentation getOneWithNotes(@NotNull @Valid Integer id) {
        Customer customer = customerRepository.getOneWithNotes(id);
        return CustomerDetailsRepresentation.builder()
                .id(customer.getId())
                .created(customer.getCreated())
                .contact(customer.getContact())
                .name(customer.getName())
                .status(customer.getStatus().name())
                .notes(customer.getNotes().stream().map(n -> CustomerDetailsRepresentation.CustomerNoteRepresentation.builder()
                        .id(n.getId())
                        .content(n.getContent())
                        .build())
                        .collect(Collectors.toList()))
                .build();
    }

    /**
     * Save a customer and its notes.
     * @param customer customer representation object.
     */
    public void save(CustomerDetailsRepresentation customer) {
        Customer customerToSave = Optional.of(customer).map(c -> Customer.builder()
                .id(c.getId())
                .name(c.getName())
                .contact(c.getContact())
                .status(CustomerStatus.valueOf(c.getStatus()))
                .build()).get();
        customerToSave.setNotes(
                customer.getNotes().stream().map(n -> CustomerNote.builder()
                        .id(n.getId())
                        .customer(customerToSave)
                        .content(n.getContent())
                        .build())
                        .collect(Collectors.toList())
        );
        customerRepository.save(customerToSave);
    }

}
