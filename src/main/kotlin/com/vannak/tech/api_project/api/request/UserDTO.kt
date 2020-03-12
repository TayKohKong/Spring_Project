package com.vannak.tech.api_project.api.request

import java.util.*
import javax.validation.constraints.*

data class UserDTO(
        var id : Long,
        var email : String,
        var phoneNumber : String,
        var dob : String,
        var name : String,
        var role : Long
)

data class CreateUserDTO(
        @field:Email
        @field:NotNull
        var email : String,

        @field:NotNull
        @Pattern(regexp = "\\+855[0-9]{8}[0-9]?",message = "Phone number format is invalid")
        var phoneNumber: String,

        @field:NotNull
        @field:Past
        var dob : Date,

        @field:NotNull
        @Size(min = 2, message = "Size must be 2")
        var name : String,

        @field:NotNull
        var role : Long
)

data class UpdateUserDTO(

        @field:Email
        var email : String?,

        @Pattern(regexp = "\\+855[0-9]{8}[0-9]?",message = "Phone number format is invalid")
        var phoneNumber: String?,

        @field:Past
        var dob : Date?,

        @Size(min = 2, message = "Size must be 2")
        var name : String?,

        var role : Long?
)


