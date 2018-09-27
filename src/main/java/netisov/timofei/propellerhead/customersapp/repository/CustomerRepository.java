package netisov.timofei.propellerhead.customersapp.repository;

import netisov.timofei.propellerhead.customersapp.domain.Customer;
import netisov.timofei.propellerhead.customersapp.repository.base.RepositoryBase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository (DB-access) for customer entities
 */
@Repository
public interface CustomerRepository extends RepositoryBase<Customer, Integer> {

    @Query("select c from Customer c left join fetch c.notes where c.id=?1")
    Customer getOneWithNotes(Integer id);
}
