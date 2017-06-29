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
 * User: enmanuelreyes
 * Date: 6/29/17
 * Time: 6:41 PM
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@RequiredArgsConstructor
public class Auxiliary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_auxiliary")
    private Integer id;
    @NonNull
    private String description;
    @NonNull
    @NotNull
    @ManyToOne
    private State state;

    public Auxiliary() {
    }

    public Auxiliary(Integer id, String description, State state) {
        this.id = id;
        this.description = description;
        this.state = state;
    }

}

