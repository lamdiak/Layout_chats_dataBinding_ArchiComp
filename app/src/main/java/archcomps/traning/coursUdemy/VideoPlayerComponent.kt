package archcomps.traning.coursUdemy

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class VideoPlayerComponent(private val lifecycle: Lifecycle) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun StartPlayer(){
        Log.i("VideoPlayer", "Starting playback")
        if(lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED)){
            Log.i("VideoPlayer", "Initialize video Buffering")
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun StopPlayer(){
        Log.i("VideoPlayer", "Stopping playback")
    }
}