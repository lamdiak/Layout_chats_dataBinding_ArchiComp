package favoris

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.*

const val LOW_BOUND = "low"
const val HIGH_BOUND = "high"


class PrimeWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {

        // Reçoit deux paramètre depuis Input Data Parsing des paramètres d'entrées
        val low =  inputData.getInt(LOW_BOUND, 1)
       // Log.i("LOW_BOUND", "low_bound = $low")

        val high = inputData.getInt(HIGH_BOUND, 1)
        Log.i("PrimeWorker", "Starting Prime Number search in  [$low, $high]")

        // Effectue le calcul
        val primeNumbers = calculatePrimeNumbers(low,high)

        val sleepDuration = 1000 + Random().nextInt(3000)
        Thread.sleep(sleepDuration.toLong())

        Log.i("PrimeWorker", "Prime numbers, size =${primeNumbers.size}, value = ${primeNumbers}")
        MainFavoris.primeNumbers.addAll(primeNumbers)
         return Result.success()
    }
}