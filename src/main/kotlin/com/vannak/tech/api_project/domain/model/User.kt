package com.vannak.tech.api_project.domain.model


import java.util.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
class User (id: Int, name: String, dob: Date, phoneNumber: String, email: String, role: Role){

    @Id
    @GeneratedValue
    @Column(name = "id")
    private var id:Int = id

    @Size(min = 2, message = "Size must be 2")
    @Column(name = "name")
    private var name: String = name

    @Past
    @Column(name = "dob")
    private var dob: Date = dob

    @Pattern(regexp = "\\+855[0-9]{8}[0-9]?",message = "Phone number format is invalid")
    @Column(name = "phoneNumber")
    private var phoneNumber: String =phoneNumber;

    @Email
    @Column(name = "email")
    private var email:String = email

    @ManyToOne
    private var role: Role? = role

    fun getId():Int{
        return this.id;
    }
    fun getName(): String{
        return this.name;
    }
    fun getDob(): Date{
        return this.dob;
    }
    fun getPhoneNumber(): String{
        return this.phoneNumber
    }
    fun getEmail():String{
        return this.email
    }

    fun setId(id:Int): Unit{
        this.id=id
    }

    fun getRole(): Role? {
        return role
    }
    
    fun setRole(role: Role): Unit{
        this.role = role
    }
}