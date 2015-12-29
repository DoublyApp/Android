package com.votives.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Window;

import com.votives.R;
import com.votives.fragment.BaseFragment;
import com.votives.fragment.ChatBottomFragment;
import com.votives.fragment.ChatFragment;
import com.votives.fragment.ChatTopFragment;

public class ChatActivity extends FragmentActivity {
    BaseFragment topBar;
    BaseFragment bottomBar;
    BaseFragment chatFragment;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chat);
        Bundle b = getIntent().getBundleExtra(MainActivity.CHAT_INFO);
        int receiverID = b.getInt(MainActivity.RECEIVER_ID);

        topBar = ChatTopFragment.newInstance(receiverID);
        bottomBar = ChatBottomFragment.newInstance(receiverID);
        chatFragment = ChatFragment.newInstance(receiverID);
        manager = getSupportFragmentManager();

        manager.beginTransaction().add(R.id.top_bar, topBar).commit();
        manager.beginTransaction().add(R.id.bottom_bar, bottomBar).commit();
        manager.beginTransaction().add(R.id.message_fragment, chatFragment).commit();
    }
}