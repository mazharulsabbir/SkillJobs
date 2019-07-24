package skill.jobs.recyclerview.helper;

public class CertificationsHelper {
    private String cName, examDate, score, scoreScale;

    public CertificationsHelper() {
    }

    public CertificationsHelper(String cName, String examDate, String score, String scoreScale) {
        this.cName = cName;
        this.examDate = examDate;
        this.score = score;
        this.scoreScale = scoreScale;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScoreScale() {
        return scoreScale;
    }

    public void setScoreScale(String scoreScale) {
        this.scoreScale = scoreScale;
    }
}
