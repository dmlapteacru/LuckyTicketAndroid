package com.example.ahitler_fcked_my_dog.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class Home extends Activity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

        viewPager = (ViewPager) findViewById(R.id.view_slider);
        ViewSlider viewSlider = new ViewSlider(this);
        viewPager.setAdapter(viewSlider);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimer(),6000, 5000);

    }
    //функция перехода в окно выбора игры, по нажатию кнопки
    public void onClick(View view){

        Intent intent=new Intent(Home.this,GamePicker.class);
        startActivity(intent);
    }
    //функция перехода в окно топ-очков, по нажатию кнопки
    public void topScore(View view){

        Intent intent=new Intent(Home.this,TopScores.class);
        startActivity(intent);
    }
    //функция вызова меню SHARE, где есть возможность поделиться игрой
    public void shareButton(View view){

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String body = "https://play.google.com/store";
        intent.putExtra(Intent.EXTRA_TEXT, body);
        startActivity(Intent.createChooser(intent,"Share with your friends."));

        /*Uri uri = Uri.parse("https://www.facebook.com/sharer/sharer.php?u=https%3A//play.google.com/store?hl=en");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);*/
    }

    //Запуск слайдера в главном окне (переключение билетов )
    public class MyTimer extends TimerTask{
        @Override
        public void run(){
            Home.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                    }else if(viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }else if(viewPager.getCurrentItem()==2){
                        viewPager.setCurrentItem(3);
                    }else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }


}
