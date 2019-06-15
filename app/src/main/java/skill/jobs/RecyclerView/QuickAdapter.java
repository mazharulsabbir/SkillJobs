package skill.jobs.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;

public class QuickAdapter extends BaseQuickAdapter<Jobs, BaseViewHolder> {
    public QuickAdapter(List<Jobs> jobs) {
        super(R.layout.example_job, jobs);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Jobs jobs) {
        viewHolder
                .setText(R.id.job_company_name, jobs.getCompanyName())
                .setText(R.id.job_vacancy_name, jobs.getVacancyPostName())
                .setText(R.id.job_location, jobs.getCompanyLocation())
//                .setText(R.id.job_salary, jobs.getSalary())
                .setText(R.id.job_dead_line, jobs.getDeadLine());
    }
}
