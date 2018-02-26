package com.example.ahitler_fcked_my_dog.myapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class ChooseRightTicket extends Activity {
    Random rand = new Random();
    int count=0,pseudoRandom,max=0;
    int[] array=new int[6];
    private ProgressBar progbar;
    private TextView progCount;
    private View img_background;
    private View img_background_2;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_choose_right_ticket);
        progbar=(ProgressBar) findViewById(R.id.progressBar);
        progCount=(TextView) findViewById(R.id.progressCount);
        img_background = findViewById(R.id.back_tikcet_ch);
        img_background_2 = findViewById(R.id.back_tikcet_ch_2);
        /*AlertDialog.Builder start_dialog = new AlertDialog.Builder(this);
        start_dialog.setMessage("Lets START????")
                .setCancelable(false)
                .setPositiveButton("START", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        start();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        start();
                    }
                });
        AlertDialog alertDialog=start_dialog.create();
        alertDialog.setTitle("ALERT");
        alertDialog.show();*/
        start();
    }

    //функция начала игры
    public void start() {

        final Button button_left=(Button) findViewById(R.id.button_pick_1);
        final Button button_right=(Button) findViewById(R.id.button_pick_2);
        final Button button_next=(Button) findViewById(R.id.next_level);

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
                button_left.setEnabled(false);
                button_right.setEnabled(false);
                button_next.setText("AGAIN");
                button_next.setVisibility(View.VISIBLE);
            }
        }.start();
        //рандомно появляются билеты, с каждым раундом разные виды
        pseudoRandom=rand.nextInt(5);
        if(pseudoRandom==0){
            img_background.setBackgroundResource(R.drawable.violet_250);
            img_background_2.setBackgroundResource(R.drawable.violet_250);
        }else if(pseudoRandom==1){
            img_background.setBackgroundResource(R.drawable.blue_250);
            img_background_2.setBackgroundResource(R.drawable.blue_250);
        }else if(pseudoRandom==2){
            img_background.setBackgroundResource(R.drawable.blue_bus_250);
            img_background_2.setBackgroundResource(R.drawable.blue_bus_250);
        }else if(pseudoRandom==3){
            img_background.setBackgroundResource(R.drawable.red_250);
            img_background_2.setBackgroundResource(R.drawable.red_250);
        }else if(pseudoRandom==4){
            img_background.setBackgroundResource(R.drawable.roz_250);
            img_background_2.setBackgroundResource(R.drawable.roz_250);
        }

        TextView t = (TextView) findViewById(R.id.txt);
        t.setText("" + rand.nextInt(10) + " " + rand.nextInt(10) + " " + rand.nextInt(10) + " " + rand.nextInt(10) + " " + rand.nextInt(10) + " " + rand.nextInt(10));
        TextView t2 = (TextView) findViewById(R.id.txt2);
        t2.setText("" + rand.nextInt(10) + " " + rand.nextInt(10) + " " + rand.nextInt(10) + " " + rand.nextInt(10) + " " + rand.nextInt(10) + " " + rand.nextInt(10));

        //генерация номеров билетов
        pseudoRandom = rand.nextInt(2);
        if (pseudoRandom == 0) {
            int gotIt = 0;
        //100% генерация счастливого билета
            while (gotIt != 1) {
                for (int i = 0; i < 6; i++) {
                    array[i] = rand.nextInt(10);
                }
                int sum = array[0] + array[1] + array[2];
                int sum2 = array[3] + array[4] + array[5];

                if (sum == sum2) gotIt = 1;
            }
            t.setText(""+ array[0]+ " "+ array[1]+ " "+ array[2]+ " "+ array[3]+ " "+ array[4]+ " "+ array[5]);
        } else {
            int gotIt = 0;
        //100% генерация счастливого билета
            while (gotIt != 1) {
                for (int i = 0; i < 6; i++) {
                    array[i] = rand.nextInt(10);
                }
                int sum = array[0] + array[1] + array[2];
                int sum2 = array[3] + array[4] + array[5];

                if (sum == sum2) gotIt = 1;
            }
            t2.setText(""+ array[0]+ " "+ array[1]+ " "+ array[2]+ " "+ array[3]+ " "+ array[4]+ " "+ array[5]);
        }
        TextView t1 = (TextView) findViewById(R.id.Count);
        t1.setText("" + count);


        //обработчик нажатия левой кнопки выбора билета
        button_left.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if(countDownTimer !=null){
                    countDownTimer.cancel();
                }countDownTimer.cancel();
                if(pseudoRandom==0) {

                        v.setBackground(getResources().getDrawable(R.drawable.right_answer));
                        count++;
                        if(count>max){
                            max=count;
                            //MainActivity.topSc.setText(""+max);
                        }
                        button_left.setEnabled(false);
                        button_right.setEnabled(false);
                        button_next.setText("NEXT");
                        button_next.setVisibility(View.VISIBLE);
                    } else {
                        v.setBackground(getResources().getDrawable(R.drawable.wrong_answer));
                        count = 0;
                        button_left.setEnabled(false);
                        button_right.setEnabled(false);
                        button_next.setText("AGAIN");
                        button_next.setVisibility(View.VISIBLE);
                    }
            }
        });
        //обработчик нажатия правой кнопки выбора билета
        button_right.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if(countDownTimer !=null){
                    countDownTimer.cancel();
                }countDownTimer.cancel();
                if(pseudoRandom!=0) {

                    v.setBackground(getResources().getDrawable(R.drawable.right_answer));
                    count++;
                    if(count>max){
                        max=count;
                        //MainActivity.topSc.setText(""+max);
                    }
                    button_left.setEnabled(false);
                    button_right.setEnabled(false);
                    button_next.setText("NEXT");
                    button_next.setVisibility(View.VISIBLE);
                } else {
                    v.setBackground(getResources().getDrawable(R.drawable.wrong_answer));
                    count = 0;
                    button_left.setEnabled(false);
                    button_right.setEnabled(false);
                    button_next.setText("AGAIN");
                    button_next.setVisibility(View.VISIBLE);
                }
            }
        });
        //обработчик нажатия кнопки NEXT или AGAIN
        button_next.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                button_left.setEnabled(true);
                button_right.setEnabled(true);

                v.setVisibility(View.INVISIBLE);
                button_left.setBackground(getResources().getDrawable(R.drawable.choose_answer));
                button_right.setBackground(getResources().getDrawable(R.drawable.choose_answer));


                start();
            }
        });
    }
}
