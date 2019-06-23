package skill.jobs.Fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import skill.jobs.LoginActivity;
import skill.jobs.R;
import skill.jobs.RecyclerView.Jobs;
import skill.jobs.RecyclerView.QuickAdapter;
import skill.jobs.RegistrationActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    View view;
    private RecyclerView mRecyclerView;
    private List<Jobs> jobsList;
    private BaseQuickAdapter homeAdapter;


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return view;
    }

    @Override
    public void onStart() {
        initData();
        initView();
        initAdapter();

        stringUrlDesign();

        super.onStart();
    }

    private void initData() {
        jobsList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Jobs jobs = new Jobs("Company " + i,
                    "Vacancy " + i,
                    "Location " + i,
                    "Dead Line " + i, i);
            jobsList.add(jobs);
        }
    }

    private void initView() {
        mRecyclerView = view.findViewById(R.id.recycler_view_feature_job);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @SuppressWarnings("unchecked")
    private void initAdapter() {
        homeAdapter = new QuickAdapter(jobsList);
        View errorView = getLayoutInflater().inflate(R.layout.example_empty_jobs, (ViewGroup) mRecyclerView.getParent(), false);
        homeAdapter.setEmptyView(errorView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.setAdapter(homeAdapter);
            }
        }, 200);
    }

    private void stringUrlDesign() {
        String text = "Login or Register";
        TextView textView = view.findViewById(R.id.textView6);

        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpanSignIn = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLACK);
                ds.setUnderlineText(false);
            }
        };


        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                startActivity(new Intent(getActivity(), RegistrationActivity.class));
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLACK);
                ds.setUnderlineText(false);
            }
        };


        ss.setSpan(clickableSpanSignIn, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());


        ss.setSpan(clickableSpan1, 9, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

    }

}
