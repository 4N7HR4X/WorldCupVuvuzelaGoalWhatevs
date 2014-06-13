package com.binaryeclipse.worldcup.app.views.home.fragments;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.binaryeclipse.worldcup.app.R;
import com.binaryeclipse.worldcup.app.utils.Utils;
import com.binaryeclipse.worldcup.app.views.home.adapters.GroupAdapter;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by Andras on 2014/06/12.
 */
public class HomeFragment extends Fragment {

    @InjectView(R.id.home_landing_text)
    TextView landingText;
    @InjectView(R.id.home_landing_list)
    ExpandableListView list;

    @OnClick(R.id.home_landing_button)
    public void button() {

    }

    List<List<String>> groups;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_landing_fragment, container, false);
        ButterKnife.inject(this, view);
        groups = Utils.generateGroups();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // landingText.setText(R.string.action_settings);
        GroupAdapter adapter = new GroupAdapter(getActivity(), groups);
        list.setAdapter(adapter);

        DisplayMetrics metrics = new DisplayMetrics();
        final Activity activity = getActivity();
        if (activity != null) {
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int width = metrics.widthPixels - getPixelFromDips(32);
            // int width = view.getMeasuredWidth();
            list.setIndicatorBounds(width - getPixelFromDips(24), width - getPixelFromDips(8));
            list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                    return false;
                }
            });
        }
        super.onViewCreated(view, savedInstanceState);
    }

    public int getPixelFromDips(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);

    }

}
