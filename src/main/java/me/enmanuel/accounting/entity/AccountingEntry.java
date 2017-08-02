package me.enmanuel.accounting.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 23-Jun-17
 * Time: 11:10 AM
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@NoArgsConstructor
public class AccountingEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_accounting_entry")
    @ApiModelProperty(hidden = true)
    private Integer id;
    private String description;
    @NotNull
    @ManyToOne
    private Auxiliary auxiliary;

    @ApiModelProperty(hidden = true)
    private LocalDateTime date;
    @NotNull
    @ManyToOne
    @ApiModelProperty(hidden = true)
    private State state;

    @OneToMany(mappedBy = "accountingEntry")
    @Cascade(CascadeType.REMOVE)
    private List<Transaction> transactions;
}
