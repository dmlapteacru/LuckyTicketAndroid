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


public class LeveSetNumber extends Activity {
    Random rand = new Random();
    int count=0,rem,max=0,pseudoRandom;
    int[] array=new int[6];
    private ProgressBar progbar;
    private TextView progCount;
    private View img_background;
    private CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_leve_set_number);
        progbar=(ProgressBar) findViewById(R.id.progressBar);
        progCount=(TextView) findViewById(R.id.progressCount);
        img_background = findViewById(R.id.back_tikcet_ch);
        start_set();
    }

    //функция начала игры
    public void start_set(){
        final Button button_next=(Button) findViewById(R.id.next_level);
        final Button button_answer_1 = (Button) findViewById(R.id.number_1);
        final Button button_answer_2 = (Button) findViewById(R.id.number_2);
        final Button button_answer_3 = (Button) findViewById(R.id.number_3);
        final Button button_answer_4 = (Button) findViewById(R.id.number_4);

        progbar.getProgressDrawable().setColorFilter(
                Color.rgb(86, 180, 239), android.graphics.PorterDuff.Mode.SRC_IN);
        progbar.setScaleY(4);
//обратный отсчет времени, по истичении которого игрок проигрывает, начиная с 20 сек.
        countDownTimer = new CountDownTimer(21000, 1000) {
            //уменьшаяется на 1 секунду
            //если достигает 8 секунд, полоса окрашивается в желтый цвет
            //если достиграет 5 секунд, полоса окрашивается в красный цвет
            @Override
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
                button_answer_1.setEnabled(false);
                button_answer_2.setEnabled(false);
                button_answer_3.setEnabled(false);
                button_answer_4.setEnabled(false);
                button_next.setText("AGAIN");
                button_next.setVisibility(View.VISIBLE);
            }
        }.start();
