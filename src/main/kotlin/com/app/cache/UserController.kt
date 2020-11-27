package com.app.cache

import com.app.cache.models.User
import com.app.cache.request.NewUser
import com.app.cache.response.UserResponse
import com.app.cache.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
class UserController {

    @Autowired
    lateinit var userService: UserService
    val logger: Logger = LoggerFactory.getLogger(UserController::class.java)
    @PostMapping("/create",consumes = [MediaType.APPLICATION_JSON_VALUE],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody @Valid body:NewUser,finalR: BindingResult): ResponseEntity<UserResponse> {
        if (finalR.hasErrors()){
            logger.error("Your Request Body Has Errors")
            return ResponseEntity.badRequest().body(UserResponse(HttpStatus.BAD_REQUEST,"Invalid Credentials"))

        }
        return userService.createUser(body)

    }
    @GetMapping("/all",consumes = [MediaType.APPLICATION_JSON_VALUE],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll(): MutableList<User> {
        return userService.getAllUsers()
    }
    @GetMapping("/user/{id}",consumes = [MediaType.APPLICATION_JSON_VALUE],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getById(@PathVariable id:Long): Optional<User> {
        return userService.getUser(id)

    }
    @PutMapping("/update/user/{id}",consumes = [MediaType.APPLICATION_JSON_VALUE],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody @Valid body:NewUser, @PathVariable id: Long,finalR: BindingResult): ResponseEntity<UserResponse> {
        if(finalR.hasErrors()){
            logger.error("Your Update Body Has Errors")
            return ResponseEntity.badRequest().body(UserResponse(HttpStatus.BAD_REQUEST,"Invalid Credentials"))

        }
        return userService.updateUserById(id,body)
    }
    @DeleteMapping("/delete/{id}",consumes = [MediaType.APPLICATION_JSON_VALUE],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable id: Long): ResponseEntity<UserResponse> {
        return userService.deleteUserById(id)
    }
}