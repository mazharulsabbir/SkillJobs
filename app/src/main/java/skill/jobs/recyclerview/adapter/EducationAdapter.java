package skill.jobs.recyclerview.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.recyclerview.helper.EducationHelper;

public class EducationAdapter extends BaseQuickAdapter<EducationHelper, BaseViewHolder> {
    public EducationAdapter(int layoutResId, @Nullable List<EducationHelper> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EducationHelper item) {
        helper.setText(R.id.tv_degree_level,item.getDegreeLevel())
                .setText(R.id.tv_degree_title,item.getDegreeTitle())
                .setText(R.id.result_system_name,item.getResultSystem())
                .setText(R.id.result_achieved_name,item.getResultAchved())
                .setText(R.id.institution_name,item.getInstitution())
                .setText(R.id.passing_year,item.getPassingYear())
                .setText(R.id.tv_degree_level,item.getDegreeLevel())
                .addOnClickListener(R.id.tv_btn_more);
    }
}
