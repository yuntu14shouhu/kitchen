package com.jiajiaqian.kitchen.ui.personal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.common.appglobal.ACache;
import com.jiajiaqian.kitchen.common.entity.microbean.UserBean;
import com.jiajiaqian.kitchen.common.utils.UserInfoUtils;
import com.jiajiaqian.kitchen.ui.LoginActivity;
import com.jiajiaqian.kitchen.ui.base.BaseFragment;
import com.jiajiaqian.kitchen.utils.CircleImageView;
import com.jiajiaqian.kitchen.utils.CustomScrollBar;
import com.jiajiaqian.kitchen.utils.CustomScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonxu on 2017/2/17.
 * 个人中心fragment
 */

public class PersonalFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout mRl;
    private CircleImageView mHeadImgIb;
    private TextView mNicknameTv;
    private TextView mNoPayNumberTv;
    private TextView mNoSendNumberTv;
    private TextView mSendNumberTv;
    private TextView mNoEvaluateTv;
    private ImageButton mInfoOrderIb;
    private ImageButton mInfoMyDataIb;
    private ImageButton mInfoAddressIb;
    private ImageButton mInfoRelationIb;
    private ImageButton mInfoSettingIb;
    private ImageView mInfoPowerIv;
    private UserBean mUserBean;
    private ACache mACache;

    private ImageView mIvOrder;
    private ImageView mIvMyData;
    private ImageView mIvAddress;
    private ImageView mIvRelation;
    private ImageView mIvSetting;

    private TextView mTvOrder;
    private TextView mTvMyData;
    private TextView mTvAddress;
    private TextView mTvRelation;
    private TextView mTvSetting;
    private TextView mTvPower;

    private CustomScrollBar mMyCustomScrollBar;
    private CustomScrollView mMyCustomScrollView;

    public static PersonalFragment newInstance() {
        return new PersonalFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_tab_personal;
    }

    @Override
    protected void initView() {
        mRl = (RelativeLayout) mRootView.findViewById(R.id.rl_personal_info_headImg);
        mHeadImgIb = (CircleImageView) mRootView.findViewById(R.id.ib_personal_info_head_img);
        mNicknameTv = (TextView) mRootView.findViewById(R.id.tv_personal_info_nickname);
        mNoPayNumberTv = (TextView) mRootView.findViewById(R.id.tv_nopay_number);
        mNoSendNumberTv = (TextView) mRootView.findViewById(R.id.tv_nosend_number);
        mSendNumberTv = (TextView) mRootView.findViewById(R.id.tv_send_number);
        mNoEvaluateTv = (TextView) mRootView.findViewById(R.id.tv_noevaluate_number);
        mInfoOrderIb = (ImageButton) mRootView.findViewById(R.id.ib_info_order);
        mInfoMyDataIb = (ImageButton) mRootView.findViewById(R.id.ib_info_mydata);
        mInfoAddressIb = (ImageButton) mRootView.findViewById(R.id.ib_info_address);
        mInfoRelationIb = (ImageButton) mRootView.findViewById(R.id.ib_info_relation);
        mInfoSettingIb = (ImageButton) mRootView.findViewById(R.id.ib_info_setting);
        mInfoPowerIv = (ImageView) mRootView.findViewById(R.id.iv_info_power);

        mIvOrder = (ImageView) mRootView.findViewById(R.id.iv_info_order);
        mIvMyData = (ImageView) mRootView.findViewById(R.id.iv_info_mydata);
        mIvAddress = (ImageView) mRootView.findViewById(R.id.iv_info_address);
        mIvRelation = (ImageView) mRootView.findViewById(R.id.iv_info_relation);
        mIvSetting = (ImageView) mRootView.findViewById(R.id.iv_info_setting);

        mTvOrder = (TextView) mRootView.findViewById(R.id.tv_info_order);
        mTvMyData = (TextView) mRootView.findViewById(R.id.tv_info_mydata);
        mTvAddress = (TextView) mRootView.findViewById(R.id.tv_info_address);
        mTvRelation = (TextView) mRootView.findViewById(R.id.tv_info_relation);
        mTvSetting = (TextView) mRootView.findViewById(R.id.tv_info_setting);
        mTvPower = (TextView) mRootView.findViewById(R.id.tv_info_power);

//        mMyCustomScrollBar = (CustomScrollBar) mRootView.findViewById(R.id.scrollBar_my1);
//        mMyCustomScrollView = (CustomScrollView) mRootView.findViewById(R.id.scrollView_my1);
//        mMyCustomScrollView.setScrollBar(mMyCustomScrollBar);

        mACache = ACache.get(this.getActivity());
    }

    @Override
    protected void initListener() {
        super.initListener();
        mInfoOrderIb.setOnClickListener(this);
        mInfoMyDataIb.setOnClickListener(this);
        mInfoAddressIb.setOnClickListener(this);
        mInfoRelationIb.setOnClickListener(this);
        mInfoSettingIb.setOnClickListener(this);

        mInfoPowerIv.setOnClickListener(this);
        mIvOrder.setOnClickListener(this);
        mIvMyData.setOnClickListener(this);
        mIvAddress.setOnClickListener(this);
        mIvRelation.setOnClickListener(this);
        mIvSetting.setOnClickListener(this);

        mTvOrder.setOnClickListener(this);
        mTvMyData.setOnClickListener(this);
        mTvAddress.setOnClickListener(this);
        mTvRelation.setOnClickListener(this);
        mTvSetting.setOnClickListener(this);
        mTvPower.setOnClickListener(this);

//        mMyCustomScrollView.setCustomScrollListener(new CustomScrollView.CustomScrollListener() {
//            @Override
//            public void onCustomScrollListener(int l, int t, int oldl, int oldt) {
//                if (t-oldt !=0){
//                    mMyCustomScrollBar.setVisibility(View.GONE);
//                }else {
//                    mMyCustomScrollBar.setVisibility(View.VISIBLE);
//                }
//            }
//        });

//        mMyCustomScrollView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()){
//                    case MotionEvent.ACTION_DOWN:
//                        // 按下屏幕的操作
//                        mMyCustomScrollView.setScrollBar(mMyCustomScrollBar);
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        // 在屏幕上移动的操作
//                        mMyCustomScrollView.setScrollBar(mMyCustomScrollBar);
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        // 离开屏幕的操作
//                        break;
//                    case (MotionEvent.ACTION_CANCEL):
//                        // 手势撤消的操作
//                        // 一般认为不能由用户主动触发。
//                        // 系统在运行到一定程度下无法继续响应你的后续动作时会产生此事件
//                        break;
//                    default:
//                        break;
//                }
//                return false;
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_info_order:
            case R.id.iv_info_order:
            case R.id.tv_info_order:
                Intent intent = new Intent(getActivity(),PersonalMyOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.ib_info_mydata:
            case R.id.iv_info_mydata:
            case R.id.tv_info_mydata:
                Intent intent1 = new Intent(getActivity(),PersonalMyDataActivity.class);
                startActivity(intent1);
                break;
            case R.id.ib_info_address:
            case R.id.iv_info_address:
            case R.id.tv_info_address:
                Intent intent2 = new Intent(getActivity(),PersonalAddressActivity.class);
                startActivity(intent2);
                break;
            case R.id.ib_info_relation:
            case R.id.iv_info_relation:
            case R.id.tv_info_relation:
                Intent intent3 = new Intent(getActivity(),PersonalRelationActivity.class);
                startActivity(intent3);
                break;
            case R.id.ib_info_setting:
            case R.id.iv_info_setting:
            case R.id.tv_info_setting:
                Intent intent4 = new Intent(getActivity(),PersonalSettingActivity.class);
                startActivity(intent4);
                break;
            case R.id.iv_info_power:
            case R.id.tv_info_power:
                //清除登陆用户信息
                UserInfoUtils.clearLoginCache(getActivity());
                //重新去切入登陆页面，方便切换账号
                Intent intent5 = new Intent();
                intent5.setClass(getActivity(), LoginActivity.class);
                intent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent5);
                break;
            default:
                break;
        }
    }

    // 遍历所有的Activity并finish,退出应用程序
    public void exitPower() {
        List<Activity> activityList = new ArrayList<>();
        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }

    @Override
    protected void initData() {

    }

    /**
     * 模糊图片
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void blur(Bitmap bkg) {
        long startMs = System.currentTimeMillis();
        float radius = 8;
        bkg = small(bkg);
        Bitmap bitmap = bkg.copy(bkg.getConfig(), true);

        final RenderScript rs = RenderScript.create(this.getActivity().getBaseContext());
        final Allocation input = Allocation.createFromBitmap(rs, bkg, Allocation.MipmapControl.MIPMAP_NONE,
                Allocation.USAGE_SCRIPT);
        final Allocation output = Allocation.createTyped(rs, input.getType());
        final ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        script.setRadius(radius);
        script.setInput(input);
        script.forEach(output);
        output.copyTo(bitmap);
        bitmap = big(bitmap);
        mRl.setBackground(new BitmapDrawable(getResources(), bitmap));
        rs.destroy();
    }

    /**
     * 放大图片
     */
    private static Bitmap big(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return resizeBmp;
    }

    /**
     * 缩小图片
     */
    private static Bitmap small(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(0.25f, 0.25f);
        Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return resizeBmp;
    }


}
