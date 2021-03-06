package com.backend.ItemTracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "roleId", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties("users")
    private Role role;

    @Column
    private String userName;

    @Column
    private String email;

    @OneToOne
    @JoinColumn(name = "itemId", referencedColumnName = "id")
    @JsonIgnoreProperties("collections")
    private Item favorite;

}
