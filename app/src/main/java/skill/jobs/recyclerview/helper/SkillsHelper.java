package skill.jobs.recyclerview.helper;

public class SkillsHelper {
    private String skillsName, yearsOfExperience;

    public SkillsHelper() {
    }

    public SkillsHelper(String skillsName, String yearsOfExperience) {
        this.skillsName = skillsName;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getSkillsName() {
        return skillsName;
    }

    public void setSkillsName(String skillsName) {
        this.skillsName = skillsName;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
