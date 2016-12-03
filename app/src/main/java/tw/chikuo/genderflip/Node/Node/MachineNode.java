package tw.chikuo.genderflip.Node.Node;

import tw.chikuo.genderflip.Node.CloudData.CloudString;

/**
 * Created by bjorgaas on 16/6/14.
 */
public class MachineNode {

    private final static String Machine_info = "Machine_info";
    private final static String Machine_Wifi_Mac = "Wifi_Mac";
    private final static String Machine_Wifi_IP = "Machine_Wifi_IP";
    private final static String Machine_Account_Name = "Account_Name";
    private final static String Machine_Account_Mail = "Account_Mail";
    /**
     *
     * MachineNode Layer
     *
     **/

    String root = "";

    public MachineNode(String rt)
    {
        //getSwarmNode()
        root = rt + "/" + Machine_info;

        //
        Wifi_Mac = new CloudString(root + "/" + Machine_Wifi_Mac );
        Wifi_IP =  new CloudString(root + "/" + Machine_Wifi_IP );
        Account =  new CloudString(root + "/" + Machine_Account_Name );
        UserMail =  new CloudString(root + "/" + Machine_Account_Mail );
    }

    public CloudString Wifi_Mac = null;

    public CloudString Wifi_IP =  null;

    public CloudString Account =  null;

    public CloudString UserMail =  null;
}
