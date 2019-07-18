package skill.jobs.RecyclerView.Adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.Helper.Jobs;

public class JobsQuickAdapter extends BaseQuickAdapter<Jobs, BaseViewHolder> {
    public JobsQuickAdapter(int view, List<Jobs> jobs) {
        super(view, jobs);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Jobs jobs) {
        viewHolder
                .setText(R.id.job_company_name, jobs.getCompanyName())
                .setText(R.id.job_vacancy_name, jobs.getVacancyPostName())
                .setText(R.id.job_location, jobs.getCompanyLocation())
                .setText(R.id.job_dead_line, jobs.getDeadLine());
    }
}
