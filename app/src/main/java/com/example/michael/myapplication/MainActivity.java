package com.example.michael.myapplication;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    LinearLayout ln;
    Sensor sn;
    TextView tx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx = (TextView)findViewById(R.id.text);
        ln = (LinearLayout)findViewById(R.id.liner);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sn = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this, sn, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        String texto = String.valueOf(sensorEvent.values[0]);
        tx.setText(texto);

        float valor = Float.parseFloat(texto);

        if(valor == 0){
            ln.setBackgroundColor(Color.GREEN);
        } else{
            ln.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
