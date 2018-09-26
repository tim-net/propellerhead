package netisov.timofei.propellerhead.customersapp.dto.customer;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import io.swagger.annotations.ApiModel;
import netisov.timofei.propellerhead.customersapp.domain.Customer;
import netisov.timofei.propellerhead.customersapp.dto.PagingAndSortingRequest;

import static netisov.timofei.propellerhead.customersapp.domain.QCustomer.customer;

@ApiModel(value = "CustomerRepresentation list filter", description = "A filter for a list of customers")
public class CustomerListFilter extends PagingAndSortingRequest<Customer> {

    @Override
    public Predicate predicate() {
        BooleanBuilder builder = new BooleanBuilder();
        return builder;
    }

    @Override
    protected OrderSpecifier<?> orderBy(Order order, String field) {
        switch (field) {
            case "name":
                return new OrderSpecifier<>(order, customer.name);
            case "created":
                return new OrderSpecifier<>(order, customer.created);
            default:
                return new OrderSpecifier<>(order, customer.name);
        }
    }
}
