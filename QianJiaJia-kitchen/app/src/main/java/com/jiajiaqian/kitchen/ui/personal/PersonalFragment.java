package com.jiajiaqian.kitchen.ui.personal;

import android.annotation.TargetApi;
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
import com.jiajiaqian.kitchen.ui.base.BaseFragment;
import com.jiajiaqian.kitchen.utils.CircleImageView;

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
    private ImageView mInfoSettingIv;
    private ImageView mInfoPowerIv;
    private UserBean mUserBean;
    private ACache mACache;

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
        mInfoSettingIv = (ImageView) mRootView.findViewById(R.id.iv_info_power);
        mInfoPowerIv = (ImageView) mRootView.findViewById(R.id.iv_info_power);

        mACache = ACache.get(this.getActivity());
    }

    @Override
    protected void initListener() {
        super.initListener();
        mInfoOrderIb.setOnClickListener(this);
        mInfoMyDataIb.setOnClickListener(this);
        mInfoAddressIb.setOnClickListener(this);
        mInfoRelationIb.setOnClickListener(this);
        mInfoSettingIv.setOnClickListener(this);
        mInfoPowerIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_info_order:
                Intent intent = new Intent();
                intent.setClass(getActivity(),PersonalMyOrderFragment.class);
            case R.id.ib_info_mydata:
                Intent intent1 = new Intent();
                intent1.setClass(getActivity(),PersonalMyDataFragment.class);
            case R.id.ib_info_address:
                Intent intent2 = new Intent();
                intent2.setClass(getActivity(),PersonalAddressFragment.class);
            case R.id.ib_info_relation:
                Intent intent3 = new Intent();
                intent3.setClass(getActivity(),PersonalRelationFragment.class);
            case R.id.iv_info_setting:
                Intent intent4 = new Intent();
                intent4.setClass(getActivity(),PersonalSettingFragment.class);
            case R.id.iv_info_power:
                getActivity().finish();
//                Intent intent5 = new Intent();
//                intent5.setClass(getActivity(),PersonalPowerFragment.class);
                break;
            default:
                break;
        }
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
