package skill.jobs.RecyclerView.Adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.Helper.JobDetailsViewHelper;

public class JobDetailsViewAdapter extends BaseQuickAdapter<JobDetailsViewHelper, BaseViewHolder> {
    public JobDetailsViewAdapter(int layoutResId, @Nullable List<JobDetailsViewHelper> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, JobDetailsViewHelper item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_info, item.getDescription());
    }
}
