package skill.jobs.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import skill.jobs.jobseeker.JobSeekerActivity;
import skill.jobs.R;


public class ProfileFragment extends Fragment {
    private CardView JobSeekerButton, EmployeeButton;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        JobSeekerButton = view.findViewById(R.id.btJobseekerchoice);
        EmployeeButton = view.findViewById(R.id.btemployerchoice);

        JobSeekerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Animation Shake = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);
//                JobSeekerButton.startAnimation(Shake);
//                new Handler().postDelayed(new Runnable() {
//                    public void run() {
//
//                    }
//                }, 200);
                startActivity(new Intent(getActivity(), JobSeekerActivity.class));

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
