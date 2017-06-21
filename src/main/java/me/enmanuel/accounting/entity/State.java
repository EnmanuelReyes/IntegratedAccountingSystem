package me.enmanuel.accounting.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 21-Jun-17
 * Time: 3:05 PM
 */
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Data
@RequiredArgsConstructor
public class State {
    public static final State ACTIVE = new State(1, "Activo");
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_state")
    @NonNull
    private Integer id;
    @NonNull
    private String description;

}
