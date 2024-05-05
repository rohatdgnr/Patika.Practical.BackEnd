package ecommerce2.v1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id",columnDefinition = "serial")
    private long id;

    @Column(name = "supplier_address")
    private String address;

    @Column(name = "supplier_company")
    private String company;

    @Column(name = "supplier_person")
    private String person;

    @Column(name = "supplier_mail")
    @Email(message = "")
    private String mail;

    @Column(name = "supplier_contact")
    private String contact;

}
