package com.example.ahitler_fcked_my_dog.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Random;



public class GameStarts extends Activity{
    Random rand = new Random();
    int count=0,pseudoRandom,max=0;
    int[] array=new int[6];
    private ProgressBar progbar;
    private TextView progCount;
    private View img_background;
    private CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game_starts);
        progbar=(ProgressBar) findViewById(R.id.progressBar);
        progCount=(TextView) findViewById(R.id.progressCount);
        img_background = findViewById(R.id.back_tikcet_ch);
        start();
    }


   //функция начала игры
    public void start(){
        final Button button_left=(Button) findViewById(R.id.button);
        final Button button_right=(Button) findViewById(R.id.button2);
        final Button button_next=(Button) findViewById(R.id.next_level);
        progbar.getProgressDrawable().setColorFilter(
                Color.rgb(86, 180, 239), android.graphics.PorterDuff.Mode.SRC_IN);
        progbar.setScaleY(4);

        //обратный отсчет времени, по истичении которого игрок проигрывает, начиная с 20 сек.
        countDownTimer = new CountDownTimer(21000, 1000) {
            @Override
            //уменьшаяется на 1 секунду
            //если достигает 8 секунд, полоса окрашивается в желтый цвет
            //если достиграет 5 секунд, полоса окрашивается в красный цвет
            public void onTick(long millisUntilFinished) {
                progCount.setText(millisUntilFinished / 1000 + "");
                progbar.setProgress((int)millisUntilFinished/1000);
                if(progbar.getProgress()==8){
                    progbar.getProgressDrawable().setColorFilter(
                            Color.rgb(247, 197, 61), android.graphics.PorterDuff.Mode.SRC_IN);
                }else if(progbar.getProgress()==5){
                    progbar.getProgressDrawable().setColorFilter(
                            Color.rgb(242, 89, 89), android.graphics.PorterDuff.Mode.SRC_IN);
                }

            }
            //по истичению времени, игрок проигрывает
            @Override
            public void onFinish() {
                progbar.setProgress(0);
                progCount.setText("DEFEAT");
                button_left.setEnabled(false);
                button_right.setEnabled(false);
                button_next.setText("AGAIN");
                button_next.setVisibility(View.VISIBLE);
            }
        }.start();

        //рандомно появляются билеты, с каждым раундом разные виды
        pseudoRandom=rand.nextInt(5);
        switch (pseudoRandom) {
            case 0:
                img_background.setBackgroundResource(R.drawable.violet_250);
                break;
            case 1:
                img_background.setBackgroundResource(R.drawable.blue_250);
                break;
            case 2:
                img_background.setBackgroundResource(R.drawable.blue_bus_250);
                break;
            case 3:
                img_background.setBackgroundResource(R.drawable.red_250);
                break;
            case 4:
                img_background.setBackgroundResource(R.drawable.roz_250);
                break;
        }
        //генерация номера билета
        pseudoRandom=rand.nextInt(3);
        if(pseudoRandom==0) {
            int gotIt = 0;

            while (gotIt != 1) {
                for (int i = 0; i < 6; i++) {
                    array[i] = rand.nextInt(10);
                }
                int sum = array[0] + array[1] + array[2];
                int sum2 = array[3] + array[4] + array[5];

                if (sum == sum2) gotIt = 1;
            }
        }else {
            for (int i=0;i<6;i++){
                array[i]=rand.nextInt(10);
            }
        }
        TextView t = (TextView) findViewById(R.id.txt);
        t.setText(""+ array[0]+ " "+ array[1]+ " "+ array[2]+ " "+ array[3]+ " "+ array[4]+ " "+ array[5]);
        TextView t1 = (TextView) findViewById(R.id.Count);
        t1.setText(""+count);
    }

    //нажатие на кнопку YES и проверка на правильность ответа
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onClYes(View view){

        if(countDownTimer !=null){
            countDownTimer.cancel();
        }countDownTimer.cancel();
        int a,b;
        Button t=(Button) findViewById(R.id.button);
        Button t2=(Button) findViewById(R.id.button2);
        Button tNext=(Button) findViewById(R.id.next_level);
        a=array[0]+array[1]+array[2];
        b=array[3]+array[4]+array[5];
        if(a==b){
            count++;
            view.setBackground(getResources().getDrawable(R.drawable.right_answer));
            t.setEnabled(false);
            t2.setEnabled(false);
            tNext.setText("NEXT");
            tNext.setVisibility(View.VISIBLE);
            if(count>max){
                max=count;

            }
        } else if(a!=b){
                count=0;
                view.setBackground(getResources().getDrawable(R.drawable.wrong_answer));
                t.setEnabled(false);
                t2.setEnabled(false);
                tNext.setText("AGAIN");
                tNext.setVisibility(View.VISIBLE);
        }
    }

    //нажатие на кнопку NO и проверка на правильность ответа
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onClNo(View view){

        if(countDownTimer !=null){
            countDownTimer.cancel();
        }countDownTimer.cancel();
        int a,b;
        Button t=(Button) findViewById(R.id.button);
        Button t2=(Button) findViewById(R.id.button2);
        Button tNext=(Button) findViewById(R.id.next_level);
        a=array[0]+array[1]+array[2];
        b=array[3]+array[4]+array[5];
        if(a==b){
            count=0;
            view.setBackground(getResources().getDrawable(R.drawable.wrong_answer));
            t.setEnabled(false);
            t2.setEnabled(false);
            tNext.setText("AGAIN");
            tNext.setVisibility(View.VISIBLE);

            } else if(a!=b){
                count++;
            view.setBackground(getResources().getDrawable(R.drawable.right_answer));
                t.setEnabled(false);
                t2.setEnabled(false);
                tNext.setText("NEXT");
                tNext.setVisibility(View.VISIBLE);
                if(count>max){
                    max=count;

                }

            }
    }

    //Нажатие на кнопку NEXT или AGAIN
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClickNext(View view){
        Button chooseAn1 = (Button) findViewById(R.id.button);
        Button chooseAn2 = (Button) findViewById(R.id.button2);

        chooseAn1.setEnabled(true);
        chooseAn2.setEnabled(true);

        view.setVisibility(View.INVISIBLE);
        chooseAn1.setBackground(getResources().getDrawable(R.drawable.choose_answer));
        chooseAn2.setBackground(getResources().getDrawable(R.drawable.choose_answer));

        start();
    }
}
