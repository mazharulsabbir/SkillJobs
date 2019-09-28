package skill.jobs.recyclerview.adapter;

import android.graphics.Paint;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.database.TrainingApiHelper;

public class UpcomingCourseAdapter extends BaseQuickAdapter<TrainingApiHelper, BaseViewHolder> {

    private List<TrainingApiHelper> courses;

    public UpcomingCourseAdapter(int layoutResId, @Nullable List<TrainingApiHelper> data) {
        super(layoutResId, data);
        courses = data;
    }


    @Override
    protected void convert(BaseViewHolder view, TrainingApiHelper item) {
        view
                .setText(R.id.tv_running_course_title, item.getName())
                .addOnClickListener(R.id.enrollButton);

        try {
            TextView previous_price = view.getView(R.id.previous_price_upcoming_course);
            previous_price.setPaintFlags(previous_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }catch (Exception e){
            e.printStackTrace();
        }

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
