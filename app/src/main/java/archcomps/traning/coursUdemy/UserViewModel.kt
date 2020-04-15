package archcomps.traning.coursUdemy

import android.util.Log
import androidx.lifecycle.ViewModel

private val TAG = "UserViewModel"

class UserViewModel : ViewModel() {

    init {
        Log.i(TAG, "init()")
    }

    override fun onCleared() {
        Log.i(TAG, "onCleared()")
        super.onCleared()
    }
}