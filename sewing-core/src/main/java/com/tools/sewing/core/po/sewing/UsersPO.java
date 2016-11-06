package com.tools.sewing.core.po.sewing;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Phoebe on 2016/11/6.
 */
@Entity
@Table(name = "users")
@Data
public class UsersPO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="active")
    private Integer active;

    @Column(name="created_at")
    private String createdAt;

    @Column(name="updated_at")
    private String updatedAt;
}
