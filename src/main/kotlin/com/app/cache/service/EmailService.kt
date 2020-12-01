package com.app.cache.service

import org.apache.logging.log4j.message.SimpleMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService {

    @Autowired
    lateinit var simpleMail:JavaMailSender

    fun sendEmail(email:String){
        var message:SimpleMailMessage=SimpleMailMessage()
        message.setFrom("abc@gmail.com")
        message.setTo(email)
        message.setSubject("Practise")
        message.setText("Seems to be working")

        simpleMail.send(message)
    }
}