package tw.chikuo.genderflip.Node;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

import java.util.HashMap;
import java.util.LinkedHashMap;

import tw.chikuo.genderflip.Node.Node.MachineNode;
import tw.chikuo.genderflip.Node.Node.Mission;
import tw.chikuo.genderflip.Node.Node.MissionList;
import tw.chikuo.genderflip.Node.Node.SwarmNode;
import tw.chikuo.genderflip.Node.Node.UserInfo;

/**
 * Created by bjorgaas on 16/6/14.
 */
public class CloudDataCenter {

    static private CloudDataCenter mCloudDataCenter = null;
    static public SwarmNode mSwarmNode = null;
    static public UserInfo mUserInfo = null;
    //static public UserInfo mGlobal_UserInfo = null;
    static public MissionList mMissionList = null;
    static public MachineNode mMachineNode = null;
    static public Mission mMission = null;

    static Context mContext;
    String TAG = "CloudDataCenter";

    static public CloudDataCenter getInstance(Context c)
    {
        if(mCloudDataCenter == null)
        {
            mContext = c;
            //
            mSwarmNode = new SwarmNode(null, getMachineAndroidID(mContext));
            mMission = new Mission(null, getMachineAndroidID(mContext));
            //mGlobal_UserInfo = new UserInfo(null);
            mMissionList = new MissionList(null);
            mUserInfo = new UserInfo(mSwarmNode.root);
            mMachineNode = new MachineNode(mSwarmNode.root);
            //
            mCloudDataCenter = new CloudDataCenter();

        }

        return mCloudDataCenter;
    }

    public void ini()
    {
        Log.d(TAG, "ini cloud data center");
    }

    public SwarmNode getSwarmNode()
    {
        return mSwarmNode;
    }
    public UserInfo getUserNode()
    {
        return mUserInfo;
    }
    public MissionList getMissionList()
    {
        return mMissionList;
    }
    public MachineNode getMachineNode()
    {
        return mMachineNode;
    }

    public Mission getMission()
    {
        return mMission;
    }

    public Mission getMission(String SwarmName)
    {
        if(!mMissionCacheList.containsKey("missionName"+SwarmName))
        {
            mMissionCacheList.put("missionName"+SwarmName, new Mission("missionName"+SwarmName));
        }

        return mMissionCacheList.get("missionName"+SwarmName);
    }

//    public Mission getMission(String SwarmName)
//    {
//        Mission x = new Mission("missionName11");
//        Log.d(TAG,"femaleCount="+x.femaleCount.getValue());
//        Log.d(TAG,"maleCount="+x.maleCount.getValue());
//        Log.d(TAG,"missionName="+x.missionName.getValue());
//        return x;
//    }

    static public String getMachineAndroidID(Context c) {
        //String buildSerial = android.os.Build.SERIAL;
        return Settings.Secure.getString(c.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * Other SwarmData()
     */
    static HashMap<String, Mission> mMissionCacheList = new LinkedHashMap<>();
    static HashMap<String, SwarmNode> mSwarmCacheList = new LinkedHashMap<>();
    static HashMap<String, UserInfo> mUserNodeCacheList = new LinkedHashMap<>();

    public SwarmNode getSwarmNode(String SwarmName)
    {
        if(!mSwarmCacheList.containsKey(SwarmName))
        {
            mSwarmCacheList.put(SwarmName, new SwarmNode(SwarmName));
        }

        return mSwarmCacheList.get(SwarmName);
    }

    public UserInfo getGatewayNode(String root)
    {
        if(!mUserNodeCacheList.containsKey(root))
        {
            mUserNodeCacheList.put(root, new UserInfo(root));
        }

        return mUserNodeCacheList.get(root);
    }
}
