package skill.jobs.recyclerview.helper;

public class RunningCourseHelper {
    public String title,hours;

    public RunningCourseHelper() {
    }

    public RunningCourseHelper(String title, String hours) {
        this.title = title;
        this.hours = hours;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
