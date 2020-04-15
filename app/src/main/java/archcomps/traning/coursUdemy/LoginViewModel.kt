package archcomps.traning.coursUdemy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// Ma sealed class => classe vérouillé
// Avec les différents états possible que peut avoir mon activity
sealed class LoginViewModelState (
        val errorMessage: String = "",
        val loginButtonEnabled : Boolean = false

)

// SOus classes avec deux états possible
object LoginViewModelStateSucces : LoginViewModelState()
class LoginViewModelStateError(errorMessage: String) : LoginViewModelState(errorMessage= errorMessage,
    loginButtonEnabled = true
)

class LoginViewModel : ViewModel() {
    // Varaible unique membre
    private val state = MutableLiveData<LoginViewModelState>()
    fun getState() : LiveData<LoginViewModelState> = state

    fun login(username : String, password: String) = if(username=="Kotlin" && password=="Rocks"){
        state.value = LoginViewModelStateSucces
    }else {
        state.value = LoginViewModelStateError(
            "Erreur identifiant ou mot " +
                    "de passe incorret : ${username} / ${password}"
        )
    }

}