package com.app.cache.repository

import com.app.cache.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository:JpaRepository<User,Long> {
     fun findUserById(p0: Long):User


}