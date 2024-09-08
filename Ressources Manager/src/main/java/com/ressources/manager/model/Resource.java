package com.ressources.manager.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;
    private String resourceName;
    private String resourceType;
    private String resourceQuantity;
    private String resourceProvider;
    private Long taskId;

}
