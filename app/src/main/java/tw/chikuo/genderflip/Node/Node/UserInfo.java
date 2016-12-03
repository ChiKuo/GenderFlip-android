package tw.chikuo.genderflip.Node.Node;

import tw.chikuo.genderflip.Node.CloudData.CloudList_KeyValue;
import tw.chikuo.genderflip.Node.CloudData.CloudString;

/**
 * Created by bjorgaas on 16/6/14.
 */
public class UserInfo
{
    private final static String User_AppInfo = "PeopleApp";
    private final static String User_ID = "User_ID";
    private final static String User_Password = "User_Password";
    private final static String User_Pointer = "User_Pointer";
    private final static String User_Update_Time = "User_Update_Time";
    private final static String User_Push = "User_Push";
    String root = "";

    public UserInfo(String rt)
    {
        //getSwarmNode()
        root = rt + "/" + User_AppInfo;

        //
        mUser_ID = new CloudString(root + "/" + User_ID);
        mUser_Password = new CloudString(root + "/" + User_Password);
        mUser_Push = new CloudList_KeyValue(root + "/" + User_Push);
        mUser_Pointer = new CloudString(root + "/" + User_Pointer);
        mUser_Update_Time = new CloudString(root + "/" + User_Update_Time);

    }

    public CloudString mUser_ID = null;
    public CloudString mUser_Password = null;
    public CloudString mUser_Pointer = null;
    public CloudList_KeyValue mUser_Push = null;
    public CloudString mUser_Update_Time = null;
}
