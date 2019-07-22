package skill.jobs.RecyclerView.Adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.Helper.SkillsHelper;

public class SkillsAdapter extends BaseQuickAdapter<SkillsHelper, BaseViewHolder> {
    public SkillsAdapter(int layoutResId, @Nullable List<SkillsHelper> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SkillsHelper item) {
        helper.setText(R.id.tv_contact_name, item.getSkillsName())
                .setText(R.id.tv_contact, item.getYearsOfExperience())
                .addOnClickListener(R.id.tv_btn_more);

        //we use contact information adapter over here because of same number of parameter.
        // That's why we skip to re design a same thing.
    }
}
