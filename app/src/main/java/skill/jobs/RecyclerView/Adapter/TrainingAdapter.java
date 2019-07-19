package skill.jobs.RecyclerView.Adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.Helper.TrainingHelper;

public class TrainingAdapter extends BaseQuickAdapter<TrainingHelper, BaseViewHolder> {
    public TrainingAdapter(int layoutResId, @Nullable List<TrainingHelper> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TrainingHelper item) {
        helper.setText(R.id.tv_training_type,item.getTrainingType())
                .setText(R.id.tv_training_title,item.getTrainingTitle())
                .setText(R.id.tv_training_duration,item.getTrainingDuration())
                .setText(R.id.tv_training_start_date,item.getTrainingStartDate())
                .setText(R.id.tv_training_end_date,item.getTrainingEndDate())
                .setText(R.id.tv_training_certifications,item.getTrainingCertifications())
                .addOnClickListener(R.id.tv_btn_more);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }
}
