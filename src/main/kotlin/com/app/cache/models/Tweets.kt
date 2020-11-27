package com.app.cache.models

import com.fasterxml.jackson.annotation.JsonBackReference
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "tweets_table")
data class Tweets(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id:Long=0,

        @Column(name = "tweet",nullable = false)
        var tweet:String,

        @Temporal(TemporalType.TIMESTAMP)
        @CreatedDate
        @Column(name = "created_at", nullable = false)
        var createdDate: LocalDateTime?=null,

        @Temporal(TemporalType.TIMESTAMP)
        @LastModifiedDate
        @Column(name="updated_at", nullable = false)
        var lastModifiedDate: LocalDateTime?=null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        @JsonBackReference
        var user: User?=null
)
{
        private constructor(tweets: Tweets):this(tweet = tweets.tweet){
                id=tweets.id
                tweet=tweets.tweet
                createdDate=tweets.createdDate
                lastModifiedDate=tweets.lastModifiedDate
                user=tweets.user
        }
}