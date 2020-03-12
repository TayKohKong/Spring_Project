package com.tay.tech.api_project.domain.model


import com.tay.tech.api_project.api.request.CreateUserDTO
import com.tay.tech.api_project.api.request.UpdateUserDTO
import com.tay.tech.api_project.api.request.UserDTO
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "users")
data class User (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        var id: Long = 0,

        @Column(name = "name")
        var name: String,

        @Column(name = "dob")
        var dob: Date,

        @Column(name = "phone_number")
        var phoneNumber: String,

        @Email
        @Column(name = "email")
        var email : String,

        @CreationTimestamp
        @Column(name ="createdAt")
        var createdAt: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        @Column(name = "updatedAt")
        var updatedAt: LocalDateTime = LocalDateTime.now()
){
    @ManyToOne
    @JoinColumn(name= "role_id")
    lateinit var role: Role

    fun toDTO() : UserDTO = UserDTO(
            id = id,
            name = name,
            email = email,
            phoneNumber = phoneNumber,
            dob = dob.toString(),
            role = role.id
    )

    companion object{
        fun fromDTO(dto : CreateUserDTO, role : Role) : User {
            val user = User(
                    name = dto.name,
                    email = dto.email,
                    phoneNumber = dto.phoneNumber,
                    dob = dto.dob
            )
            user.role = role
            return user
        }

        fun fromDTO(newDTO: UpdateUserDTO, role: Role?, oldUser: User): User {
            val user = User(
                    id = oldUser.id,
                    name = newDTO.name ?: oldUser.name,
                    email = newDTO.email ?: oldUser.email,
                    phoneNumber = newDTO.phoneNumber ?: oldUser.phoneNumber,
                    dob = newDTO.dob ?: oldUser.dob
            )

            user.role = role!!
            return user
        }
    }
}