package com.vannak.tech.api_project.api.controller

import com.vannak.tech.api_project.api.exception.IDNotFoundException
import com.vannak.tech.api_project.domain.model.User
import com.vannak.tech.api_project.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.lang.RuntimeException
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/users"])
class UserController(
        @Autowired var service: UserService
) {

    @GetMapping
    fun getAllUser(): ResponseEntity<Any>{
        return service.findAll();
    }

    @GetMapping("/{id}")
    fun retrieveUser(@PathVariable id:Int): User {
       return service.findOne(id)
    }
    @PostMapping
    fun createUser(@Valid @RequestBody user: User):ResponseEntity<Any>{
        var savedUser = service.save(user)
        return ResponseEntity.ok(savedUser)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id:Int):Unit{
        try {
            val user = service.deleteById(id)
        } catch (e: RuntimeException){
            throw IDNotFoundException("userId")
        }


    }

}