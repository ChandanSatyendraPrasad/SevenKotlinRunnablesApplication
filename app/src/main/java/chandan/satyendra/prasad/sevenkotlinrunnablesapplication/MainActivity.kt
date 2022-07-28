package chandan.satyendra.prasad.sevenkotlinrunnablesapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var number = 0
    var runnable: Runnable = Runnable { }
    var handler: Handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun stop(view: View) {
        val textvalue = findViewById<TextView>(R.id.textView)
        val stopbuttonvalue = findViewById<Button>(R.id.button)
        handler.removeCallbacks(runnable)
        number = 0
        textvalue.setText("Time: 0")
        stopbuttonvalue.isEnabled = true
    }

    fun start(view: View) {
        val textvalue = findViewById<TextView>(R.id.textView)
        val startbuttonvalue = findViewById<Button>(R.id.button)
        number = 0

        runnable = object : Runnable {
            override fun run() {
                number = number + 1
                textvalue.setText("Time: $number")
                handler.postDelayed(this, 1000)
            }
        }
        handler.post(runnable)

        startbuttonvalue.isEnabled = false
    }
}