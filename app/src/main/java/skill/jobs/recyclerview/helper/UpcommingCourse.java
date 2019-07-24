package skill.jobs.recyclerview.helper;

public class UpcommingCourse {

    private String title,lastdate,startdate,hours;
    private String price,pre_price;

    public UpcommingCourse() {
    }

    public UpcommingCourse(String title, String lastdate, String startdate, String hours, String price, String pre_price) {
        this.title = title;
        this.lastdate = lastdate;
        this.startdate = startdate;
        this.hours = hours;
        this.price = price;
        this.pre_price = pre_price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPre_price() {
        return pre_price;
    }

    public void setPre_price(String pre_price) {
        this.pre_price = pre_price;
    }
}
