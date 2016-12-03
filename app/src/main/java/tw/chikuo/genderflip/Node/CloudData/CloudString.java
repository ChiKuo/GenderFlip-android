package tw.chikuo.genderflip.Node.CloudData;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by bjorgaas on 16/6/14.
 */
public class CloudString {

    private String mValue = "";
    private String mNodePath = "";
    private ValueEventListener mValueListener = null;
    String TAG = "CloudString";

    public CloudString(String NodePath)
    {
        mNodePath = NodePath;

        mValueListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                mValue = snapshot.getValue() == null ? "0" : snapshot.getValue().toString();
                Log.d(TAG,"Path ="+mNodePath+", Value change = " + mValue);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        Log.d(TAG, "Node Path = " + mNodePath);
        FirebaseDatabase.getInstance().getReference(mNodePath).addValueEventListener(mValueListener);
    }

    public String getValue()
    {
        return mValue;
    }

    public void setValue(String v)
    {
        mValue = v;
        FirebaseDatabase.getInstance().getReference(mNodePath).setValue(mValue);
    }
}
