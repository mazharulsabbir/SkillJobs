package skill.jobs.database;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllTrainings {

    @SerializedName("data")
    private List<TrainingApiHelper> trainingApiHelper;

    public AllTrainings(List<TrainingApiHelper> trainingApiHelper) {
        this.trainingApiHelper = trainingApiHelper;
    }

    public List<TrainingApiHelper> getTrainingApiHelper() {
        return trainingApiHelper;
    }
}
