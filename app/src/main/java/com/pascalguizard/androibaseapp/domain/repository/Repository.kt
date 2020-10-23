package com.pascalguizard.androibaseapp.domain.repository

/**
 * Created by lmiyagi on 04/04/18.
 */
interface Repository {

    @Throws(Throwable::class)
    suspend fun getErrorExample(): String

    @Throws(Throwable::class)
    suspend fun getMessage(): String
}