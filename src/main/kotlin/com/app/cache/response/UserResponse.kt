package com.app.cache.response

import org.springframework.http.HttpStatus

class UserResponse (
        val httpStatus: HttpStatus,
        val message:String

        )
{
    constructor(userResponse: UserResponse):this(httpStatus = userResponse.httpStatus,message = userResponse.message)
}