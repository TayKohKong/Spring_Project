package com.vannak.tech.api_project.service

import com.vannak.tech.api_project.domain.model.User
import com.vannak.tech.api_project.repository.RoleRepository
import com.vannak.tech.api_project.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component
import java.util.*


@Component
class UserService(
        @Autowired var userRepository: UserRepository
) {

    fun getAllUser(): List<User>{
        return userRepository.findAll()
    }

    fun getUserById(id: Int): User{
        return userRepository.findById(id).get()
    }

    fun createUser(user: User): User{
        return userRepository.save(user)
    }

    fun deleteUserById(id: Int): String{
        userRepository.deleteById(id)
        return "Delete Succeed"
    }

    fun findUserByValue(value: String): Optional<List<User>>{
        return userRepository.findByValue(value)
    }

    fun getUserByPage(page: Int): Page<User> {
        return userRepository.findAll(PageRequest.of(page,5))
    }

    fun getUserByRoleId(id: Int): Optional<List<User>> {
        return userRepository.findUserByRoleId(id)
    }

}