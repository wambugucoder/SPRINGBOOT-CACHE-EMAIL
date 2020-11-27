package com.app.cache.repository

import com.app.cache.models.Tweets
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TweetsRepository:JpaRepository<Tweets,Long> {
}