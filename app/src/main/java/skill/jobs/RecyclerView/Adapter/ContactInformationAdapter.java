package skill.jobs.RecyclerView.Adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.Helper.ContactInformationHelper;

public class ContactInformationAdapter extends BaseQuickAdapter<ContactInformationHelper, BaseViewHolder> {
    public ContactInformationAdapter(int layoutResId, @Nullable List<ContactInformationHelper> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactInformationHelper item) {
        helper.setText(R.id.tv_contact_name, item.getContactTitle())
                .setText(R.id.tv_contact, item.getContact())
                .addOnClickListener(R.id.tv_btn_more);

    }
}
