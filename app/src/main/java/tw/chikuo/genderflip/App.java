package tw.chikuo.genderflip;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.firebase.client.Firebase;

import java.util.Timer;
import java.util.TimerTask;

import tw.chikuo.genderflip.Node.CloudDataCenter;

/**
 * Created by bjorgaas on 12/3/2016.
 */
public class App extends Application {
    static String TAG = "App";
    static private Context mAppContext = null;
    static public Context getAppContext()
    {
        return mAppContext;
    }
    Timer mServerTimer = null;
    TimerTask mServerTimerTask = null;

    @Override
    public void onCreate()
    {
        Log.d(TAG, "SwarmNode Create");
        mAppContext = getApplicationContext();

        Firebase_Ini();
        printAccount();

        super.onCreate();
    }

    private void printAccount()
    {
        AccountManager accountManager = AccountManager.get(this);
        Account[] accounts = accountManager.getAccounts();
        for(Account account : accounts){
            Log.d("--Get Account Example--", account.name);
            Log.d("--Get Account Example--", account.type);
        }
    }

    private void Firebase_Ini()
    {
        Firebase.setAndroidContext(this);
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
    }

    @Override
    public void onTerminate()
    {
        super.onTerminate();
    }
}
