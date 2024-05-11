package com.example.ch3ex3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyFragmentAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 2; // 两个选项卡

    public MyFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // 根据位置返回对应的 Fragment
        switch (position) {
            case 0:
                return new FriendListFragment(); // 好友列表 Fragment
            case 1:
                return new MyFriendsFragment(); // 我的好友 Fragment
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
