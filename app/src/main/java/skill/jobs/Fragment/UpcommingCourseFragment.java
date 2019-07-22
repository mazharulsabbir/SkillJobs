package skill.jobs.Fragment;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import skill.jobs.R;
import skill.jobs.RecyclerView.Adapter.UpCommingCourseAdapter;
import skill.jobs.RecyclerView.Helper.UpcommingCourse;

public class UpcommingCourseFragment extends Fragment {

   View view;
    private List<UpcommingCourse> courses;
    private BaseQuickAdapter mUpCommingCoursesAdapter;

    private RecyclerView mRecyclerViewUpcomingCourse;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_upcomming_course, container, false);

        initialRecyclerview();
        initialcourse();
        UpCommingCoursesAdapter();

        return view;
    }

    private void initialRecyclerview() {
        mRecyclerViewUpcomingCourse= view.findViewById(R.id.upcomming_course_recyclerview);
        mRecyclerViewUpcomingCourse.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void initialcourse() {
        courses =new ArrayList<>();
        for (int i=0;i<10;i++) {
            UpcommingCourse course = new UpcommingCourse(
                    "COURSE TITLE",
                    "10-4-19",
                    "5-5-19",
                    "48",
                    "5000",
                    "8000");
            courses.add(course);
        }

    }
    private void UpCommingCoursesAdapter() {
        mUpCommingCoursesAdapter=new UpCommingCourseAdapter(R.layout.design_upcoming_course,courses);
        mUpCommingCoursesAdapter.isFirstOnly(false);
        mUpCommingCoursesAdapter.openLoadAnimation();

        mRecyclerViewUpcomingCourse.setAdapter(mUpCommingCoursesAdapter);
    }

    private void texturl() {
        TextView previous_price = view.findViewById(R.id.previous_price_upcomming_course);
        previous_price.setPaintFlags(previous_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


    }




}
