package netisov.timofei.propellerhead.customersapp.dto.customer;


import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import io.swagger.annotations.ApiModel;
import netisov.timofei.propellerhead.customersapp.domain.Customer;
import netisov.timofei.propellerhead.customersapp.dto.PagingAndSortingRequest;

@ApiModel(value = "CustomerRepresentation list filter", description = "A filter for a list of customers")
public class CustomerListFilter extends PagingAndSortingRequest<Customer> {

    @Override
    public Predicate predicate() {
        return null;
    }

    @Override
    protected OrderSpecifier<?> orderBy(Order order, String field) {
        return null;
    }
}
