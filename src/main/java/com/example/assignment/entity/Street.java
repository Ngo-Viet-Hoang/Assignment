package com.example.assignment.entity;

import com.example.assignment.entity.entiyEnum.StreetStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table (name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int districtid;
    private LocalDateTime establishment;
    private String description;
    private StreetStatus status;

}
