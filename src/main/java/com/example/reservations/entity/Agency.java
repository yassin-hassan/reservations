package com.example.reservations.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "agencies")
@Data
@NoArgsConstructor
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<Artist> artists;

    public Agency(String name) {
        this.name = name;
    }
}