package netisov.timofei.propellerhead.customersapp.repository;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import netisov.timofei.propellerhead.customersapp.domain.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DatabaseSetup("/data/repository/db-before.yml")
@DatabaseSetup("/data/repository/customer/db-before.yml")
@DatabaseTearDown("/data/repository/db-teardown.yml")
/**
 * Test for testing the customer repository class.
 */
public class CustomerRepositoryTest extends RepositoryTestBase {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void givenCustomerExists_thenOk() {
        Integer id = 1;
        List<Customer> customers = customerRepository.findAll();
        Assert.assertNotNull(customers);
        Assert.assertEquals(1, customers.size());
        Assert.assertEquals(id, customers.get(0).getId());
    }

    @Test
    public void testGetOneWithNotes() {
        Integer id = 1;
        Customer customer = customerRepository.getOneWithNotes(id);

        Assert.assertNotNull(customer);
        Assert.assertEquals(id, customer.getId());
        Assert.assertEquals(1, customer.getNotes().size());
        Assert.assertEquals("note", customer.getNotes().get(0).getContent());
    }
}
