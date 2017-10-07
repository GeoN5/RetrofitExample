package com.example.baehyeonbin.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText number;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        FirebaseInstanceId.getInstance().getToken();
    }

    public void init(){
        name=(EditText)findViewById(R.id.name);
        number=(EditText)findViewById(R.id.number);
        textView=(TextView)findViewById(R.id.textView);
    }
    public void send(View view){
        post();
    }
    public void post(){
        RetrofitService retrofitService=RetrofitService.retrofit.create(RetrofitService.class);
        Call<TestRepo>call=retrofitService.getItem(name.getText().toString(),number.getText().toString());
        Log.d("Test","call start");
        call.enqueue(new Callback<TestRepo>() {
            @Override
            public void onResponse(Call<TestRepo> call, Response<TestRepo> response) {
                String text=response.body().toString();
                Log.d("Test","what happen?"+text);
                textView.setText(text);
            }

            @Override
            public void onFailure(Call<TestRepo> call, Throwable t) {
                Log.d("Test","fail");
            }
        });

    }
}
