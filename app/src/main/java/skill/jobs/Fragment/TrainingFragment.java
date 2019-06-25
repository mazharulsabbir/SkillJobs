package skill.jobs.Fragment;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import skill.jobs.R;

public class TrainingFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_training, container, false);
        TextView previous_price = view.findViewById(R.id.previous_price_upcomming_course);
        previous_price.setPaintFlags(previous_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        return  view;
    }


}
