package skill.jobs.recyclerview.helper;

public class EducationHelper {
    private String degreeLevel, degreeTitle, resultSystem, resultAchieved, gradeScale, passingYear, institution;

    public EducationHelper() {
    }

    public EducationHelper(String degreeLevel, String degreeTitle, String resultSystem, String resultAchved, String gradeScale, String passingYear, String institution) {
        this.degreeLevel = degreeLevel;
        this.degreeTitle = degreeTitle;
        this.resultSystem = resultSystem;
        this.resultAchieved = resultAchved;
        this.gradeScale = gradeScale;
        this.passingYear = passingYear;
        this.institution = institution;
    }

    public String getDegreeLevel() {
        return degreeLevel;
    }

    public void setDegreeLevel(String degreeLevel) {
        this.degreeLevel = degreeLevel;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public String getResultSystem() {
        return resultSystem;
    }

    public void setResultSystem(String resultSystem) {
        this.resultSystem = resultSystem;
    }

    public String getResultAchved() {
        return resultAchieved;
    }

    public void setResultAchved(String resultAchved) {
        this.resultAchieved = resultAchved;
    }

    public String getGradeScale() {
        return gradeScale;
    }

    public void setGradeScale(String gradeScale) {
        this.gradeScale = gradeScale;
    }

    public String getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(String passingYear) {
        this.passingYear = passingYear;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
