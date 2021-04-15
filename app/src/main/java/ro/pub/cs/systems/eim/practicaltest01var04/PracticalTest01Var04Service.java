package ro.pub.cs.systems.eim.practicaltest01var04;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class PracticalTest01Var04Service extends Service {
    public PracticalTest01Var04Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String[] numeGrupa = intent.getStringArrayExtra("numegrupa");
        Intent sendIntent = new Intent();
        sendIntent.setAction("Send nume");
        Log.d("Nume", "Numele este: " + numeGrupa[0]);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendIntent.setAction("Send grupa");
        Log.d("Grupa", "Grupa este: " + numeGrupa[1]);
        return Service.START_STICKY;
    }
}
