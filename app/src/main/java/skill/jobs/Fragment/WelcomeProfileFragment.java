package skill.jobs.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.VideoView;

import skill.jobs.JobSeekerActivity;
import skill.jobs.R;


public class WelcomeProfileFragment extends Fragment {
    CardView JobSeekerButton, EmployeeButton;
    VideoView videoview;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_welcome_profile, container, false);

        JobSeekerButton=view.findViewById(R.id.btJobseekerchoice);
        EmployeeButton=view.findViewById(R.id.btemployerchoice);
        //video
        videoview =view.findViewById(R.id.videoView);



        JobSeekerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation Shake = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);
                JobSeekerButton.startAnimation(Shake);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        startActivity(new Intent(getActivity(), JobSeekerActivity.class));

                    }
                }, 100);

            }
        });
        EmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation Shake = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);
                EmployeeButton.startAnimation(Shake);

            }
        });


        return view;
    }

}
