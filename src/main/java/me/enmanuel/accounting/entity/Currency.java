package me.enmanuel.accounting.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 21-Jun-17
 * Time: 3:13 PM
 */

//@Entity
@DynamicInsert
@DynamicUpdate
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_currency")
    private Integer id;
    @NotNull
    @ManyToOne
    private State state;

}
