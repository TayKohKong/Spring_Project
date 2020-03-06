package com.vannak.tech.api_project.domain.model


import javax.persistence.*


@Entity
class Role(id: Int, type: String) {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private var id: Int? = id

    @Column(name = "type")
    private var type: String? = type


    fun getId(): Int? {
        return this.id
    }

    fun setId(id: Int): Unit{
        this.id = id
    }


    fun getType(): String?{
        return this.type
    }

    fun setType(type: String): Unit{
        this.type = type
    }

//    fun getUser(): List<User>?{
//        return this.users
//    }
//
//    fun setUser(users: List<User>): Unit{
//        this.users = users
//    }

}