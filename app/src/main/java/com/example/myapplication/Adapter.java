package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Adapter extends PagerAdapter {
    private int[] images={R.drawable.one,R.drawable.b,R.drawable.c,
            R.drawable.d,R.drawable.e,
            R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,
            R.drawable.a,R.drawable.j};
    private LayoutInflater inflater;
    private Context context;
    public Adapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return images.length;
    }
    @Override
    public boolean isViewFromObject(View view,Object object){
        return view==((LinearLayout) object);
    }


    public Object instantiateItem(ViewGroup container, int position){
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v =inflater.inflate(R.layout.slider,container,false);
        ImageView imageView=(ImageView) v.findViewById(R.id.imageView);
        TextView textView=(TextView) v.findViewById(R.id.textView);
        imageView.setImageResource(images[position]);
        textView.setText((position+1)+"번째 이미지 입니다");
        container.addView(v);
        return v;

}
    @Override
    public void destroyItem(ViewGroup container,int position,Object object ){
        container.invalidate();
    }


}
