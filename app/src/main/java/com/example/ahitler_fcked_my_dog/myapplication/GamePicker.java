package com.example.ahitler_fcked_my_dog.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class GamePicker extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game_picker);
        final Button y_n_start = (Button) findViewById(R.id.yes_no_game);
        final Button ch_num = (Button) findViewById(R.id.choose_right_num);
        final Button ch_tick = (Button) findViewById(R.id.choose_right_tick);

        //функция перехода в окно с первой версией игры, по нажатию кнопки
        y_n_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GamePicker.this,GameStarts.class);
                startActivity(intent);
            }
        });
        //функция перехода в окно со второй версией игры, по нажатию кнопки
        ch_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GamePicker.this,LeveSetNumber.class);
                startActivity(intent);
            }
        });
        //функция перехода в окно с третьей версией игры, по нажатию кнопки
        ch_tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GamePicker.this,ChooseRightTicket.class);
                startActivity(intent);
            }
        });
    }

}
