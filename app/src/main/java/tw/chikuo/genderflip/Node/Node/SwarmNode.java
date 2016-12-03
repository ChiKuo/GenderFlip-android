package tw.chikuo.genderflip.Node.Node;

import android.util.Log;

import tw.chikuo.genderflip.Node.CloudData.CloudString;

/**
 * Created by bjorgaas on 16/6/14.
 */
public class SwarmNode
{
    private final static String Swarm = "Swarm_";
    private final static String Swarm_Version = "Swarm_Version";
    private final static String Swarm_Time = "Swarm_Time";


    private String TAG = "SwarmNode";

    public String root ="";

    public SwarmNode(String rt, String ID)
    {
        if(rt == null)
        {
            root = Swarm + ID;
            Log.d(TAG,"root = "+root);
        }
        else
        {
            root = rt + "/" + Swarm + ID;
        }

        ini();
    }

    public SwarmNode(String absRoot)
    {
        //return Swarm + getMachineAndroidID(mContext);
        root = absRoot;
        ini();
    }

    private void ini()
    {
        Version = new CloudString(root + "/" + Swarm_Version);
        Time = new CloudString(root + "/" + Swarm_Time);
    }

    public CloudString Version = null;

    public CloudString Time = null;
}
