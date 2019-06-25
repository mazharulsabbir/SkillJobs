package skill.jobs.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;

public class JobsContainerAdapter extends BaseQuickAdapter<JobsContainerHelper, BaseViewHolder> {
    public JobsContainerAdapter(int view, List<JobsContainerHelper> jobs) {
        super(view, jobs);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, JobsContainerHelper jobs) {
        viewHolder
                .setText(R.id.job_company_name, jobs.getCompanyName())
                .setText(R.id.job_vacancy_name, jobs.getVacancyPostName())
                .setText(R.id.job_type, jobs.getJobType())
                .setText(R.id.job_location, jobs.getCompanyLocation())
                .setText(R.id.job_experience, jobs.getExperience())
                .setText(R.id.job_salary, jobs.getSalary())
                .setText(R.id.job_dead_line, jobs.getDeadLine());
    }
}
