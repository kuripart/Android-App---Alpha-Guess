package com.kuri.alphaguessv1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{

    GestureDetector gestures;
    Bitmap[] bitArray = new Bitmap[26];
    Map<Integer,Character> alphaHolder = new HashMap<Integer, Character>();
    Character scribbleIt;
    float randomFloat;
    int random;
    float randomLengthFloat;
    int randomLength; //for random string length generation
    float scribbleRandomFloat;
    int scribbleRandom;
    int seconds;
    int alphaChooseSize;
    long scribbleTime;
    int score;
    StringBuilder alphaChoose;
    StringBuilder scribble;
    String show; //random string generated
    String showAnswer; //user guess
    String checkString;
    TextView answerText;
    TextView randomText;
    TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answerText = (TextView)findViewById(R.id.answerText);
        randomText = (TextView)findViewById(R.id.randomText);
        scoreText = (TextView)findViewById(R.id.score);
        seconds = 0;
        scribbleTime = 10000;
        score = 0;
        alphaHolder.put(0,'A');
        alphaHolder.put(1,'B');
        alphaHolder.put(2,'C');
        alphaHolder.put(3,'D');
        alphaHolder.put(4,'E');
        alphaHolder.put(5,'F');
        alphaHolder.put(6,'G');
        alphaHolder.put(7,'H');
        alphaHolder.put(8,'I');
        alphaHolder.put(9,'J');
        alphaHolder.put(10,'K');
        alphaHolder.put(11,'L');
        alphaHolder.put(12,'M');
        alphaHolder.put(13,'N');
        alphaHolder.put(14,'O');
        alphaHolder.put(15,'P');
        alphaHolder.put(16,'Q');
        alphaHolder.put(17,'R');
        alphaHolder.put(18,'S');
        alphaHolder.put(19,'T');
        alphaHolder.put(20,'U');
        alphaHolder.put(21,'V');
        alphaHolder.put(22,'W');
        alphaHolder.put(23,'X');
        alphaHolder.put(24,'Y');
        alphaHolder.put(25,'Z');
        alphaChoose = new StringBuilder();
        scribble = new StringBuilder();
        Alphabets alphas = new Alphabets(this);
        gestures = new GestureDetector(this);
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.graphics_holder);
        frameLayout.addView(alphas);
        runRandom();
        runGenerateScribble();
    }

    public class Alphabets extends View {

        public Alphabets(Context context) {
            super(context);
            bitArray[0] = BitmapFactory.decodeResource(getResources(), R.drawable.a_new); //a
            bitArray[1] = BitmapFactory.decodeResource(getResources(), R.drawable.b_new); //b
            bitArray[2] = BitmapFactory.decodeResource(getResources(), R.drawable.c_new); //c
            bitArray[3] = BitmapFactory.decodeResource(getResources(), R.drawable.d_new); //d
            bitArray[4] = BitmapFactory.decodeResource(getResources(), R.drawable.e_new); //e
            bitArray[5] = BitmapFactory.decodeResource(getResources(), R.drawable.f_new); //f
            bitArray[6] = BitmapFactory.decodeResource(getResources(), R.drawable.g_new); //g
            bitArray[7] = BitmapFactory.decodeResource(getResources(), R.drawable.h_new); //h
            bitArray[8] = BitmapFactory.decodeResource(getResources(), R.drawable.i_new); //i
            bitArray[9] = BitmapFactory.decodeResource(getResources(), R.drawable.j_new); //j
            bitArray[10] = BitmapFactory.decodeResource(getResources(), R.drawable.k_new); //k
            bitArray[11] = BitmapFactory.decodeResource(getResources(), R.drawable.l_new); //l
            bitArray[12] = BitmapFactory.decodeResource(getResources(), R.drawable.m_new); //m
            bitArray[13] = BitmapFactory.decodeResource(getResources(), R.drawable.n_new); //n
            bitArray[14] = BitmapFactory.decodeResource(getResources(), R.drawable.o_new); //o
            bitArray[15] = BitmapFactory.decodeResource(getResources(), R.drawable.p_new); //p
            bitArray[16] = BitmapFactory.decodeResource(getResources(), R.drawable.q_new); //q
            bitArray[17] = BitmapFactory.decodeResource(getResources(), R.drawable.r_new); //r
            bitArray[18] = BitmapFactory.decodeResource(getResources(), R.drawable.s_new); //s
            bitArray[19] = BitmapFactory.decodeResource(getResources(), R.drawable.t_new); //t
            bitArray[20] = BitmapFactory.decodeResource(getResources(), R.drawable.u_new); //u
            bitArray[21] = BitmapFactory.decodeResource(getResources(), R.drawable.v_new); //v
            bitArray[22] = BitmapFactory.decodeResource(getResources(), R.drawable.w_new); //w
            bitArray[23] = BitmapFactory.decodeResource(getResources(), R.drawable.x_new); //x
            bitArray[24] = BitmapFactory.decodeResource(getResources(), R.drawable.y_new); //y
            bitArray[25] = BitmapFactory.decodeResource(getResources(), R.drawable.z_new); //z
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(bitArray[random],450,190,null);
            invalidate();
        }
    }

    public void displayString(MotionEvent event, int random){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            if(random == 0){
                alphaChoose.append("A");
            }else if(random == 1){
                alphaChoose.append("B");
            }else if(random == 2){
                alphaChoose.append("C");
            }else if(random == 3){
                alphaChoose.append("D");
            }else if(random == 4){
                alphaChoose.append("E");
            }else if(random == 5){
                alphaChoose.append("F");
            }else if(random == 6){
                alphaChoose.append("G");
            }else if(random == 7){
                alphaChoose.append("H");
            }else if(random == 8){
                alphaChoose.append("I");
            }else if(random == 9){
                alphaChoose.append("J");
            }else if(random == 10){
                alphaChoose.append("K");
            }else if(random == 11){
                alphaChoose.append("L");
            }else if(random == 12){
                alphaChoose.append("M");
            }else if(random == 13){
                alphaChoose.append("N");
            }else if(random == 14){
                alphaChoose.append("O");
            }else if(random == 15){
                alphaChoose.append("P");
            }else if(random == 16){
                alphaChoose.append("Q");
            }else if(random == 17){
                alphaChoose.append("R");
            }else if(random == 18){
                alphaChoose.append("S");
            }else if(random == 19){
                alphaChoose.append("T");
            }else if(random == 20){
                alphaChoose.append("U");
            }else if(random == 21){
                alphaChoose.append("V");
            }else if(random == 22){
                alphaChoose.append("W");
            }else if(random == 23){
                alphaChoose.append("X");
            }else if(random == 24){
                alphaChoose.append("Y");
            }else{
                alphaChoose.append("Z");
            }
            showAnswer = alphaChoose.toString();
            answerText.setText(showAnswer);

        }
    }

    public void runRandom(){ //FOR RANDOM ALPHAS
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                randomFloat = (float)Math.random();
                random = (int)(randomFloat*25);
                handler.postDelayed(this,500);
            }
        });
    }

    public void runGenerateScribble(){ //FOR SCRIBBLED WORDS
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                seconds++;
                if(seconds == 2){
                    //DO NOTHING
                }
                else{
                    randomLengthFloat = (float)Math.random();
                    randomLength = (int)(randomLengthFloat*3); //random string length
                    if(randomLength == 0){
                        randomLength = 1;
                    }
                    for (int i = 0; i<randomLength; i++){
                        scribbleRandom = (int)(scribbleRandomFloat*25); //random char
                        scribbleRandomFloat = (float)Math.random();
                        scribbleIt = alphaHolder.get(scribbleRandom);
                        scribble.append(scribbleIt);
                    }
                    checkString = scribble.toString();
                    show = scribble.toString();
                    randomText.setText(show);// text will be visible till the next iteration(in this case the after the time delay)
                }
                handler.postDelayed(this,scribbleTime);
                if(seconds == 2){
                    removeScribble(randomLength);
                    seconds = 0;
                }
            }
        });
    }

    public void removeScribble(int randomLength){
        int charIndex = 0;
        while (randomLength!=0){
            scribble.deleteCharAt(charIndex);
            randomLength = scribble.length();
        }
        show = scribble.toString();
        randomText.setText(show);
    }

    public void removeAnswer(){
        alphaChooseSize = alphaChoose.length();
        int charYes = 0;
        while(alphaChooseSize != 0){
            alphaChoose.deleteCharAt(charYes);
            alphaChooseSize = alphaChoose.length();
        }
        showAnswer = alphaChoose.toString();
        answerText.setText(showAnswer);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.isButtonPressed(R.id.enter)){
            return false;
        }else{
            return gestures.onTouchEvent(event);
        }
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        displayString(e,random);
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    public void yesYesEnter(View view){
        if(showAnswer.equals(checkString)){
                score++;
                scoreText.setText("SCORE: " + Integer.toString(score));
        }
        else{
            score--;
            scoreText.setText("SCORE: " + Integer.toString(score));
        }
        removeAnswer();
    }
}

