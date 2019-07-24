package skill.jobs.recyclerview.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.recyclerview.helper.ReferenceHelper;

public class ReferenceAdapter extends BaseQuickAdapter<ReferenceHelper, BaseViewHolder> {
    public ReferenceAdapter(int layoutResId, @Nullable List<ReferenceHelper> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReferenceHelper item) {
        helper.setText(R.id.tv_person_name,item.getPersonName())
                .setText(R.id.tv_designation,item.getDesignation())
                .setText(R.id.tv_org_name,item.getOrgName())
                .setText(R.id.tv_contact_no,item.getContactNo())
                .setText(R.id.tv_email_address,item.getEmailAddress())
                .setText(R.id.tv_relationship,item.getRelation())
                .addOnClickListener(R.id.tv_btn_more);
    }
}
