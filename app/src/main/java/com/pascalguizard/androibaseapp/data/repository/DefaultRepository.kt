package com.pascalguizard.androibaseapp.data.repository

import com.pascalguizard.androibaseapp.data.api.ApiClient
import com.pascalguizard.androibaseapp.domain.repository.Repository

/**
 * Created by lmiyagi on 04/04/18.
 */
class DefaultRepository constructor(private val apiClient: ApiClient) : Repository {

    override suspend fun getErrorExample(): String {
        return apiClient.getErrorExample()
    }

    override suspend fun getMessage(): String {
        return apiClient.getMessage()
    }
}