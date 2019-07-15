package skill.jobs.RecyclerView;

public class ProfileInformationHelper {
    int drawable;
    String title, info;

    public ProfileInformationHelper() {
    }

    public ProfileInformationHelper(int drawable, String title, String info) {
        this.drawable = drawable;
        this.title = title;
        this.info = info;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
