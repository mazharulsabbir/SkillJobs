package skill.jobs.RecyclerView.Adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.Helper.CertificationsHelper;

public class CertificationsAdapter extends BaseQuickAdapter<CertificationsHelper, BaseViewHolder> {
    public CertificationsAdapter(int layoutResId, @Nullable List<CertificationsHelper> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CertificationsHelper item) {
        helper.setText(R.id.tv_certificate_name,item.getcName())
                .setText(R.id.tv_certificate_name,item.getcName())
                .setText(R.id.tv_certificate_name,item.getcName())
                .setText(R.id.tv_certificate_name,item.getcName())
                .addOnClickListener(R.id.tv_btn_more);
    }
}
