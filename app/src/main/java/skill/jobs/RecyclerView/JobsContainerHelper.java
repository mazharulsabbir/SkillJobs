package skill.jobs.RecyclerView;

public class JobsContainerHelper {
    int vector;
    String companyName, vacancyPostName, companyLocation, deadLine, experience, jobType, salary;


    public JobsContainerHelper() {
    }

    public JobsContainerHelper(int vector, String companyName, String vacancyPostName, String companyLocation, String deadLine, String experience, String jobType, String salary) {
        this.vector = vector;
        this.companyName = companyName;
        this.vacancyPostName = vacancyPostName;
        this.companyLocation = companyLocation;
        this.deadLine = deadLine;
        this.experience = experience;
        this.jobType = jobType;
        this.salary = salary;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
