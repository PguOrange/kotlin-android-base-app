package com.pascalguizard.androibaseapp.domain.main

import com.pascalguizard.androibaseapp.domain.repository.Repository

class GetErrorExample(private val repository: Repository) {

    suspend fun execute(): String {
        return repository.getErrorExample()
    }
}