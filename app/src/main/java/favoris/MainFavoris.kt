package favoris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.*
import archcomps.traning.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


inline fun <reified T :  Worker> buildWork() : OneTimeWorkRequest {
    return OneTimeWorkRequestBuilder<T>()
                .build()
}

fun buildWorkerPrime(low: Int, high: Int) : OneTimeWorkRequest {

    // Les contraintes pour PrimeWorker
    val constraints  = Constraints.Builder()
        .setRequiresCharging(true)
        .build()
    return OneTimeWorkRequestBuilder<PrimeWorker>()
        .setInputData(workDataOf(LOW_BOUND to low,
                                HIGH_BOUND to high))
        .setConstraints(constraints)
        .build()
}

class MainFavoris : AppCompatActivity() {

    companion object {
        val primeNumbers = mutableListOf<Int>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_favoris)

        // Configuration
        val retrofit = Retrofit.Builder()
            .baseUrl("http://httpbin.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Génération de l'interface
        val service = retrofit.create(HtppBinServiceString::class.java)

        val call: Call<GetData> = service.getUserAgent()

        // Appel de la méthode en mode Asynchrone
        call.enqueue(object : Callback<GetData>{

            override fun onResponse(call: Call<GetData>, response: Response<GetData>?) {
                val getData = response?.body()

                Log.i("MainActivity", "Received url ${getData?.ip}")
            }

            override fun onFailure(call: Call<GetData>, t: Throwable) {
                Log.i("MainActivity","Error $t")
            }


        })



//        val workManager: WorkManager = WorkManager.getInstance(this)
//        workManager.cancelAllWork()

//        workManager
//            .beginWith(
//                buildWorkerPrime(1,100))
//            .then(.............)
//            .enqueue()




//         Exécution d'une tâche
//        val work = OneTimeWorkRequestBuilder<>()
//            .build()

//        // On met en place une contrainte
//        val constraints = Constraints.Builder()
//                        .setRequiresCharging(true)
//                        .setRequiredNetworkType(NetworkType.CONNECTED)
//                        .build()
//
//        val work = PeriodicWorkRequestBuilder<Workers>(30, TimeUnit.MINUTES)
//                                    .setConstraints(constraints)
//                                    .build()
//        workManager.enqueue(work)
//        workManager.getWorkInfoByIdLiveData(work.id).observe(this, Observer { workStatus ->
//            Log.i("MainActivty", "workStatus=$workStatus")
//        })

   /*     val workManager: WorkManager = WorkManager.getInstance(this)
        workManager.cancelAllWork()

        val workerA = buildWork<WorkersA>()
        val workerB = buildWork<WorkersB>()
        val workerC = buildWork<WorkersC>()
*/
//        En séquence
//        workManager.beginWith(workerA)
//            .then(workerB)
//            .enqueue()

        // En parallèle
//        workManager.beginWith(workerA,workerB).enqueue()
         // En chaîne




}


}


