package com.stephen.androidbolierplate.domain.usecases.user

import com.stephen.androidbolierplate.domain.repository.user.UserRepository

/**
 * Written by StephenLeeDev on 2022/08/03.
 */

class GetPeopleUseCase(private val userRepository: UserRepository) {
    suspend fun execute(query: String) = userRepository.getPeople(query = query)
}