package com.example.broadcasttutorial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        /*if(Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
            Toast.makeText(context, "Boot Completed", Toast.LENGTH_SHORT).show();
        }*/

        //Explicit Broadcast Receiver

        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            //Toast.makeText(context, "Connectivity Changed", Toast.LENGTH_SHORT).show();
            boolean noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,false
            );
            if(noConnectivity){
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
            }
        }
    }
    //for implicit broad cast receiver we have to made changes on manifest file
    /*<receiver android:name=".ExampleBroadcastReceiver">
            <intent-filter>
                <action android:name="android.intent.action.BOOT_COMPLETED"/>
                <action android:name="android.net.conn.CONNECTIVITY_CHANGE"/>
            </intent-filter>
        </receiver>*/
}
