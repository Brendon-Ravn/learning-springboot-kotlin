package com.lifeway.codechallenge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@SpringBootApplication
class CodechallengeApplication


fun main(args: Array<String>) {
	runApplication<CodechallengeApplication>(*args)
}


@RestController
class MessageResource {




	@GetMapping

	fun wordCount(Message: String): Int {
		val strArray = Message.split(" ".toRegex()).toTypedArray()
		var count = 0

		for (s in strArray) {
			if (s != "") {
				count++
			}
		}
		return count
	}

	fun index(): List<Any> = listOf(
			Message("1", "The dog ran."),
			Message("2", "How many words are in me?"),
			Message("3", "My wife and I will celebrate ten years this year!"),
	)

}

data class Message(val id: String?, val text: String)