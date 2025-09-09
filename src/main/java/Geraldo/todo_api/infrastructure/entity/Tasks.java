package Geraldo.todo_api.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tasks")
@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "deliveryDate")
    private LocalDate deliveryDate;

    @Column(name = "responsible")
    private String responsible;

}
