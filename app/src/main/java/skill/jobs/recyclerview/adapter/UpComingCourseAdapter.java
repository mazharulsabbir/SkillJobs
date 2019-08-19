package skill.jobs.recyclerview.adapter;

import android.graphics.Paint;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.recyclerview.helper.UpcomingCourse;

public class UpComingCourseAdapter extends BaseQuickAdapter<UpcomingCourse, BaseViewHolder> {

    private List<UpcomingCourse> courses;

    public UpComingCourseAdapter(int layoutResId, @Nullable List<UpcomingCourse> data) {
        super(layoutResId,data);
        courses=data;
    }


    @Override
    protected void convert(BaseViewHolder viewHolder, UpcomingCourse item) {
        viewHolder
                .setText(R.id.tv_running_course_title,item.getTitle())
                .setText(R.id.reg_last_date,item.getLastdate())
                .setText(R.id.start_date,item.getStartdate())
                .setText(R.id.tv_running_course_hours,item.getHours())
                .setText(R.id.previous_price_upcomming_course,item.getPre_price())
                .addOnClickListener(R.id.enrollButton)
                .setText(R.id.tv_price,item.getPrice());

        TextView oldPrice = viewHolder.getView(R.id.previous_price_upcomming_course);
        oldPrice.setPaintFlags(oldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public boolean isLoading() {
        return super.isLoading();
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }
}
