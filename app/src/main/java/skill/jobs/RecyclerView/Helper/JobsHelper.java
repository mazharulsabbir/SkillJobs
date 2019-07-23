package skill.jobs.RecyclerView.Helper;

public class JobsHelper {
    int vector;
    String companyName, vacancyPostName, companyLocation, deadLine;

    public JobsHelper() {
    }

    public JobsHelper(int vector, String companyName, String vacancyPostName, String companyLocation, String deadLine) {
        this.vector = vector;
        this.companyName = companyName;
        this.vacancyPostName = vacancyPostName;
        this.companyLocation = companyLocation;
        this.deadLine = deadLine;
    }

    public int getVector() {
        return vector;
    }

    public void setVector(int vector) {
        this.vector = vector;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVacancyPostName() {
        return vacancyPostName;
    }

    public void setVacancyPostName(String vacancyPostName) {
        this.vacancyPostName = vacancyPostName;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }
}
