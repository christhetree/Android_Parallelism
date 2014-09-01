package com.christhetree.parallelism_tsp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);

            final Button button1 = (Button) rootView.findViewById(R.id.button1);
            final EditText editText1 = (EditText) rootView.findViewById(R.id.editText1);

            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    editText1.setText("");
//                    int numberOfProcessors = Runtime.getRuntime().availableProcessors();
//                    int numberOfProcessors = getNumCores();
//                    int numberOfProcessors = 8;
//                    editText1.setText(Integer.toString(numberOfProcessors));


//                    test.CallCommand(0, new GreatestFactor(), (long) 20036756, editText1);
//                    new GreatestFactorAsyncTask(new GreatestFactor(), editText1).execute((long) 20036756);
                    Context context = getActivity();
//                    IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
//                    Intent batteryStatus = context.registerReceiver(null, ifilter);
                    // Are we charging / charged?
//                    int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
//                    boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
//                            status == BatteryManager.BATTERY_STATUS_FULL;
                    // How are we charging?
//                    int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
//                    boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
//                    boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
//                    editText1.setText(Boolean.toString(isCharging) + Boolean.toString(usbCharge) + Boolean.toString(acCharge));

                    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                    boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
                    boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
                    boolean isData = activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;
                    boolean isBluetooth = activeNetwork.getType() == ConnectivityManager.TYPE_BLUETOOTH;
                    editText1.setText(Boolean.toString(isConnected) + Boolean.toString(isWiFi) + Boolean.toString(isData) + Boolean.toString(isBluetooth));



                }
            });
            return rootView;
        }

        private int getNumCores() {
            //Private Class to display only CPU devices in the directory listing
            class CpuFilter implements FileFilter {
                @Override
                public boolean accept(File pathname) {
                    //Check if filename is "cpu", followed by a single digit number
                    if(Pattern.matches("cpu[0-9]+", pathname.getName())) {
                        return true;
                    }
                    return false;
                }
            }

            try {
                //Get directory containing CPU info
                File dir = new File("/sys/devices/system/cpu/");
                //Filter to only list the devices we care about
                File[] files = dir.listFiles(new CpuFilter());
                //Return the number of cores (virtual CPU devices)
                return files.length;
            } catch(Exception e) {
                //Default to return 1 core
                return 1;
            }
        }
    }
}
