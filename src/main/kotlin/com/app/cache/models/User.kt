package com.app.cache.models

import com.fasterxml.jackson.annotation.JsonManagedReference
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "user_table")
class User :Serializable{
    @Column(name = "username", nullable = false)
    var username: String

    @Column(name = "email", nullable = false)
     var email: String

    @Column(name = "password", nullable = false)
     var password: String


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
     var id: Long = 0


    @CreatedDate
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
      var createdDate: LocalDateTime = LocalDateTime.now()


    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP")
    var lastModifiedDate: LocalDateTime = LocalDateTime.now()

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, mappedBy = "user")
    @JsonManagedReference
    var tweets: MutableList<Tweets>? = null

    companion object{
        private const val serialVersionUID = 7156526077883281623L
    }
    constructor(user:User){
        this.id=user.id
        this.username=user.username
        this.email=user.email
        this.password=user.password
        this.tweets=user.tweets
        this.createdDate=user.createdDate
        this.lastModifiedDate=user.lastModifiedDate
    }
    constructor(username:String,email:String,password:String){
        this.id=id
        this.username=username
        this.email=email
        this.password=password
        this.tweets=tweets
        this.createdDate=createdDate
        this.lastModifiedDate=lastModifiedDate
    }
}

