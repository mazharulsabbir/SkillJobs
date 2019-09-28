package skill.jobs.recyclerview.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.database.TrainingApiHelper;

public class RunningCourseAdapter extends BaseQuickAdapter<TrainingApiHelper, BaseViewHolder> {
    public RunningCourseAdapter(int layoutResId, @Nullable List<TrainingApiHelper> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder viewHolder, TrainingApiHelper item) {
        viewHolder
                .setText(R.id.tv_running_course_title,item.getName());

    }
}
