package favoris

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkersA (context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {

        // Paramètre et résultats
        inputData.getLong("SleepDuration",0)


        Log.i("WorkersA", "Starting hard work")
        Thread.sleep(200)
        Log.i("WorkersA", "work finished")
        return Result.success()
    }
}

class WorkersB(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {

        Log.i("WorkersB", "Starting hard work")
        Thread.sleep(200)
        Log.i("WorkersB", "work finished")
        return Result.success()
    }
}

class WorkersC(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {

        Log.i("WorkersC", "Starting hard work")
        Thread.sleep(200)
        Log.i("WorkersC", "work finished")
        return Result.success()
    }
}