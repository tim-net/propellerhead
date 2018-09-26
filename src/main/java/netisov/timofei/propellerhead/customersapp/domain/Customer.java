package netisov.timofei.propellerhead.customersapp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * CustomerRepresentation entity
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(generator = "sqlite")
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(max = 256)
    @Column(name = "name")
    private String name;

    @Size(max = 2000)
    @Column(name = "contact")
    private String contact;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private CustomerStatus status;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<CustomerNote> notes;

}