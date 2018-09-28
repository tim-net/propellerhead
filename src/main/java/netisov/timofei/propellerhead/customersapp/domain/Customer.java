package netisov.timofei.propellerhead.customersapp.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * CustomerRepresentation entity
 */
@Entity
@Table(name = "customer")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "created", nullable = false, updatable = false, insertable = false)
    private LocalDateTime created;

    @Setter
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CustomerNote> notes;

    @Builder
    public Customer(Integer id, String name, String contact, CustomerStatus status, List<CustomerNote> notes) {
        Objects.requireNonNull(name);
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.status = status;
        this.notes = notes;
    }


}