//100% генерация номера счастливого билета
        int gotIt=0;
        while(gotIt!=1) {
            for (int i = 0; i < 6; i++) {
                array[i] = rand.nextInt(10);
            }
            int sum=array[0]+array[1]+array[2];
            int sum2=array[3]+array[4]+array[5];

            if (sum==sum2)gotIt=1;
        }
        //рандомно появляются билеты, с каждым раундом разные виды
        pseudoRandom=rand.nextInt(5);
        if(pseudoRandom==0){
            img_background.setBackgroundResource(R.drawable.violet_250);
        }else if(pseudoRandom==1){
            img_background.setBackgroundResource(R.drawable.blue_250);
        }else if(pseudoRandom==2){
            img_background.setBackgroundResource(R.drawable.blue_bus_250);
        }else if(pseudoRandom==3){
            img_background.setBackgroundResource(R.drawable.red_250);
        }else if(pseudoRandom==4){
            img_background.setBackgroundResource(R.drawable.roz_250);
        }
        //рандомно выберается место для замены цифры на "?"
        rem=rand.nextInt(6);
        if (rem!=0){
            TextView t = (TextView) findViewById(R.id.txt_n_1);
            t.setText(""+array[0]);
        }else{
            TextView t = (TextView) findViewById(R.id.txt_n_1);
            t.setText("?");
        }
        if (rem!=1){
            TextView t = (TextView) findViewById(R.id.txt_n_2);
            t.setText(""+array[1]);
        }else{
            TextView t = (TextView) findViewById(R.id.txt_n_2);
            t.setText("?");
        }
        if (rem!=2){
            TextView t = (TextView) findViewById(R.id.txt_n_3);
            t.setText(""+array[2]);
        }else{
            TextView t = (TextView) findViewById(R.id.txt_n_3);
            t.setText("?");
        }
        if (rem!=3){
            TextView t = (TextView) findViewById(R.id.txt_n_4);
            t.setText(""+array[3]);
        }else{
            TextView t = (TextView) findViewById(R.id.txt_n_4);
            t.setText("?");
        }
        if (rem!=4){
            TextView t = (TextView) findViewById(R.id.txt_n_5);
            t.setText(""+array[4]);
        }else{
            TextView t = (TextView) findViewById(R.id.txt_n_5);
            t.setText("?");
        }
        if (rem!=5){
            TextView t = (TextView) findViewById(R.id.txt_n_6);
            t.setText(""+array[5]);
        }else{
            TextView t = (TextView) findViewById(R.id.txt_n_6);
            t.setText("?");
        }

        //рандомно выберается место для правильного ответа
        //остальные места заполняются случайными числами
        int but_num_picker=rand.nextInt(4);
        if(but_num_picker==0) {
            Button t = (Button) findViewById(R.id.number_1);
            t.setText(""+array[rem]);
        }else {
            Button t = (Button) findViewById(R.id.number_1);
            t.setText(""+rand.nextInt(10));
        }
        if(but_num_picker==1) {
            Button t = (Button) findViewById(R.id.number_2);
            t.setText(""+array[rem]);
        }else {
            Button t = (Button) findViewById(R.id.number_2);
            t.setText(""+rand.nextInt(10));
        }
        if(but_num_picker==2) {
            Button t = (Button) findViewById(R.id.number_3);
            t.setText(""+array[rem]);
        }else {
            Button t = (Button) findViewById(R.id.number_3);
            t.setText(""+rand.nextInt(10));
        }
        if(but_num_picker==3) {
            Button t = (Button) findViewById(R.id.number_4);
            t.setText(""+array[rem]);
        }else {
            Button t = (Button) findViewById(R.id.number_4);
            t.setText(""+rand.nextInt(10));
        }
            TextView t1 = (TextView) findViewById(R.id.Count);
            t1.setText(""+count);

    }
    //обработчик кнопки выбора цифры
    //проверка на верность ответа
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void onClickBut(View view){
        if(countDownTimer !=null){
            countDownTimer.cancel();
        }countDownTimer.cancel();
        Button chooseAn1 = (Button) findViewById(R.id.number_1);
        Button chooseAn2 = (Button) findViewById(R.id.number_2);
        Button chooseAn3 = (Button) findViewById(R.id.number_3);
        Button chooseAn4 = (Button) findViewById(R.id.number_4);
        Button t=(Button) findViewById(view.getId());
        Button tNext=(Button) findViewById(R.id.next_level);
        if(t.getText().equals(Integer.toString(array[rem]))){
           t.setBackground(getResources().getDrawable(R.drawable.right_answer));
            count++;
            if(count>max){
                max=count;
                //MainActivity.topSc.setText(""+max);
            }
            chooseAn1.setEnabled(false);
            chooseAn2.setEnabled(false);
            chooseAn3.setEnabled(false);
            chooseAn4.setEnabled(false);
            tNext.setText("NEXT");
            tNext.setVisibility(View.VISIBLE);
        }else {
            chooseAn1.setEnabled(false);
            chooseAn2.setEnabled(false);
            chooseAn3.setEnabled(false);
            chooseAn4.setEnabled(false);
            tNext.setText("AGAIN");
            tNext.setVisibility(View.VISIBLE);
            t.setBackground(getResources().getDrawable(R.drawable.wrong_answer));
            count=0;
        }

    }

    //обработчик кнопки NEXT и AGAIN
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClickNext(View view){
        Button chooseAn1 = (Button) findViewById(R.id.number_1);
        Button chooseAn2 = (Button) findViewById(R.id.number_2);
        Button chooseAn3 = (Button) findViewById(R.id.number_3);
        Button chooseAn4 = (Button) findViewById(R.id.number_4);
        chooseAn1.setEnabled(true);
        chooseAn2.setEnabled(true);
        chooseAn3.setEnabled(true);
        chooseAn4.setEnabled(true);
        view.setVisibility(View.INVISIBLE);
        chooseAn1.setBackground(getResources().getDrawable(R.drawable.choose_answer));
        chooseAn2.setBackground(getResources().getDrawable(R.drawable.choose_answer));
        chooseAn3.setBackground(getResources().getDrawable(R.drawable.choose_answer));
        chooseAn4.setBackground(getResources().getDrawable(R.drawable.choose_answer));
        start_set();
    }

}
