package tw.chikuo.genderflip.Node.CloudData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bjorgaas on 16/6/14.
 */
public class CloudList_KeyValue {

    private List<BasicNameValuePair> mKvP_DataList = new LinkedList<BasicNameValuePair>();
    private ValueEventListener mValueListener = null;

    private String mNodePath;
    public CloudList_KeyValue(final String NodePath)
    {
        mNodePath = NodePath;
        mValueListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<BasicNameValuePair> mKvP_List = new ArrayList<BasicNameValuePair>();

                if (snapshot.getChildrenCount() > 0) {
                    for (DataSnapshot DS : snapshot.getChildren()) {
                        mKvP_List.add(new BasicNameValuePair(DS.getKey(), DS.getValue().toString()));
                    }
                }

                mKvP_DataList = mKvP_List;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        FirebaseDatabase.getInstance().getReference(NodePath).addValueEventListener(mValueListener);
    }

    public void Append(String Name, String Value)
    {
        if(mKvP_DataList.contains(Name))
        {
            mKvP_DataList.remove(Name);
        }

        mKvP_DataList.add(new BasicNameValuePair(Name,Value));

        FirebaseDatabase.getInstance().getReference(mNodePath+"/" + Name).setValue(Value);
    }

    public void Remove(String Name)
    {
        if(mKvP_DataList.contains(Name))
        {
            mKvP_DataList.remove(Name);
        }
        FirebaseDatabase.getInstance().getReference(mNodePath+"/" + Name).setValue("0");
    }

    public List<BasicNameValuePair> getList()
    {
        return mKvP_DataList;
    }
}
