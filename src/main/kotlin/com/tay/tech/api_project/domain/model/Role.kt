package com.tay.tech.api_project.domain.model


import javax.persistence.*


@Entity
@Table(name = "roles")
data class Role(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long = 0,

    @Column(name = "type")
    var type: String
)