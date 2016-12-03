package tw.chikuo.genderflip.Node.Node;

import android.content.Context;

import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

import tw.chikuo.genderflip.Node.CloudData.CloudList_KeyValue;
import tw.chikuo.genderflip.Node.CloudDataCenter;

/**
 * Created by bjorgaas on 16/6/14.
 */
public class MissionList {

    private final static String SwarmMatrix = "Swarm_Matrix";
    private final static String Matrix_List = "M_List";

    String root = "";

    public MissionList(String rt)
    {
        //getSwarmNode()
        if(rt == null)
        {
            root = SwarmMatrix;
        }
        else
        {
            root = rt + "/" + SwarmMatrix;
        }

        List = new CloudList_KeyValue(SwarmMatrix + "/" + Matrix_List);
    }

    public java.util.List<Mission> getMissionList(Context c)
    {
        java.util.List<Mission> mMissonList = new ArrayList<>();

        for(BasicNameValuePair NVP : CloudDataCenter.getInstance(c).getMissionList().List.getList())
        {
            mMissonList.add( CloudDataCenter.getInstance(c).getMission(NVP.getName()));
        }

        return mMissonList;
    }
    public CloudList_KeyValue List = null;
    //private List<Mission> mMissonList = null;
}
