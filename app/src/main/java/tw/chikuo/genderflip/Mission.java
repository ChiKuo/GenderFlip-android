package tw.chikuo.genderflip;

/**
 * Created by Chi on 2016/12/3.
 */
public class Mission {

    private String missionName;
    private int maleCount;
    private int femaleCount;

    public Mission() {
    }

    public Mission(String missionName, int maleCount, int femaleCount) {
        this.missionName = missionName;
        this.maleCount = maleCount;
        this.femaleCount = femaleCount;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public int getMaleCount() {
        return maleCount;
    }

    public void setMaleCount(int maleCount) {
        this.maleCount = maleCount;
    }

    public int getFemaleCount() {
        return femaleCount;
    }

    public void setFemaleCount(int femaleCount) {
        this.femaleCount = femaleCount;
    }
}
