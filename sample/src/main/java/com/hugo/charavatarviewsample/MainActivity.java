package com.hugo.charavatarviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.hugo.charavatarview.CharAvatarView;
//import com.hugo.charavatarview.CharAvatarView;

public class MainActivity extends AppCompatActivity {

    CharAvatarView mAvatarView;
    private static final String[] colors = {
        "#1abc9c", "#16a085", "#f1c40f", "#f39c12", "#2ecc71",
        "#27ae60", "#e67e22", "#d35400", "#3498db", "#2980b9",
        "#e74c3c", "#c0392b", "#9b59b6", "#8e44ad", "#bdc3c7",
        "#34495e", "#2c3e50", "#95a5a6", "#7f8c8d", "#ec87bf",
        "#d870ad", "#f69785", "#9ba37e", "#b49255", "#b49255", "#a94136"
    };

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
