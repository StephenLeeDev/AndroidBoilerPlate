package com.stephen.androidbolierplate.domain.usecases.user

import com.stephen.androidbolierplate.domain.repository.user.UserRepository

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

class GetUserInfoUseCase(private val userRepository: UserRepository) {
    suspend fun execute() = userRepository.getUserInfo()
}