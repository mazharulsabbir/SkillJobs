package skill.jobs.database;

public class JobDeadline {
    private String date;
    private String timezone;
    private int timezone_type;

    public JobDeadline(String date, String timezone, int timezone_type) {
        this.date = date;
        this.timezone = timezone;
        this.timezone_type = timezone_type;
    }

    public String getDate() {
        return date;
    }

    public String getTimezone() {
        return timezone;
    }

    public int getTimezone_type() {
        return timezone_type;
    }
}
