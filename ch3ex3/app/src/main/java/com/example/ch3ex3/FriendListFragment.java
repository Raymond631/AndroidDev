package com.example.ch3ex3;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Arrays;
import java.util.List;


public class FriendListFragment extends Fragment {
    private ListView listView;
    private LottieAnimationView loadingAnimation;

    private ArrayAdapter<String> adapter;

    public FriendListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_friend_list, container, false);
        listView = rootView.findViewById(R.id.listView);
        loadingAnimation = rootView.findViewById(R.id.loadingAnimation);

        List<String> friendList = Arrays.asList("Friend 1", "Friend 2", "Friend 3");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, friendList);
        listView.setAdapter(adapter);

        listView.setVisibility(View.GONE);
        // Simulate loading for 5 seconds
        new Handler().postDelayed(() -> {
            // Stop loading animation
            loadingAnimation.cancelAnimation();
            loadingAnimation.setVisibility(View.GONE);

            // Fade in friend list
            listView.setAlpha(0f);
            listView.setVisibility(View.VISIBLE);
            listView.animate()
                    .alpha(1f)
                    .setDuration(1000) // 1 second duration for the fade in animation
                    .start();
        }, 5000); // 5 seconds delay

        return rootView;
    }
}