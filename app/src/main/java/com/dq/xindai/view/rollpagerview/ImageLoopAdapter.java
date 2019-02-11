package com.dq.xindai.view.rollpagerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dq.xindai.R;

import java.util.List;

/**
 * Created by asus on 2018/2/2.
 */

public class ImageLoopAdapter extends LoopPagerAdapter {
    private Context mContext;
    private List<String> bannerBeans;

    private int[] image = {R.mipmap.ic_lunbo1, R.mipmap.ic_lunbo2};

    public ImageLoopAdapter(RollPagerView viewPager, Context mContext) {
        super(viewPager);
        this.mContext = mContext;
    }

    public ImageLoopAdapter(RollPagerView viewPager, Context mContext, List<String> bannerBeans) {
        super(viewPager);
        this.mContext = mContext;
        this.bannerBeans = bannerBeans;
    }

    @Override
    public View getView(ViewGroup container, int position) {

        ImageView view = new ImageView(container.getContext());
        //view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        view.setImageResource(image[position]);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        ImageUtils.loadIntoUseFitWidth(mContext,
//                "http://new.dequanhuibao.com/attachment/admin//20180410/1523342500_1640139241.jpg",
//                R.mipmap.ic_launcher,
//                view);

        return view;
    }

    @Override
    public int getRealCount() {
        return image.length;
    }
}
