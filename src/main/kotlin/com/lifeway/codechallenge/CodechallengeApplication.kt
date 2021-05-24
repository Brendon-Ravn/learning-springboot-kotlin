package com.lifeway.codechallenge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.stereotype.Service
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository


@SpringBootApplication
class CodechallengeApplication


fun main(args: Array<String>) {
	runApplication<CodechallengeApplication>(*args)
}


@RestController
class MessageResource(val service: MessageService) {


	@GetMapping
	fun index(): List<Message> = service.findMessages()

}

@Service
class MessageService(val db: MessageRepository){

	fun findMessages(): List<Message> {
		TODO()
	}

	fun post(message: Message) {

	}

}

interface MessageRepository: CrudRepository<Message, String>{

	@Query("select * from messages")
	fun findMessages(): List<Message>
}

@Table("MESSAGES")
data class Message(@Id val id: String?, val text: String)


