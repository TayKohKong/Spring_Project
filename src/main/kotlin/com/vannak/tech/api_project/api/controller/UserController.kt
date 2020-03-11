package com.vannak.tech.api_project.api.controller

import com.vannak.tech.api_project.api.exception.IDNotFoundException
import com.vannak.tech.api_project.api.request.CreateUserDTO
import com.vannak.tech.api_project.api.request.UpdateUserDTO
import com.vannak.tech.api_project.api.request.UserDTO
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
    fun getAllUser(): ResponseEntity<List<UserDTO>>{
        return userService.getAllUser()
    }

    @GetMapping("/{id}")
    fun retrieveUser(@PathVariable id:Long): ResponseEntity<Any> {
        return userService.getUserById(id)
    }

    @PostMapping
    fun createUser(@Valid @RequestBody userDTO: CreateUserDTO): ResponseEntity<Any>{
        return userService.createUser(userDTO)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id:Long): ResponseEntity<String> {
        try {
            return userService.deleteUserById(id)
        } catch (e: RuntimeException){
            throw IDNotFoundException("userId")
        }

    }

    @PutMapping("/update/{id}")
    fun updateUser(@Valid @RequestBody updateUserDTO: UpdateUserDTO,@PathVariable id: Long): ResponseEntity<Any>{
        return userService.updateUser(updateUserDTO,id)
    }

    @GetMapping("/search")
    fun findByValue(@RequestParam value: String): ResponseEntity<List<UserDTO>> {
       return userService.findUserByValue(value)
    }

    @GetMapping("/page/{page}")
    fun getByPage(@PathVariable page: Int): ResponseEntity<Page<UserDTO>> {
        return userService.getUserByPage(page)
    }

    @GetMapping("/role/{roleId}")
    fun findByRoleId(@PathVariable roleId: Long): ResponseEntity<List<UserDTO>>{
        return userService.getUserByRoleId(roleId)
    }
}