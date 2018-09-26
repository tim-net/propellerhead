package netisov.timofei.propellerhead.customersapp.repository;

import netisov.timofei.propellerhead.customersapp.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository (DB-access) for customer entities
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
