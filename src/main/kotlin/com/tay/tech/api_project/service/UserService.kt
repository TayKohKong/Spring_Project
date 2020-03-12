package com.tay.tech.api_project.service

import com.tay.tech.api_project.api.exception.IDNotFoundException
import com.tay.tech.api_project.api.request.CreateUserDTO
import com.tay.tech.api_project.api.request.UpdateUserDTO
import com.tay.tech.api_project.api.request.UserDTO
import com.tay.tech.api_project.domain.model.Role
import com.tay.tech.api_project.domain.model.User
import com.tay.tech.api_project.repository.RoleRepository
import com.tay.tech.api_project.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.lang.RuntimeException
import kotlin.collections.ArrayList


@Component
class UserService(
        @Autowired var userRepository: UserRepository,
        @Autowired var roleRepository: RoleRepository
) {

    fun getAllUser(): ResponseEntity<List<UserDTO>> {
        val users = userRepository.findAll()
        val listUserDTO = ArrayList<UserDTO>()
        users.forEach {
            listUserDTO.add(it.toDTO())
        }
        return ResponseEntity.ok(listUserDTO)
    }

    fun getUserById(id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(userRepository.findById(id).get().toDTO())
    }

    fun createUser(userDTO: CreateUserDTO): ResponseEntity<Any>{
        var role = roleRepository.findById(userDTO.role).orElseThrow{
            throw IDNotFoundException("roleID")
        }
        val user = User.fromDTO(userDTO, role)
        return ResponseEntity.ok(userRepository.save(user).toDTO())
    }

    fun deleteUserById(id: Long): ResponseEntity<String>{
        try {
            userRepository.deleteById(id)
            return ResponseEntity.ok("Deleted User Succeed")
        } catch (e: RuntimeException){
            throw IDNotFoundException("userId")
        }
    }

    fun updateUser(updateUserDTO: UpdateUserDTO, id: Long):ResponseEntity<Any>{
        val user = userRepository.findById(id).orElseThrow{
            throw  IDNotFoundException("userID")
        }
        val role = if (updateUserDTO.role == null)
                        roleRepository.findById(user.role.id).orElseThrow{
                            throw IDNotFoundException("roleID")
                        }
                    else roleRepository.findById(updateUserDTO.role!!).orElseThrow {
                            throw IDNotFoundException("roleID")
                        }
        val updatedUser = User.fromDTO(updateUserDTO,role ,user)
        return ResponseEntity.ok(userRepository.save(updatedUser).toDTO())
    }


    fun findUserByValue(value: String): ResponseEntity<List<UserDTO>> {
        val users = userRepository.findByValue(value)
        val listUserDTO = ArrayList<UserDTO>()
        users.let {
            it.get().forEach{
                listUserDTO.add(it.toDTO())
            }
        }
        return ResponseEntity.ok(listUserDTO)
    }

    fun getUserByPage(page: Int): ResponseEntity<Page<UserDTO>> {
        return ResponseEntity.ok(userRepository.findAll(PageRequest.of(page,5)).map {
            it.toDTO()
        })
    }

    fun getUserByRoleId(id: Long): ResponseEntity<List<UserDTO>>{
        val users = userRepository.findUserByRoleId(id)
        val listUserDTO = ArrayList<UserDTO>()
        users.let {
            it.get().forEach {
                listUserDTO.add(it.toDTO())
            }
        }
        return ResponseEntity.ok(listUserDTO)
    }

}