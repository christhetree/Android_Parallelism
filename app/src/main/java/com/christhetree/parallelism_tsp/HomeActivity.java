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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
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

//                    ParallelCallable herpaderp = new ParallelCallable((long) 20036756);
//                    long derp = -2;
//                    try {
//                        derp = (Long) herpaderp.call();
//                        derp = ParallelTaskLibrary.GreatestFactor2(1234);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    editText1.setText(Long.toString(derp));
//                    editText1.setText(Long.toString(ParallelTaskLibrary.GreatestFactor2((long) 235235)));


//                    FutureTask test = new FutureTask(new ParallelCallable((long) 40000000, (long) 2, (long) 40000000));
//                    FutureTask test = new FutureTask(new ParallelCallable((long) 40000000, (long) 2, (long) 20000000));
//                    FutureTask test = new FutureTask(new ParallelCallable((long) 40000000, (long) 2, (long) 13000000));
                    ParallelCallable lippidy = new ParallelCallable((long) 80000000, (long) 2, (long) 80000000);
//                    FutureTask test = new FutureTask(lippidy);

//                    FutureTask test2 = new FutureTask(new ParallelCallable((long) 40000000, (long) 1, (long) 1));
//                    FutureTask test2 = new FutureTask(new ParallelCallable((long) 40000000, (long) 20000000, (long) 40000000));
//                    FutureTask test2 = new FutureTask(new ParallelCallable((long) 40000000, (long) 13000000, (long) 26000000));
//                    FutureTask test2 = new FutureTask(new ParallelCallable((long) 40000000, (long) 10000000, (long) 20000000));
//
//                    FutureTask test3 = new FutureTask(new ParallelCallable((long) 40000000, (long) 1, (long) 1));
//                    FutureTask test3 = new FutureTask(new ParallelCallable((long) 40000000, (long) 26000000, (long) 40000000));
//                    FutureTask test3 = new FutureTask(new ParallelCallable((long) 40000000, (long) 20000000, (long) 30000000));
//
//                    FutureTask test4 = new FutureTask(new ParallelCallable((long) 40000000, (long) 1, (long) 1));
//                    FutureTask test4 = new FutureTask(new ParallelCallable((long) 40000000, (long) 30000000, (long) 40000000));

//                    ThreadPoolManager.sInstance.mTPE.execute(test);

//                    ThreadPoolManager.execute(test);
//                    ThreadPoolManager.submit(lippidy);

                    ParallelRunnable yeah = new ParallelRunnable();
                    ParallelCallable2 yeah2 = new ParallelCallable2();
                    Future testfuture = ThreadPoolManager.submit(yeah2);
//                    ThreadPoolManager.execute(yeah);


                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(!testfuture.isDone()) {
                        Log.d("This is a tag", "not done!");

                    }

                    yeah2.cancel = true;

                    while(true) {
                        if (testfuture.isDone()) {
                            Log.d("This is a tag", "done!");
                            break;
                        }
                    }

//                    long intermediate = lippidy.getStuff();
//                    editText1.setText(Long.toString(lippidy.getStuff()));

//                    test.cancel(true);
//                    ThreadPoolManager.execute(test2);
//                    ThreadPoolManager.execute(test3);
//                    ThreadPoolManager.execute(test4);

                    long heyhoe = -3;
//                    try {
//                        heyhoe = (Long) lippidy.get();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }

                    long heyhoe2 = -4;
//                    try {
//                        heyhoe2 = (Long) test2.get();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (ExecutionException e) {
//                        e.printStackTrace();
//                    }
                    long heyhoe3 = -5;
//                    try {
//                        heyhoe3 = (Long) test3.get();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (ExecutionException e) {
//                        e.printStackTrace();
//                    }
                    long heyhoe4 = -6;
//                    try {
//                        heyhoe4 = (Long) test4.get();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (ExecutionException e) {
//                        e.printStackTrace();
//                    }

                    long result = Math.max(heyhoe4, (Math.max(heyhoe3, (Math.max(heyhoe, heyhoe2)))));
//                    editText1.setText(Long.toString(intermediate));




//                    test.run();
//                    long merp = -1;
//                    try {
//                        merp = (Long) test.get();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (ExecutionException e) {
//                        e.printStackTrace();
//                    }
//                    editText1.setText(Long.toString(merp));

//                    int numberOfProcessors = Runtime.getRuntime().availableProcessors();
//                    int numberOfProcessors = getNumCores();
//                    int numberOfProcessors = 8;
//                    editText1.setText(Integer.toString(numberOfProcessors));


//                    test.CallCommand(0, new GreatestFactor(), (long) 20036756, editText1);
//                    new GreatestFactorAsyncTask(new GreatestFactor(), editText1).execute((long) 20036756);
//                    Context context = getActivity();
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

//                    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//                    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//                    boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
//                    boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
//                    boolean isData = activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;
//                    boolean isBluetooth = activeNetwork.getType() == ConnectivityManager.TYPE_BLUETOOTH;
//                    editText1.setText(Boolean.toString(isConnected) + Boolean.toString(isWiFi) + Boolean.toString(isData) + Boolean.toString(isBluetooth));



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
