package netisov.timofei.propellerhead.customersapp.resource;

import netisov.timofei.propellerhead.customersapp.api.rest.CustomerResource;
import netisov.timofei.propellerhead.customersapp.domain.Customer;
import netisov.timofei.propellerhead.customersapp.domain.CustomerNote;
import netisov.timofei.propellerhead.customersapp.domain.CustomerStatus;
import netisov.timofei.propellerhead.customersapp.repository.CustomerRepository;
import netisov.timofei.propellerhead.customersapp.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerResource.class)
/**
 * Test for testing the customers REST controller class.
 */
public class CustomerResourceTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;


    private Customer customer;


    @Before
    public void init() {

        customer = Customer.builder()
                .name("Mock customer")
                .contact("contact1")
                .id(1)
                .status(CustomerStatus.CURRENT)
                .build();

        List<CustomerNote> notes = List.of(
                CustomerNote.builder()
                        .content("note1")
                        .id(1)
                        .customer(customer)
                        .build(),
                CustomerNote.builder()
                        .content("note2")
                        .id(2)
                        .customer(customer)
                        .build()
        );

        customer.setNotes(notes);
    }


    @Test
    public void test_getOneWithNotes() throws Exception {

        doReturn(customer).when(customerRepository).getOneWithNotes(1);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/customer/details/1").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{'id':1,'name':'Mock customer','created':null," +
                "'status':'CURRENT','contact':'contact1','notes':[{'id':1,'content':'note1'}," +
                "{'id':2,'content':'note2'}]}";
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Configuration
    public static class LocalTestConfiguration {
        @Autowired
        private AutowireCapableBeanFactory factory;

        @Bean
        public CustomerService customerService() {
            return factory.createBean(CustomerService.class);
        }

        @Bean
        public CustomerResource customerResource() {
            return factory.createBean(CustomerResource.class);
        }

    }


}

