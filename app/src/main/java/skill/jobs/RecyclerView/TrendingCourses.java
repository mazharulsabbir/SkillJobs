package skill.jobs.RecyclerView;

public class TrendingCourses {
    String title,duration,fees;

    public TrendingCourses() {
    }

    public TrendingCourses(String title, String duration, String fees) {
        this.title = title;
        this.duration = duration;
        this.fees = fees;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }
}
