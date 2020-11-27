package com.app.cache.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

class NewUser(
        @field:NotEmpty(message = "Username cannot be empty")
        var username:String,

        @field:NotEmpty(message = "Email Cannot be empty")
        @field:Email(message = "Invalide email")
        var email:String,

        @field:NotEmpty(message = "Password cannot be empty")
        var password:String,

) {
    private constructor(newUser: NewUser):this(username = newUser.username,password=newUser.password,email = newUser.email)
}