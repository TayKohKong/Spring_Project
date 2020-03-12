package com.tay.tech.api_project.repository

import com.tay.tech.api_project.domain.model.Role
import com.tay.tech.api_project.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<Role,Long> {

}