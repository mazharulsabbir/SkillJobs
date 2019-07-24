package skill.jobs.recyclerview.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.recyclerview.helper.UpcommingCourse;

public class UpCommingCourseAdapter extends BaseQuickAdapter<UpcommingCourse, BaseViewHolder> {
    public UpCommingCourseAdapter(int layoutResId, @Nullable List<UpcommingCourse> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder viewHolder, UpcommingCourse item) {
        viewHolder
                .setText(R.id.tv_running_course_title,item.getTitle())
                .setText(R.id.reg_last_date,item.getLastdate())
                .setText(R.id.start_date,item.getStartdate())
                .setText(R.id.tv_running_course_hours,item.getHours())
                .setText(R.id.previous_price_upcomming_course,item.getPre_price())
                .setText(R.id.tv_price,item.getPrice());
    }


}
