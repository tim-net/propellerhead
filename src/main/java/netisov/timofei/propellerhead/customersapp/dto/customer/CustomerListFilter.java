package netisov.timofei.propellerhead.customersapp.dto.customer;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import netisov.timofei.propellerhead.customersapp.domain.Customer;
import netisov.timofei.propellerhead.customersapp.dto.PagingAndSortingRequest;
import org.apache.commons.lang3.StringUtils;

import static netisov.timofei.propellerhead.customersapp.domain.QCustomer.customer;

@ApiModel(value = "CustomerRepresentation list filter", description = "A filter for a list of customers")
@Getter
@Setter
public class CustomerListFilter extends PagingAndSortingRequest<Customer> {

    @ApiModelProperty(value = "Search string for name", position = 10)
    public String name;

    @Override
    public Predicate predicate() {
        BooleanBuilder builder = new BooleanBuilder();
        if (!StringUtils.isEmpty(name)) {
            builder.and(customer.name.likeIgnoreCase("%" + name + "%"));
        }
        return builder;
    }

    @Override
    protected OrderSpecifier<?> orderBy(Order order, String field) {
        switch (field) {
            case "name":
                return new OrderSpecifier<>(order, customer.name);
            case "created":
                return new OrderSpecifier<>(order, customer.created);
            case "status":
                return new OrderSpecifier<>(order, customer.status);
            default:
                return new OrderSpecifier<>(order, customer.name);
        }
    }
}
