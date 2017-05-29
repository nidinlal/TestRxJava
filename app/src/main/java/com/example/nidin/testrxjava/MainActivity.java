package com.example.nidin.testrxjava;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import static android.view.GestureDetector.*;

public class MainActivity extends AppCompatActivity {

//    private static TextView textView;
    private GestureDetector mGestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mGestureDetector = new GestureDetector(this, new GestureListener());

//        Observable <GestureDetector> testObs = Observable.create(
//                new ObservableOnSubscribe<GestureDetector>() {
//                    @Override
//                    public void subscribe(@NonNull ObservableEmitter<GestureDetector> e) throws Exception {
//                        e.onNext(mGestureDetector);
//                    }
//                }
//        );

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {

        //method onTouchEvent of GestureDetector class Analyzes the given motion event
        //and if applicable triggers the appropriate callbacks on the GestureDetector.OnGestureListener supplied.
        //Returns true if the GestureDetector.OnGestureListener consumed the event, else false.

        boolean eventConsumed=mGestureDetector.onTouchEvent(event);
        if (eventConsumed)
        {
            Observable <String> myObs = Observable.create(
                    new ObservableOnSubscribe<String>() {
                        @Override
                        public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                            try {
                                e.onNext(GestureListener.message);
                            } catch (Exception er) {
                                e.onError(er);
                            }
                        }
                    }
            );

            Observer<String> mySub = new Observer<String>() {

                TextView t1 = (TextView)findViewById(R.id.textView);

                @Override
                public void onError(Throwable throwable) {
                    t1.setText("error..");
                }

                @Override
                public void onComplete() {
                    t1.setText("Completed");
                }

                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(String s) {
                    t1.setText(s);
                }

            };

            myObs.subscribe((Observer<? super String>) mySub);

            //Toast.makeText(this,GestureListener.message,Toast.LENGTH_LONG).show();
//            t1.setText(GestureListener.message);
            return true;
        }
        else
            return false;
    }
}
