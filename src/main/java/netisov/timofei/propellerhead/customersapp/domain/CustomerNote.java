package netisov.timofei.propellerhead.customersapp.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * CustomerRepresentation note entity
 */
@Entity
@Table(name = "customer_note")
public class CustomerNote {

    @Id
    @GeneratedValue(generator = "sqlite")
    @Column(name = "id")
    private Integer id;

    @Size(max = 2000)
    @Column(name = "content")
    private String content;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;



}
