package com.tay.tech.api_project.api.exception

import java.lang.RuntimeException

class IDNotFoundException(errorField : String) : RuntimeException(errorField) {

}