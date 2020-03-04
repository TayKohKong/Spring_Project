package com.vannak.tech.api_project

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

//@Bean
//fun localResolver():LocaleResolver{
//	var localeResolver:SessionLocaleResolver= SessionLocaleResolver()
//	localeResolver.setDefaultLocale(Locale.US)
//	return localeResolver
//}
//
//@Bean
//fun bundleMessageSource(): ResourceBundleMessageSource{
//	var messageSource:ResourceBundleMessageSource= ResourceBundleMessageSource()
//	messageSource.setBasename("messages")
//	return messageSource
//}
