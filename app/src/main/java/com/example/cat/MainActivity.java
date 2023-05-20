package com.example.cat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView coordinatesOut;
    private float x;
    private float y;
    private String sDown;
    private String sMove;
    private String sUp;
    private String sOut;
    private final float X_Cat=900;
    private final float Y_Cat=50;
    private final float Delta_Cat=50;
    View.OnTouchListener listener =new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            x = event.getX();
            y=event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    sDown="Нажатие."+"\n"+ "Координата Х="+x+"\n"+"Координата Y="+y;
                    sMove="";
                    sUp="";
                    sOut="";
                    if (x<(X_Cat+Delta_Cat)&&x>(X_Cat-Delta_Cat)&&y<(Y_Cat+Delta_Cat)&&y>(Y_Cat-Delta_Cat)) {
                        Toast toast= Toast.makeText(MainActivity.this, R.string.catFind, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.LEFT,(int) X_Cat-50,(int)Y_Cat-500);
                        LinearLayout toastContainer=(LinearLayout) toast.getView();
                        ImageView cat =new ImageView(getApplicationContext());
                        cat.setImageResource(R.drawable.cat2);
                        toastContainer.addView(cat,1);
                        toast.show();

                    }
                    break;
                    case MotionEvent.ACTION_MOVE:
                        sDown="";
                        sMove=""+"\n"+"Движение."+"\n"+"Координата Х="+x+"\n"+"Координата Y="+y;
                        if (x<(X_Cat+Delta_Cat)&&x>(X_Cat-Delta_Cat)&&y<(Y_Cat+Delta_Cat)&&y>(Y_Cat-Delta_Cat)) {
                            Toast toast= Toast.makeText(MainActivity.this, R.string.catFind, Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.LEFT,(int) X_Cat-50,(int)Y_Cat-600);
                            LinearLayout toastContainer=(LinearLayout) toast.getView();
                            ImageView cat =new ImageView(getApplicationContext());
                            cat.setImageResource(R.drawable.cat2);
                            toastContainer.addView(cat,1);
                            toast.show();

                        }
                        break;
                case MotionEvent.ACTION_UP:
                    sDown=""+"\n";
                    sMove=""+"\n";
                    sOut="";
                    sUp="\n"+"\n"+"Поднятие пальца."+"\n"+"Координата Х="+x+"\n"+"Координата Y="+y;

                    break;
//                case MotionEvent.ACTION_CANCEL:
//                    sDown="";
//                    sMove="";
//                    sUp="";
//                    sOut="                  Палец вне границ";
//                    break;

            }
            coordinatesOut.setText(sDown+"\n"+sMove+"\n"+sUp+sOut);
            return true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatesOut=findViewById(R.id.coordinatesOut);
        coordinatesOut.setOnTouchListener(listener);
    }
}