package tw.chikuo.genderflip.Node.CloudData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjorgaas on 16/6/14.
 */
public class CloudList_String {

    private List<String> mValue = new ArrayList<>();
    private ValueEventListener mValueListener = null;

    public CloudList_String(String NodePath)
    {
        mValueListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<String> mTempList = new ArrayList<String>();

                if(snapshot.getChildrenCount() > 0) {
                    for (DataSnapshot DS : snapshot.getChildren()) {
                        mTempList.add(DS.getKey());
                    }
                }

                mValue = mTempList;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        FirebaseDatabase.getInstance().getReference(NodePath).addValueEventListener(mValueListener);
    }
}
