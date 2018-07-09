package com.bawei.yangwenkai201879;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lenovo on 2018/7/9.
 */

public class MyView extends View{
    //自定义画笔
    private Paint paint;//文字
    private Paint paintnr;//手指画笔
    private Bitmap bitmapbfg;
    private Bitmap bitmap;
    private Path path;
    private Canvas mycanvas;
    private String contents ="刮刮看咯";

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }
    //初始化
    private void init() {

        //初始化画笔
        paint = new Paint();
        paint.setAlpha(0);
        paint.setStyle(Paint.Style.STROKE);//描边
        paint.setAntiAlias(true);//抗锯齿
        paint.setStrokeWidth(20);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);

        path = new Path();

        //初始化被覆盖图层
        bitmapbfg = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background);

        ////初始化覆盖图层钱图层
        bitmap = Bitmap.createBitmap(bitmapbfg.getWidth(),bitmapbfg.getHeight(),Bitmap.Config.ARGB_8888);

        //初始化画布
        mycanvas = new Canvas(bitmap);

        // //初始化内容画笔
        paintnr = new Paint();
        paintnr.setColor(Color.WHITE);
        paintnr.setStyle(Paint.Style.STROKE);
        paintnr.setTextSize(100);
        paintnr.setStrokeWidth(20);


       mycanvas.drawColor(Color.GRAY);
       mycanvas.drawText(contents,mycanvas.getWidth()/4,mycanvas.getHeight()/2,paintnr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

       /* switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //清空画笔

                path
                path.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(),event.getY());
                break;

        }
        mycanvas.drawPath(path,paint);
        invalidate();
        return true;*/
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,null);
        canvas.drawBitmap(bitmapbfg,0,0,null);

    }
}
