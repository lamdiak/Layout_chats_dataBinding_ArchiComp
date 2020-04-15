package favoris

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadPrimesWorker(context: Context, workerParams: WorkerParameters) : Worker(context,
    workerParams
) {
    override fun doWork(): Result {

        Log.i("UploadPrimesWorker","Uploading prime numbers.... size = ${MainFavoris.primeNumbers.size}")
        Thread.sleep(2000)
        Log.i("UploadPrimesWorker", "finished")
        return Result.success()
    }
}