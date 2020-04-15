package archcomps.traning.coursUdemy

import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData

// On crée un liveData personnalisé
class SpeedLiveData (private val car : Car) : LiveData<Int>(),
    Car.SpeedListener {

    override fun onActive() {
        Log.i("SpeedLiveData", "onActive()")
        car.speedListener = this

    }

    override fun onInactive() {
        Log.i("SpeedLiveData", "onInactive()")
        car.speedListener = null
    }

    override fun onSpeedChange(Speed: Int) {
       value = Speed
    }

}

class Car {
    interface SpeedListener {
        fun onSpeedChange(Speed: Int)
    }
    var speedListener : SpeedListener? = null
    fun StartEngine() {
        // On va déclarer un Handler qui va notyfier de tous chnagements
        val handler = Handler()
        handler.postDelayed({notifySpeed(10)},1000)
        handler.postDelayed({notifySpeed(50)},5000)
        handler.postDelayed({notifySpeed(100)},7000)
        handler.postDelayed({notifySpeed(2)},10000)
    }

    private fun notifySpeed(i: Int) {
        Log.i("Car", "New speed=$i")
        speedListener?.onSpeedChange(i)
    }
}