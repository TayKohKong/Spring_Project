package com.tay.tech.api_project.api.controller

import com.tay.tech.api_project.domain.model.Role
import com.tay.tech.api_project.repository.RoleRepository
import com.tay.tech.api_project.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping(value = ["/roles"])
class RoleController(
        @Autowired
        var roleService: RoleService
) {

        @PostMapping
        fun createRole(@Valid @RequestBody role: Role): ResponseEntity<Role>{
                return roleService.createRole(role)
        }
}