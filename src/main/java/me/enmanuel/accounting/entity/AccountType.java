package me.enmanuel.accounting.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 21-Jun-17
 * Time: 3:07 PM
 */
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Data
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_account_type")
    private Integer id;
    @NonNull
    private String description;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Origin origin;
    @NonNull
    @NotNull
    @ManyToOne
    private State state;

    public AccountType(Integer id, String description, Origin origin, State state) {
        this.id = id;
        this.description = description;
        this.origin = origin;
        this.state = state;
    }

    public AccountType(Integer id) {
        this.id = id;
    }
}
