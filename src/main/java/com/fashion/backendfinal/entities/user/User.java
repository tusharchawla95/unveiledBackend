package com.fashion.backendfinal.entities.user;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
public class User implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    Integer id;
    @Column(name="name" , nullable = false)
    String name;
    @Column(name="email", nullable = false)
    String email;
    @Column(name="pass", nullable = false)
    String pass;
    @Column(name="mobile", nullable = false)
    String mobile;

}
