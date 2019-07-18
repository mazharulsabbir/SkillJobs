package skill.jobs.RecyclerView.Adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.Helper.WorkExperienceHepler;

public class WorkExperienceAdapter extends BaseQuickAdapter<WorkExperienceHepler, BaseViewHolder> {
    public WorkExperienceAdapter(int layoutResId, @Nullable List<WorkExperienceHepler> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WorkExperienceHepler item) {
        helper.setText(R.id.tv_org_name,item.getmOrganizationName())
                .setText(R.id.tv_position,item.getmPosition())
                .setText(R.id.tv_join_date,item.getmJoinDate())
                .setText(R.id.tv_resign_date,item.getmResignDate())
                .addOnClickListener(R.id.tv_btn_more);
    }
}
