package skill.jobs.recyclerview.helper;

public class WorkExperienceHepler {
    String mOrganizationName, mPosition, mJoinDate, mResignDate;

    public WorkExperienceHepler() {
    }

    public WorkExperienceHepler(String mOrganizationName, String mPosition, String mJoinDate, String mResignDate) {
        this.mOrganizationName = mOrganizationName;
        this.mPosition = mPosition;
        this.mJoinDate = mJoinDate;
        this.mResignDate = mResignDate;
    }

    public String getmOrganizationName() {
        return mOrganizationName;
    }

    public void setmOrganizationName(String mOrganizationName) {
        this.mOrganizationName = mOrganizationName;
    }

    public String getmPosition() {
        return mPosition;
    }

    public void setmPosition(String mPosition) {
        this.mPosition = mPosition;
    }

    public String getmJoinDate() {
        return mJoinDate;
    }

    public void setmJoinDate(String mJoinDate) {
        this.mJoinDate = mJoinDate;
    }

    public String getmResignDate() {
        return mResignDate;
    }

    public void setmResignDate(String mResignDate) {
        this.mResignDate = mResignDate;
    }
}
