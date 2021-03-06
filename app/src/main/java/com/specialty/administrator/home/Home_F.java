package com.specialty.administrator.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.specialty.administrator.abView.AbSlidingPlayView;
import com.specialty.administrator.classify.Classification;
import com.specialty.administrator.specialty.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static com.specialty.administrator.specialty.R.id.tv_home_customerService;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_F extends Fragment implements View.OnClickListener {
    /*首页轮播 */
    private AbSlidingPlayView viewPager;
    /*首页轮播的界面的资源*/
    private int[] resid = {R.drawable.carousel, R.drawable.carousel1, R.drawable.carousel2};
    /*存储首页轮播的界面*/
    private ArrayList<View> allListView;
    private ViewFlipper mVf_notice;
    private int mCurrPos = 0;
    private ArrayList<String> hAnnounList = new ArrayList<>();
    private TextView[] tv_menu = new TextView[4];
    private int[] tv_menu_id = {R.id.tv_home_charge, R.id.tv_home_trade, R.id.tv_home_help, tv_home_customerService};
    private ImageView[] im_view = new ImageView[8];
    private int[] im_view_id = {R.id.Recommend_1, R.id.Recommend_2, R.id.Recommend_3, R.id.Recommend_4, R.id.Recommend_5, R.id.Recommend_6, R.id.Recommend_7, R.id.Recommend_8};

    public Home_F() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.home_f, container, false);
        initView(rootView);
        initData();
        return rootView;

    }

    private void initView(View view) {
        viewPager = view.findViewById(R.id.viewPager_menu);
        //设置播放方式为顺序播放
        viewPager.setPlayType(1);
        //设置播放间隔时间
        viewPager.setSleepTime(3000);
        initViewPager();
        initViewFlipper();
        mVf_notice = view.findViewById(R.id.home_notice_vf);
        for (int i = 0; i < tv_menu.length; i++) {
            tv_menu[i] = view.findViewById(tv_menu_id[i]);
            tv_menu[i].setOnClickListener(this);
        }
        for (int j = 0; j < im_view.length; j++) {
            im_view[j] = view.findViewById(im_view_id[j]);
            im_view[j].setOnClickListener(this);
        }

    }

    private void initViewPager() {

        if (allListView != null) {
            allListView.clear();
            allListView = null;
        }
        allListView = new ArrayList<>();

        for (int i = 0; i < resid.length; i++) {
            //导入ViewPager的布局
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_sildepic_item, null);
            ImageView imageView = (view.findViewById(R.id.pic_item));
            imageView.setImageResource(resid[i]);
            allListView.add(view);
        }
        viewPager.addViews(allListView);
        //开始轮播
        viewPager.startPlay();
    }

    private void initData() {
        hAnnounList.add("首页测试公告1");
        hAnnounList.add("首页测试公告2");
        hAnnounList.add("首页测试公告3");
    }

    /**
     * 初始化滚动公告
     */
    private void initViewFlipper() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Home_F.this.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        moveNext();
                    }
                });

            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, 4000);
    }

    /**
     * 滚动公告的下一条功能
     */
    private void moveNext() {
        setView(this.mCurrPos, this.mCurrPos + 1);
        this.mVf_notice.setInAnimation(this.getActivity(), R.anim.in_bottomtop);
        this.mVf_notice.setOutAnimation(this.getActivity(), R.anim.out_topbottom);
        this.mVf_notice.showNext();
    }

    private void setView(int curr, int next) {

        View noticeView = getActivity().getLayoutInflater().inflate(R.layout.home_sildenotice_item, null);
        TextView tv_notice = (TextView) noticeView.findViewById(R.id.tv_announce);
        if ((curr < next) && (next > (hAnnounList.size() - 1))) {
            next = 0;
        } else if ((curr > next) && (next < 0)) {
            next = hAnnounList.size() - 1;
        }
        String title = "";
        try {
            title = hAnnounList.get(next).toString();
        } catch (Exception e) {
        }
        tv_notice.setText(title);
        // tv_notice.setOnClickListener(new OnClickListener() {
        //
        // @Override
        // public void onClick(View arg0) {
        // // tiao_ 跳转到公告详情页面
        //
        // Intent intent = new Intent(getActivity(), ShowMessage.class);
        // Bundle bundle = new Bundle();
        // String href = "";
        // try {
        // href = hAnnounList.get(mCurrPos).get(params_annou[1]).toString();
        // } catch (Exception e) {
        // }
        // bundle.putString("href", href);
        // intent.putExtras(bundle);
        // startActivity(intent);
        // }
        // });
        if (mVf_notice.getChildCount() > 1) {
            mVf_notice.removeViewAt(0);
        }
        mVf_notice.addView(noticeView, mVf_notice.getChildCount());
        mCurrPos = next;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_home_charge:
                if (getActivity() instanceof HeadPageCallback) {
                    ((HeadPageCallback) getActivity()).HeadPageBtnCall(tv_menu[0]);
                }
                break;
            case R.id.tv_home_trade:
                if (getActivity() instanceof HeadPageCallback) {
                    ((HeadPageCallback) getActivity()).HeadPageBtnCall(tv_menu[1]);
                }
                break;
            case R.id.tv_home_help:
                if (getActivity() instanceof HeadPageCallback) {
                    ((HeadPageCallback) getActivity()).HeadPageBtnCall(tv_menu[2]);
                }
                break;
            case R.id.tv_home_customerService:
                if (getActivity() instanceof HeadPageCallback) {
                    ((HeadPageCallback) getActivity()).HeadPageBtnCall(tv_menu[3]);
                }
                break;
            case R.id.Recommend_1:
                Intent intent = new Intent(Home_F.this.getActivity(), Classification.class);
                startActivity(intent);
                break;
            case R.id.Recommend_2:
                Intent intent2 = new Intent(Home_F.this.getActivity(), Classification.class);
                startActivity(intent2);
                break;
            case R.id.Recommend_3:
                Intent intent3 = new Intent(Home_F.this.getActivity(), Classification.class);
                startActivity(intent3);
                break;
            case R.id.Recommend_4:
                Intent intent4 = new Intent(Home_F.this.getActivity(), Classification.class);
                startActivity(intent4);
                break;
            case R.id.Recommend_5:
                Intent intent5 = new Intent(Home_F.this.getActivity(), Classification.class);
                startActivity(intent5);
                break;
            case R.id.Recommend_6:
                Intent intent6 = new Intent(Home_F.this.getActivity(), Classification.class);
                startActivity(intent6);
                break;
            case R.id.Recommend_7:
                Intent intent7 = new Intent(Home_F.this.getActivity(), Classification.class);
                startActivity(intent7);
                break;
            case R.id.Recommend_8:
                Intent intent8 = new Intent(Home_F.this.getActivity(), Classification.class);
                startActivity(intent8);
                break;
            default:
                break;
        }
    }
}
