package netisov.timofei.propellerhead.customersapp.service;

import netisov.timofei.propellerhead.customersapp.domain.Customer;
import netisov.timofei.propellerhead.customersapp.dto.PagingAndSortingRequest;
import netisov.timofei.propellerhead.customersapp.repository.CustomerRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.function.Function;

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


    public <R> Page<R> search(@NotNull @Valid PagingAndSortingRequest filter, @NotNull Function<Customer, R> converter) {
        return customerRepository.findAll(filter.predicate(), filter.pageable()).map(converter);
    }


}
