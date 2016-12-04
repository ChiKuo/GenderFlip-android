package tw.chikuo.genderflip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import tw.chikuo.genderflip.Node.CloudDataCenter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MainMissionAdapter mainMissionAdapter;
    private RecyclerView rv;
    Timer mServerTimer = null;
    TimerTask mServerTimerTask = null;
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        iniTimer();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Init the RecyclerView and Adapter
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        mainMissionAdapter = new MainMissionAdapter(this);
        rv.setAdapter(mainMissionAdapter);

        loadData();

    }

    void iniTimer()
    {
        mServerTimer = new Timer();
        mServerTimerTask = new TimerTask() {
            @Override
            public void run() {
                //Mission mMission2 = new Mission("missionName11");
                //Log.d("CloudDataCenter","count="+mMission2.maleCount.getValue());
                if(CloudDataCenter.getInstance(MainActivity.this).getMissionList().
                        getMissionList(MainActivity.this).size()>0)
                {
                    //missionList.clear();
                    missionList.clear();

                    for (int i=0;i<CloudDataCenter.getInstance(MainActivity.this).getMissionList().
                            getMissionList(MainActivity.this).size();i++)
                    {
                       tw.chikuo.genderflip.Node.Node.Mission m = CloudDataCenter.getInstance(MainActivity.this).getMissionList().
                                getMissionList(MainActivity.this).get(i);

                        Mission m_source = new Mission();

                        if(m.femaleCount!=null && !m.femaleCount.getValue().equals("")) {
                            m_source.setFemaleCount(Integer.valueOf(m.femaleCount.getValue()));
                        }
                        if(m.maleCount!=null && !m.maleCount.getValue().equals("")) {
                            m_source.setMaleCount(Integer.valueOf(m.maleCount.getValue()));
                        }
                        if(m.missionName!=null && !m.missionName.getValue().equals("")) {
                            m_source.setMissionName(m.missionName.getValue());
                        }

                        Log.d(TAG,"getMissionName="+m_source.getMissionName());
                        Log.d(TAG,"getFemaleCount="+m_source.getFemaleCount());
                        Log.d(TAG,"getMaleCount="+m_source.getMaleCount());
                        missionList.add(m_source);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mainMissionAdapter.notifyDataSetChanged();
                            }
                        });

                    }

                }
            }
        };
        mServerTimer.schedule(mServerTimerTask, 0, 1000);
    }

    static List<Mission> missionList = new ArrayList<>();
    private void loadData() {
        // TODO
        for (int i = 1; i < 11 ;i++){

            String ID = "任務" + i;
            tw.chikuo.genderflip.Node.Node.Mission mMission = new tw.chikuo.genderflip.Node.Node.Mission(null, ID);
            CloudDataCenter.getInstance(MainActivity.this).getMissionList().List.Append(ID, "99");

            mMission.missionName.setValue("任務"+i);
            mMission.femaleCount.setValue(String.valueOf((int)(Math.random() * 100)));
            mMission.maleCount.setValue(String.valueOf((int)(Math.random() * 100)));

//            Mission mission = new Mission("任務" + i, (int)(Math.random() * 100), (int)(Math.random() * 100));
//            missionList.add(mission);
        }
        mainMissionAdapter.setMissionList(missionList);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
