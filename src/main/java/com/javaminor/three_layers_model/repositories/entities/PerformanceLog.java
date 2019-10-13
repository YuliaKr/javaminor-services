package com.javaminor.three_layers_model.repositories.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "performanceLog")
@Table(name = "performanceLog")
@Getter
@Setter

public class PerformanceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "durationMS", nullable = false)
    private long durationMs;

    @Column(name = "callingClass", nullable = false)
    private String callingClass;

    @Column(name = "callingMethod", nullable = false)
    private String callingMethod;
}
