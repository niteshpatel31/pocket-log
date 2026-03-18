package com.lazysloth.pocketlog.ui.screen.authentication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lazysloth.pocketlog.database.Transaction
import com.lazysloth.pocketlog.database.repository.TransactionRepository
import com.lazysloth.pocketlog.database.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.security.MessageDigest

class AuthViewModel(private val userRepository: UserRepository, private val transactionRepository: TransactionRepository ) : ViewModel() {

//    val passwordExists: StateFlow<Boolean> = userRepository.
//        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

    fun hashPassword(password: String): String {
        val bytes = MessageDigest
            .getInstance("SHA-256")
            .digest(password.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

    private val _userEntryUiState = MutableStateFlow(SignupUiState())
    val userEntryUiState: StateFlow<SignupUiState> = _userEntryUiState.asStateFlow()
    fun saveUser(userState : SignupUiState) {
        viewModelScope.launch {
            userRepository.saveUser(userState.toUser())
//            transactionRepository.assignUserId()

        }
    }

    suspend fun verifyPassword(identifier: String, password: String): Boolean {
        if(identifier.contains("@")){
            val savedPassword = userRepository.getUserPasswordByEmail(identifier)
            return savedPassword == password
        }
        else{
            val savedPassword = userRepository.getUserPasswordByUsername(identifier)
            return savedPassword == password
        }
    }


}
//fun SignupUiState.toTransaction(): Transaction = Transaction(
//    userId = id,
//    id = TODO(),
//    amount = TODO(),
//    account = TODO(),
//    category = TODO(),
//    transactionType = TODO(),
//    note = TODO(),
//    description = TODO(),
//    dateTime = TODO(),
//)


data class UserEntryUiState(
    val username: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val password: String = "",
    val emailId: String = "",
)