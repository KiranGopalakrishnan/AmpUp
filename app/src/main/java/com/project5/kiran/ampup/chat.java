package com.project5.kiran.ampup;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.R.attr.id;

public class chat extends AppCompatActivity {
    String message;
    Context context;
    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        context = getApplicationContext();
        ImageView sendButton = (ImageView) findViewById(R.id.sendButton);
        final EditText messageBox = (EditText) findViewById(R.id.chatTextBox);
        final LinearLayout chatDisplayBox = (LinearLayout) findViewById(R.id.chatDisplayView);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = messageBox.getText().toString();
                LinearLayout.LayoutParams bubbleParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                LinearLayout parentMessageBubble = new LinearLayout(context);
                bubbleParams.setMargins(10,10,10,10);
                parentMessageBubble.setPadding(10,10,10,10);

                parentMessageBubble.setLayoutParams(bubbleParams);
                if(i%2==0){
                    parentMessageBubble.setGravity(Gravity.LEFT);
                }else{
                    parentMessageBubble.setGravity(Gravity.RIGHT);
                }
                i++;
                TextView messageBubble = new TextView(context);
                ViewGroup.LayoutParams messageBubbleParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                messageBubble.setLayoutParams(messageBubbleParams);
                messageBubble.setText(message);
                messageBubble.setTextSize(18f);
                messageBubble.setTextColor(Color.parseColor("#FFFFFF"));
                messageBubble.setBackground(ContextCompat.getDrawable(context, R.drawable.roung_bubble));
                messageBubble.setPadding(35,25,35,25);
                messageBubble.setAlpha(0.0f);
                parentMessageBubble.addView(messageBubble);
                messageBubble.animate().alpha(1.0f);
                chatDisplayBox.addView(parentMessageBubble);
            }
        });
    }
}
