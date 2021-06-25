package br.edu.uea.hefesto4.sensorcontagempassos_jucelbia

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private lateinit var detectorstepsSensor: Sensor

    var steps = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        detectorstepsSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, detectorstepsSensor,
                SensorManager.SENSOR_DELAY_NORMAL )
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {// passa a precisão

    }

    override fun onSensorChanged(event: SensorEvent?) {//Exibe os dados
        val x = event?.values!![0]
        val y = event?.values!![1]
        val z = event?.values!![2]
        steps++
        textView.text = steps.toString()

    }
}