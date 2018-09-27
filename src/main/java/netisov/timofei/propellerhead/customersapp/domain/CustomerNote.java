package netisov.timofei.propellerhead.customersapp.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * CustomerRepresentation note entity
 */
@Entity
@Table(name = "customer_note")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(max = 2000)
    @Column(name = "content")
    private String content;

//    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Builder
    public CustomerNote(Integer id, String content, Customer customer) {
        Objects.requireNonNull(content);
        Objects.requireNonNull(customer);
        this.id = id;
        this.content = content;
        this.customer = customer;
    }

}
