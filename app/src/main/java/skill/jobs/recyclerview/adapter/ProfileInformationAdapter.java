package skill.jobs.recyclerview.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.recyclerview.helper.ProfileInformationHelper;

public class ProfileInformationAdapter extends BaseQuickAdapter<ProfileInformationHelper, BaseViewHolder>
{
    public ProfileInformationAdapter(int layoutResId, @Nullable List<ProfileInformationHelper> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProfileInformationHelper item) {
        helper.setText(R.id.tv_title,item.getTitle())
                .setText(R.id.tv_info,item.getInfo())
                .setBackgroundRes(R.id.iv_src,item.getDrawable());
    }
}
