package skill.jobs.recyclerview.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.database.JobsData;

public class JobsQuickAdapter extends BaseQuickAdapter<JobsData, BaseViewHolder> {
    List<JobsData> jobs;

    public JobsQuickAdapter(int view, List<JobsData> jobs) {
        super(view, jobs);
        this.jobs = jobs;
    }

    @Override
    protected void convert(BaseViewHolder helper, JobsData jobs) {
        helper
                .setText(R.id.job_company_name, jobs.getCompanyName())
                .setText(R.id.job_vacancy_name, jobs.getJobTitle())
                .setText(R.id.job_location, jobs.getJobDeadline().getTimezone())
                .setText(R.id.job_dead_line, jobs.getJobDeadline().getDate());
    }

    @Override
    public int getItemCount() {
        if (jobs.size() > 15)
            return 15;

        else return jobs.size();
    }

    @Override
    public boolean isLoading() {
        return super.isLoading();
    }
}
