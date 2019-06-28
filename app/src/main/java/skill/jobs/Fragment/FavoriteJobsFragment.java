package skill.jobs.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import skill.jobs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteJobsFragment extends Fragment {


    public FavoriteJobsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_jobs, container, false);
    }

}
