package archcomps.traning.coursUdemy

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService
import androidx.lifecycle.LiveData

class ConnectivityLiveData(private val context : Context) : LiveData<Boolean>() {

//    private val myBroadcastReceiver = object : BroadcastReceiver() {
//        @RequiresApi(Build.VERSION_CODES.M)
//        override fun onReceive(context: Context, intent: Intent) {
//            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
//                    as ConnectivityManager
//            val networkInfo = connectivityManager.activeNetworkInfo
//            value = networkInfo != null && networkInfo.isConnected
//        }
//    }
//
//    override fun onActive() {
//       val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
//        context.registerReceiver(myBroadcastReceiver, filter)
//
//    }
//
//    override fun onInactive() {
//        context.unregisterReceiver(myBroadcastReceiver)
//    }

}




