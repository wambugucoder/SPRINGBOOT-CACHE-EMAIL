package com.app.cache.models

import com.fasterxml.jackson.annotation.JsonBackReference
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "tweets_table")
 class Tweets:Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0

        @Column(name = "tweet", nullable = false)
         var tweet: String


        @CreatedDate
        @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
        var createdDate: LocalDateTime? = null


        @LastModifiedDate
        @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP")
        var lastModifiedDate: LocalDateTime? = null

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        @JsonBackReference
        var user: User? = null

        companion object{
                private const val serialVersionUID = 7156526077883281623L
        }

        constructor(tweet: Tweets) {
                this.id = tweet.id
                this.tweet = tweet.tweet
                this.createdDate = tweet.createdDate
                this.lastModifiedDate = tweet.lastModifiedDate
        }
        constructor(tweet:String){
                this.tweet=tweet
        }

}