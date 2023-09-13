package com.exam.Tapcodechallenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "whitelist")
public class WhiteListEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String environment;
    private String application;
    private String clientName;
    private String ipAddress;

    @ManyToOne
    private Client client;
}
