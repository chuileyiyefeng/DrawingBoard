package ww.free.com.drawingboard;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    MyView myView;
    Button button;
    ImageView imageView;
    int i;
    int images[]={R.drawable.jellyfish,R.drawable.koala,R.drawable.lighthouse};
    Handler handler=new Handler(new Handler.Callback() {//可以拦截handler的消息，要new Callback
        @Override
        public boolean handleMessage(Message msg) {//返回为true就不会继续执行
            return false;
        }
    }){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    MyRunnable myRunnable=new MyRunnable();
    class MyRunnable implements Runnable {
        @Override
        public void run() {
            i++;
            i=i%3;
            imageView.setImageResource(images[i]);
            handler.postDelayed(myRunnable,1000);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView= (MyView) findViewById(R.id.draw);
        button= (Button) findViewById(R.id.cancel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.clear();
            }
        });
        imageView= (ImageView) findViewById(R.id.imageview);
        handler.postDelayed(myRunnable,1000);
    }
}
