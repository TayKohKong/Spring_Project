package com.vannak.tech.api_project.domain.model


import javax.persistence.*


@Entity
class Role(id: Long, type: String) {

    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Long = id

    @Column(name = "type")
    var type: String? = type
}