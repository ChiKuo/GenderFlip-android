package tw.chikuo.genderflip;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chi on 2016/12/3.
 */
public class MainMissionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private static final int TYPE_BOARD = 0;
    private static final int TYPE_ITEM = 1;

    public List<Mission> missionList;

    public MainMissionAdapter(Context context) {
        this.context = context;
        missionList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_BOARD) {

            View itemView = LayoutInflater.
                    from(parent.getContext()).
                    inflate(R.layout.recycler_account_board, parent, false);

            return new BoardViewHolder(itemView);

        } else if (viewType == TYPE_ITEM) {

            View itemView = LayoutInflater.
                    from(parent.getContext()).
                    inflate(R.layout.recycler_mission_item, parent, false);

            return new ItemViewHolder(itemView);

        }
        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        if (viewHolder instanceof BoardViewHolder) {

            final BoardViewHolder holder = (BoardViewHolder)viewHolder;


        } else if (viewHolder instanceof ItemViewHolder) {

            final ItemViewHolder holder = (ItemViewHolder)viewHolder;
            Mission mission = missionList.get(position - 1);

            if (mission != null){

                // Name
                if (mission.getMissionName() != null){
                    holder.nameTextView.setText(mission.getMissionName());
                }

                int allCount = mission.getMaleCount() + mission.getFemaleCount();
                int malePercentage = 100 * mission.getMaleCount() / allCount;
                int femalePercentage = 100 - malePercentage;

                holder.maleCountTextView.setText(malePercentage + "%");
                holder.femaleCountTextView.setText(femalePercentage + "%");

                int emptyWidth = 140 * femalePercentage / 100;
                LinearLayout.LayoutParams maleParams = new LinearLayout.LayoutParams(turnDpToPixels(emptyWidth), turnDpToPixels(30));
                holder.emptyTextView.setLayoutParams(maleParams);

            }

        }
    }


    @Override
    public int getItemCount() {
        return missionList.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return TYPE_BOARD;
        } else {
            return TYPE_ITEM;
        }

    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {

        public BoardViewHolder(View itemView) {
            super(itemView);
        }

    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView maleCountTextView;
        private TextView femaleCountTextView;
        private TextView emptyTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.mission_name_textView);
            maleCountTextView = (TextView) itemView.findViewById(R.id.male_count_textView);
            femaleCountTextView = (TextView) itemView.findViewById(R.id.female_count_textView);
            emptyTextView = (TextView) itemView.findViewById(R.id.empty_textView);
        }
    }

    public void setMissionList(List<Mission> missionList) {
        this.missionList = missionList;
        notifyDataSetChanged();
    }


    private int turnDpToPixels(int dp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float fpixels = metrics.density * (float) dp;
        return  (int) (fpixels + 0.5f);
    }


}