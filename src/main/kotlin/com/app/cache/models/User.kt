package com.app.cache.models

import com.fasterxml.jackson.annotation.JsonManagedReference
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "user_table")
data  class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id:Long=0,

        @Column(name="username",nullable = false)
        var username:String,

        @Column(name="email",nullable = false)
        var email:String,

        @Column(name="password",nullable = false)
        var password:String,

        @Temporal(TemporalType.TIMESTAMP)
        @CreatedDate
        @Column(name = "created_at", nullable = false)
        var createdDate: LocalDateTime?=null,

        @Temporal(TemporalType.TIMESTAMP)
        @LastModifiedDate
        @Column(name="updated_at", nullable = false)
        var lastModifiedDate: LocalDateTime?=null,

        @OneToMany(cascade = [CascadeType.ALL],fetch = FetchType.EAGER,mappedBy ="user" )
        @JsonManagedReference
        var  tweets: MutableList<Tweets>?=null




)
{
    constructor(user:User):this(username = user.username,password=user.password,email = user.email){
        id=user.id
        email=user.email
        password=user.password
        username=user.username
    }
}