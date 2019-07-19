package skill.jobs.RecyclerView.Helper;

public class TrainingHelper {
    private String trainingType, trainingTitle, trainingDuration, trainingStartDate, trainingEndDate, trainingCertifications;

    public TrainingHelper() {
    }

    public TrainingHelper(String trainingType, String trainingTitle, String trainingDuration, String trainingStartDate, String trainingEndDate, String trainingCertifications) {
        this.trainingType = trainingType;
        this.trainingTitle = trainingTitle;
        this.trainingDuration = trainingDuration;
        this.trainingStartDate = trainingStartDate;
        this.trainingEndDate = trainingEndDate;
        this.trainingCertifications = trainingCertifications;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public String getTrainingTitle() {
        return trainingTitle;
    }

    public void setTrainingTitle(String trainingTitle) {
        this.trainingTitle = trainingTitle;
    }

    public String getTrainingDuration() {
        return trainingDuration;
    }

    public void setTrainingDuration(String trainingDuration) {
        this.trainingDuration = trainingDuration;
    }

    public String getTrainingStartDate() {
        return trainingStartDate;
    }

    public void setTrainingStartDate(String trainingStartDate) {
        this.trainingStartDate = trainingStartDate;
    }

    public String getTrainingEndDate() {
        return trainingEndDate;
    }

    public void setTrainingEndDate(String trainingEndDate) {
        this.trainingEndDate = trainingEndDate;
    }

    public String getTrainingCertifications() {
        return trainingCertifications;
    }

    public void setTrainingCertifications(String trainingCertifications) {
        this.trainingCertifications = trainingCertifications;
    }
}
