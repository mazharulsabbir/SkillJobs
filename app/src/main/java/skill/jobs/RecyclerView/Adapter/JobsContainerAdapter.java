package skill.jobs.RecyclerView.Adapter;

import android.view.View;
import android.widget.ImageButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.Helper.JobsContainerHelper;

public class JobsContainerAdapter extends BaseQuickAdapter<JobsContainerHelper, BaseViewHolder> {
    public JobsContainerAdapter(int view, List<JobsContainerHelper> jobs) {
        super(view, jobs);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final JobsContainerHelper jobs) {
        viewHolder
                .setImageResource(R.id.imageView2, jobs.getVector())
                .setText(R.id.job_company_name, jobs.getCompanyName())
                .setText(R.id.job_vacancy_name, jobs.getVacancyPostName())
                .setText(R.id.job_location, jobs.getCompanyLocation())
                .setText(R.id.job_experience, jobs.getExperience())
                .setText(R.id.job_salary, jobs.getSalary())
                .setText(R.id.job_dead_line, jobs.getDeadLine())
                .setVisible(R.id.menu_not_favorite, jobs.isFavorite())
                .addOnClickListener(R.id.menu_share_job)
                .addOnClickListener(R.id.menu_favorite)
                .addOnClickListener(R.id.menu_not_favorite);//ready to favorite

        final ImageButton likeButton = viewHolder.getView(R.id.menu_favorite);
        final ImageButton dislikeButton = viewHolder.getView(R.id.menu_not_favorite);

        if (jobs.isFavorite()){
            likeButton.setVisibility(View.INVISIBLE);
        }else{
            likeButton.setVisibility(View.VISIBLE);
        }

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeButton.setVisibility(View.INVISIBLE);
                dislikeButton.setVisibility(View.VISIBLE);

                jobs.setFavorite(true);
            }
        });

        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dislikeButton.setVisibility(View.INVISIBLE);
                likeButton.setVisibility(View.VISIBLE);

                jobs.setFavorite(false);

            }
        });

    }

}
