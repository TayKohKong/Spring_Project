package com.tay.tech.api_project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.util.*

@SpringBootApplication
class ApiProjectApplication

fun main(args: Array<String>) {
	runApplication<ApiProjectApplication>(*args)
}
