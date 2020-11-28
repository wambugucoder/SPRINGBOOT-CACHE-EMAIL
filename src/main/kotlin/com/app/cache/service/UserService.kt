package com.app.cache.service

import com.app.cache.models.User
import com.app.cache.repository.UserRepository
import com.app.cache.request.NewUser
import com.app.cache.response.UserResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService {
    @Autowired
    lateinit var userRepository: UserRepository
    val logger: Logger =LoggerFactory.getLogger(UserService::class.java)

    fun createUser(body:NewUser): ResponseEntity<UserResponse> {
     val readyUser =User(username = body.username,email = body.email,password = body.password)
        userRepository.save(readyUser)
        logger.info("User with Email-> ${body.email} <- has been Added SuccessFully")
        return ResponseEntity.ok(UserResponse(httpStatus = HttpStatus.OK,message = "User and Tweets Has Been Saved"))


    }
     fun  getUser(id:Long):User{
         logger.info("User with id ${id.toString()} has been Retrieved")
         return userRepository.findUserById(id)

     }
    fun getAllUsers(): MutableList<User> {
        return userRepository.findAll()
    }


    fun updateUserById(id: Long,body: NewUser): User {
       val fetchUser= getUser(id)
        fetchUser.email=body.email
        logger.info("User Has been Updated")
        return userRepository.save(fetchUser)
    }
    fun  deleteUserById(id: Long):ResponseEntity<UserResponse>{
        userRepository.deleteById(id)
        logger.info("User Has been Deleted")
        return ResponseEntity.ok(UserResponse(HttpStatus.OK,"User Has been Deleted"))
    }
}