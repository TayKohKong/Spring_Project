package com.vannak.tech.api_project.api.controller

import com.vannak.tech.api_project.api.exception.IDNotFoundException
import com.vannak.tech.api_project.domain.model.User
import com.vannak.tech.api_project.repository.UserRepository
import com.vannak.tech.api_project.service.UserService
import org.apache.juli.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.lang.RuntimeException
import java.net.URI
import java.util.*
import java.util.logging.Logger
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/users"])
class UserController(
        @Autowired var userRepository: UserRepository

) {

    val logger = Logger.getLogger(UserController::class.java.name)

    @GetMapping("/all")
    fun getAllUser(): ResponseEntity<List<User>>{
        val users = userRepository.findAll()
        return  ResponseEntity.ok(users)
    }

    @GetMapping("/{id}")
    fun retrieveUser(@PathVariable id:Int): ResponseEntity<User> {
       val user =  userRepository.findById(id).get()
        return ResponseEntity.ok(user)
    }

    @PostMapping
    fun createUser(@Valid @RequestBody user: User): ResponseEntity<User>{
        var user = userRepository.save(user)
        return ResponseEntity.ok(user)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id:Int): ResponseEntity<Unit> {
        try {
            val user = userRepository.deleteById(id)
            logger.info("$user")
            return ResponseEntity.ok(user)
        } catch (e: RuntimeException){
            throw IDNotFoundException("userId")
        }

    }

    @GetMapping("/search")
    fun findByName(@RequestParam value: String): ResponseEntity<Optional<List<User>>> {
        val users = userRepository.findByValue(value)

        return ResponseEntity.ok(users)
    }

    

}