package com.hugo.charavatarviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.hugo.charavatarview.CharAvatarView;
//import com.hugo.charavatarview.CharAvatarView;

public class MainActivity extends AppCompatActivity {

    CharAvatarView mAvatarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://avatars2.githubusercontent.com/u/11666634?v=3&s=466";
        mAvatarView = (CharAvatarView) findViewById(R.id.avatar);
        mAvatarView.setText("谢三弟");
        //Glide.with(this).load(url).into(mAvatarView);

    }
}
