package skill.jobs.RecyclerView.Helper;

public class Jobs {
    int vector;
    String companyName, vacancyPostName, companyLocation, deadLine;
    Integer salary;

    public Jobs() {
    }

    public Jobs(String companyName, String vacancyPostName, String companyLocation, String deadLine, int salary) {
        this.companyName = companyName;
        this.vacancyPostName = vacancyPostName;
        this.companyLocation = companyLocation;
        this.deadLine = deadLine;
        this.salary = salary;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
