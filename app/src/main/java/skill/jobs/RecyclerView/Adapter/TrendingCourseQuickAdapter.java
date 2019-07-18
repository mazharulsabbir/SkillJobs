package skill.jobs.RecyclerView.Adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.Helper.TrendingCourses;

public class TrendingCourseQuickAdapter extends BaseQuickAdapter<TrendingCourses, BaseViewHolder> {
    public TrendingCourseQuickAdapter(int view, List<TrendingCourses> courses) {
        super(view, courses);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, TrendingCourses courses) {
        viewHolder
                .setText(R.id.course_title, courses.getTitle())
                .setText(R.id.course_duration, courses.getDuration())
                .setText(R.id.course_fees, courses.getFees());
    }
}
