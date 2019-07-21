package skill.jobs.RecyclerView.Adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.Helper.RunningCourseHelper;

public class RunningCourseAdapter extends BaseQuickAdapter<RunningCourseHelper, BaseViewHolder> {
    public RunningCourseAdapter(int layoutResId, @Nullable List<RunningCourseHelper> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder viewHolder, RunningCourseHelper item) {
        viewHolder
                .setText(R.id.tv_running_course_title,item.getTitle())
                .setText(R.id.tv_running_course_hours,item.getHours());

    }
}
