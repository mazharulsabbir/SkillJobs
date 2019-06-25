package skill.jobs.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hbb20.CountryCodePicker;

import skill.jobs.R;


public class ProfileEditJobseekerFragment extends Fragment {
    View view;
    private RadioGroup radioGroup;
    private RadioButton radioButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_profile_edit_jobseeker, container, false);
        radioGroup = view.findViewById(R.id.radio);



        return view;
    }

}
