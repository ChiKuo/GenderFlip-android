package tw.chikuo.genderflip.Node.Node;

import android.util.Log;

import tw.chikuo.genderflip.Node.CloudData.CloudString;

/**
 * Created by bjorgaas on 12/3/2016.
 */
public class Mission {

    public final static String TmissionName = "missionName";
    public final static String TmaleCount = "maleCount";
    public final static String TfemaleCount = "femaleCount";

    private String TAG = "Mission";

    private String root ="";

    public Mission(String rt, String ID)
    {
        if(rt == null)
        {
            root = TmissionName + ID;
            Log.d(TAG,"root = "+root);
        }
        else
        {
            root = rt + "/" + TmissionName + ID;
        }

        ini();
    }

    public Mission(String absRoot)
    {
        //return Swarm + getMachineAndroidID(mContext);
        root = absRoot;
        ini();
    }

    private void ini()
    {
        missionName = new CloudString(root + "/" + TmissionName);
        maleCount = new CloudString(root + "/" + TmaleCount);
        femaleCount = new CloudString(root + "/" + TfemaleCount);
    }

    public CloudString missionName;
    public CloudString maleCount;
    public CloudString femaleCount;
}
