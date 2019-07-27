package skill.jobs.recyclerview.adapter;

import android.view.View;
import android.widget.ImageButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import skill.jobs.R;
import skill.jobs.database.JobsData;

public class JobsContainerAdapter extends BaseQuickAdapter<JobsData, BaseViewHolder> {
    public JobsContainerAdapter(int view, List<JobsData> jobs) {
        super(view, jobs);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final JobsData jobs) {
        viewHolder
                .setText(R.id.job_company_name, jobs.getCompanyName())
                .setText(R.id.job_vacancy_name, jobs.getJobTitle())
                .setText(R.id.job_location, jobs.getJobDeadline().getTimezone())
                .setText(R.id.job_dead_line, jobs.getJobDeadline().getDate())
//                .setText(R.id.job_experience, jobs.getExperience())
//                .setText(R.id.job_salary, jobs.getSalary())
//                .setVisible(R.id.menu_favorite, jobs.isFavorite())
                .addOnClickListener(R.id.menu_share_job)
                .addOnClickListener(R.id.menu_favorite)
                .addOnClickListener(R.id.menu_not_favorite);//ready to favorite

        //Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) viewHolder.getView(R.id.iv));
        jobs.setFavorite(false);

        final ImageButton likeButton = viewHolder.getView(R.id.menu_favorite);
        final ImageButton dislikeButton = viewHolder.getView(R.id.menu_not_favorite);

        if (jobs.isFavorite()){
            dislikeButton.setVisibility(View.INVISIBLE);
        }else{
            dislikeButton.setVisibility(View.VISIBLE);
        }

        //on click it will change to unlike button
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeButton.setVisibility(View.INVISIBLE);
                dislikeButton.setVisibility(View.VISIBLE);

                jobs.setFavorite(false);
            }
        });

        //on click it will change to like button
        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dislikeButton.setVisibility(View.INVISIBLE);
                likeButton.setVisibility(View.VISIBLE);

                jobs.setFavorite(true);

            }
        });

    }

}
