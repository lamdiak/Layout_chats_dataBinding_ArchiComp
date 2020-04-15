package archcomps.traning.coursUdemy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.*
import archcomps.traning.R
import kotlinx.android.synthetic.main.activity_main.*

// Je crée mon propre lifeCycle à travers une classe qui va lui même gérer ses évènements
class MyRegisrty : LifecycleOwner{
    // une instance de la classe lifeCycleRegistry qui nous permet de changer ces états nous mm
    val lifeCycleRegistry = LifecycleRegistry(this)
    override fun getLifecycle(): Lifecycle = lifeCycleRegistry
}

enum class Connectivity {
    DISCONNECTED,
    CONNECTED
}


class MainActivity : AppCompatActivity() {

//    private lateinit var videoPlayer: VideoPlayer
//    private lateinit var videoPlayerComponent: VideoPlayerComponent
//    private val myRegisrty = MyRegisrty()
//
//    private val counter = MutableLiveData<Int>()
//
//    private lateinit var speedLiveData : SpeedLiveData

//    private var nameIndex : Int = 0
//    private var nameLiveData = MutableLiveData<String>()
//    private lateinit var lengthLiveData : LiveData<Int>
//
//    private lateinit var connectivityLiveData: ConnectivityLiveData
//    private lateinit var connectivityEnumLiveData: LiveData<Connectivity>
    private lateinit var viewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // BDD
        val userDao = App.dataBase.userDao()
        userDao.insertUer(Users(0, "Lamine", 26))
        userDao.insertUer(Users(1, "Doudou", 24))

        userDao.getAllUsers().observe(this, Observer { user ->
            Log.i("MainActivity", "User = $user")
        })

//        button3.setOnClickListener(View.OnClickListener {
//            val username = editText.text.toString()
//            val password = editText2.text.toString()
//            viewModel.login(username, password)
//        })
//
//        viewModel = ViewModelProvider(this)
//            .get(LoginViewModel::class.java)
//
//        viewModel.getState().observe(this, Observer { misAjour(it!!) })

//        videoPlayer = VideoPlayer()
//        videoPlayerComponent = VideoPlayerComponent(lifecycle)
//        lifecycle.addObserver(videoPlayerComponent)

        // Code
        //lifecycle.addObserver(MyLocationListener(lifecycle))

        //LifeCycle nous permet de changer d'état & lifeCycleRegistry nous permet de changer d'état
//        myRegisrty.lifeCycleRegistry.markState(Lifecycle.State.CREATED)
//        myRegisrty.lifecycle.addObserver(VideoPlayerComponent(myRegisrty.lifecycle))

//            counter.value = 0
//            incrementButton.setOnClickListener(View.OnClickListener {
//                counter.value = counter.value!! +1
//            })
        // On crée ici un observer pour observer no data
//         val observer : Observer<Int> = object: Observer<Int> {
//             override fun onChanged(t: Int?) {
//               Log.i("MainActivity","New counter value=$t")
//             }
//         }

            // Fonction simplifiée lamdas
//            val observer : Observer<Int> = Observer { t ->
//                Log.i("MainActivity","New counter value=$t")
//            }
//
//            counter.observe(this, observer)

//            val car = Car()
//            speedLiveData = SpeedLiveData(car)
//            speedLiveData.observe(this, Observer { speed ->
//                Log.w("MaonActivity", "UPDATE UI SPEED =$speed")
//            })
//            car.StartEngine()

//            incrementButton.setOnClickListener {
//                nameLiveData.value = when(nameIndex) {
//                    0 -> "Bob"
//                    1 -> "Bobette"
//                    2 -> "Jaene"
//                    else -> "who ?"
//                }
//                Log.i("MainActivity", "New name value = ${nameLiveData.value}")
//                nameIndex = (nameIndex+1) % 3
//            }
//
//            lengthLiveData = Transformations.map(nameLiveData) {   name ->
//                Log.i("MainActivity", "Transformation string => Int")
//                  name.length
//            }
//
//            lengthLiveData.observe(this, Observer {
//                length -> incrementTextview.text = "New length $length"
//            })
//
//        connectivityLiveData = ConnectivityLiveData(this)
//
//        connectivityEnumLiveData = Transformations.map(connectivityLiveData){
//            connected -> when(connected) {
//                true -> Connectivity.CONNECTED
//                false -> Connectivity.DISCONNECTED
//            }
//        }
//
//        connectivityEnumLiveData.observe(this, Observer { connected ->
//            Log.i("MainActivity", "Network connected = $connected ")
//        })
    }

    private fun misAjour(state: LoginViewModelState) {
        return when (state) {
            LoginViewModelStateSucces -> {
                textView.visibility = View.INVISIBLE
                button3.isEnabled = state.loginButtonEnabled
                Toast.makeText(this, "Logged! Loading next Activity...",Toast.LENGTH_LONG).show()
            }
            is LoginViewModelStateError -> {
                button3.isEnabled = state.loginButtonEnabled
                textView.visibility = View.VISIBLE
                textView.text = state.errorMessage
            }
        }

    }

//    override fun onResume() {
//        super.onResume()
//      //  videoPlayer.StartPlayer()
//        myRegisrty.lifeCycleRegistry.markState(Lifecycle.State.RESUMED)
//    }
//
//    override fun onPause() {
//        super.onPause()
//        videoPlayer.StopPlayer()
//    }
}
