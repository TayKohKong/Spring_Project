package com.vannak.tech.api_project.api.controller

import com.vannak.tech.api_project.api.exception.IDNotFoundException
import com.vannak.tech.api_project.domain.model.User
import com.vannak.tech.api_project.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/users"])
class UserController(
        @Autowired var userService: UserService
) {

    @GetMapping("/all")
    fun getAllUser(): ResponseEntity<List<User>>{
        val users = userService.getAllUser()
        return  ResponseEntity.ok(users)
    }

    @GetMapping("/{id}")
    fun retrieveUser(@PathVariable id:Int): ResponseEntity<User> {
       val user =  userService.getUserById(id)
        return ResponseEntity.ok(user)
    }

    @PostMapping
    fun createUser(@Valid @RequestBody user: User): ResponseEntity<User>{
        var user = userService.createUser(user)
        return ResponseEntity.ok(user)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id:Int): ResponseEntity<String> {
        try {
            val msg = userService.deleteUserById(id)
            return ResponseEntity.ok(msg)
        } catch (e: RuntimeException){
            throw IDNotFoundException("userId")
        }

    }

    @GetMapping("/search")
    fun findByValue(@RequestParam value: String): ResponseEntity<Optional<List<User>>> {
        val users = userService.findUserByValue(value)
        return ResponseEntity.ok(users)
    }

    @GetMapping("/page/{page}")
    fun getByPage(@PathVariable page: Int): ResponseEntity<Page<User>> {
        val user = userService.getUserByPage(page)
        return ResponseEntity.ok(user)
    }


    @GetMapping("/role/{roleId}")
    fun findByRoleId(@PathVariable roleId: Int): ResponseEntity<Optional<List<User>>>{
        val users = userService.getUserByRoleId(roleId)
        return ResponseEntity.ok(users)
    }
}