package archcomps.traning.coursUdemy

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.databinding.DataBindingUtil
import archcomps.traning.R
import archcomps.traning.databinding.ActivityMessageScreenBinding
import kotlinx.android.synthetic.main.activity_message_screen.*

class MessageScreen : AppCompatActivity() {


    lateinit var mainBinding : ActivityMessageScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_screen)

        // Et aussi pour la liaison de données dans le main
       // mainBinding=DataBindingUtil.setContentView(this, R.layout.activity_message_screen)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        // Pour la Toolbar
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
