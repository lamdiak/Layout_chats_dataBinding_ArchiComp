package archcomps.traning.coursUdemy

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLocationListener(private val lifecycle: Lifecycle) : LifecycleObserver {

    // Deux fonctions
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun Start(){
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)){
            Log.i("Exercie", "Starting")
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun Stop(){
            Log.i("Exercie", "Stopping")
    }
}