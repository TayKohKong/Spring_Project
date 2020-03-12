package com.vannak.tech.api_project.service

import com.vannak.tech.api_project.domain.model.Role
import com.vannak.tech.api_project.repository.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class RoleService (
        @Autowired
        var roleRepository: RoleRepository
){

    fun createRole(role: Role): ResponseEntity<Role>{
        return ResponseEntity.ok(roleRepository.save(role))
    }
}