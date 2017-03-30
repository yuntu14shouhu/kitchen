package com.jiajiaqian.kitchen.ui.personal;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.utils.MyCommonDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianjiajia
 * @version 1.0
 * @Date 2017-03-09 9:06
 * @Description 联系客服类
 */
public class PersonalRelationActivity extends BaseActivity {

    private TextView topBarBack;
    private TextView topBartitle;
    private TextView relation_a;
    private TextView relation_aa;
    private TextView relation_b;
    private TextView relation_bb;
    private TextView relation_c;
    private TextView relation_cc;
    private TextView relation_d;
    private TextView relation_dd;
    private TextView relation_e;
    private TextView relation_ee;
    private TextView relation_f;
    private TextView relation_ff;
    private TextView relation_g;
    private TextView relation_gg;
    private TextView relation_h;
    private TextView relation_hh;
    private TextView relation_i;
    private TextView relation_ii;
    private TextView relation_j;
    private TextView relation_jj;

    private ImageView ivDown_a;
    private ImageView ivDown_b;
    private ImageView ivDown_c;
    private ImageView ivDown_d;
    private ImageView ivDown_e;
    private ImageView ivDown_f;
    private ImageView ivDown_g;
    private ImageView ivDown_h;
    private ImageView ivDown_i;
    private ImageView ivDown_j;
    private boolean isSelected = false;

    private List<Boolean> saveState = new ArrayList<>();

    private Button btnCallRelation;
//    控件隐藏： 如textview（mTv）--- mTv.setVisibility(View.GONE );
//    里面放View.VISIBLE就是显示


    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_info_relation;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        topBarBack = (TextView) findViewById(R.id.top_bar_back);
        topBartitle = (TextView) findViewById(R.id.top_bar_title);
        topBartitle.setText("客服与帮助");
        relation_a = (TextView) findViewById(R.id.tv_relation_a);
        relation_aa = (TextView) findViewById(R.id.tv_relation_aa);
        relation_b = (TextView) findViewById(R.id.tv_relation_b);
        relation_bb = (TextView) findViewById(R.id.tv_relation_bb);
        relation_c = (TextView) findViewById(R.id.tv_relation_c);
        relation_cc = (TextView) findViewById(R.id.tv_relation_cc);
        relation_d = (TextView) findViewById(R.id.tv_relation_d);
        relation_dd = (TextView) findViewById(R.id.tv_relation_dd);
        relation_e = (TextView) findViewById(R.id.tv_relation_e);
        relation_ee = (TextView) findViewById(R.id.tv_relation_ee);
        relation_f = (TextView) findViewById(R.id.tv_relation_f);
        relation_ff = (TextView) findViewById(R.id.tv_relation_ff);
        relation_g = (TextView) findViewById(R.id.tv_relation_g);
        relation_gg = (TextView) findViewById(R.id.tv_relation_gg);
        relation_h = (TextView) findViewById(R.id.tv_relation_h);
        relation_hh = (TextView) findViewById(R.id.tv_relation_hh);
        relation_i = (TextView) findViewById(R.id.tv_relation_i);
        relation_ii = (TextView) findViewById(R.id.tv_relation_ii);
        relation_j = (TextView) findViewById(R.id.tv_relation_j);
        relation_jj = (TextView) findViewById(R.id.tv_relation_jj);

        ivDown_a = (ImageView) findViewById(R.id.iv_relation_a);
        ivDown_b = (ImageView) findViewById(R.id.iv_relation_b);
        ivDown_c = (ImageView) findViewById(R.id.iv_relation_c);
        ivDown_d = (ImageView) findViewById(R.id.iv_relation_d);
        ivDown_e = (ImageView) findViewById(R.id.iv_relation_e);
        ivDown_f = (ImageView) findViewById(R.id.iv_relation_f);
        ivDown_g = (ImageView) findViewById(R.id.iv_relation_g);
        ivDown_h = (ImageView) findViewById(R.id.iv_relation_h);
        ivDown_i = (ImageView) findViewById(R.id.iv_relation_i);
        ivDown_j = (ImageView) findViewById(R.id.iv_relation_j);

        btnCallRelation = (Button) findViewById(R.id.bt_relation_phone);
    }

    @Override
    public void initEvent() {
        topBarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        relation_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelected) {
                    relation_aa.setVisibility(View.VISIBLE);
                    ivDown_a.setImageResource(R.drawable.ic_relation_up);
                    isSelected = true;
                } else {
                    relation_aa.setVisibility(View.GONE);
                    ivDown_a.setImageResource(R.drawable.ic_relation_down);
                    isSelected = false;
                }
            }
        });

        relation_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelected) {
                    relation_bb.setVisibility(View.VISIBLE);
                    ivDown_b.setImageResource(R.drawable.ic_relation_up);
                    isSelected = true;
                } else {
                    relation_bb.setVisibility(View.GONE);
                    ivDown_b.setImageResource(R.drawable.ic_relation_down);
                    isSelected = false;
                }
            }
        });

        relation_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelected) {
                    relation_cc.setVisibility(View.VISIBLE);
                    ivDown_c.setImageResource(R.drawable.ic_relation_up);
                    isSelected = true;
                } else {
                    relation_cc.setVisibility(View.GONE);
                    ivDown_c.setImageResource(R.drawable.ic_relation_down);
                    isSelected = false;
                }
            }
        });
        relation_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelected) {
                    relation_dd.setVisibility(View.VISIBLE);
                    ivDown_d.setImageResource(R.drawable.ic_relation_up);
                    isSelected = true;
                } else {
                    relation_dd.setVisibility(View.GONE);
                    ivDown_d.setImageResource(R.drawable.ic_relation_down);
                    isSelected = false;
                }
            }
        });

        relation_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelected) {
                    relation_ee.setVisibility(View.VISIBLE);
                    ivDown_e.setImageResource(R.drawable.ic_relation_up);
                    isSelected = true;
                } else {
                    relation_ee.setVisibility(View.GONE);
                    ivDown_e.setImageResource(R.drawable.ic_relation_down);
                    isSelected = false;
                }
            }
        });

        relation_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelected) {
                    relation_ff.setVisibility(View.VISIBLE);
                    ivDown_f.setImageResource(R.drawable.ic_relation_up);
                    isSelected = true;
                } else {
                    relation_ff.setVisibility(View.GONE);
                    ivDown_f.setImageResource(R.drawable.ic_relation_down);
                    isSelected = false;
                }
            }
        });

        relation_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelected) {
                    relation_gg.setVisibility(View.VISIBLE);
                    ivDown_g.setImageResource(R.drawable.ic_relation_up);
                    isSelected = true;
                } else {
                    relation_gg.setVisibility(View.GONE);
                    ivDown_g.setImageResource(R.drawable.ic_relation_down);
                    isSelected = false;
                }
            }
        });

        relation_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelected) {
                    relation_hh.setVisibility(View.VISIBLE);
                    ivDown_h.setImageResource(R.drawable.ic_relation_up);
                    isSelected = true;
                } else {
                    relation_hh.setVisibility(View.GONE);
                    ivDown_h.setImageResource(R.drawable.ic_relation_down);
                    isSelected = false;
                }
            }
        });

        relation_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelected) {
                    relation_ii.setVisibility(View.VISIBLE);
                    ivDown_i.setImageResource(R.drawable.ic_relation_up);
                    isSelected = true;
                } else {
                    relation_ii.setVisibility(View.GONE);
                    ivDown_i.setImageResource(R.drawable.ic_relation_down);
                    isSelected = false;
                }
            }
        });

        relation_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelected) {
                    relation_jj.setVisibility(View.VISIBLE);
                    ivDown_j.setImageResource(R.drawable.ic_relation_up);
                    isSelected = true;
                } else {
                    relation_jj.setVisibility(View.GONE);
                    ivDown_j.setImageResource(R.drawable.ic_relation_down);
                    isSelected = false;
                }
            }
        });

        btnCallRelation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                showNormalDialog();//系统自带dialog
                dialog();//自定义dialog
            }
        });
    }

    public void dialog(){
        new MyCommonDialog(this,"184" +
                "-8217-3219","联系客服","确定","取消")
                .setOnDiaLogListener(new MyCommonDialog.OnDialogListener() {
                    @Override
                    public void dialogListener(String btnType, View customView, DialogInterface dialogInterface, int which) {
                        switch (btnType){
                            case "positive":
                                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:400-123-4567"));
                                if (ActivityCompat.checkSelfPermission(PersonalRelationActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    return;
                                }
                                startActivity(intent);
                                break;
                            case "negative":
                                break;
                        }
                    }
                }).showDialog();
    }


    /**
     * 系统自带dialog
     */
//    private void showNormalDialog() {
//
//        /**
//         *@setIcon 设置对话框图标
//         * @setTitle 设置对话框标题
//         * @setMessage 设置对话框消息提示
//         * setXXX方法返回Dialog对象，因此可以链式设置属性
//         */
//        final AlertDialog.Builder normalDialog =
//                new AlertDialog.Builder(PersonalRelationActivity.this);
//        normalDialog.setIcon(R.drawable.ic_logo);
//        normalDialog.setTitle("联系Kitchen客服");
//        normalDialog.setMessage("\t\t\t\t400-123-4567");
//
//        normalDialog.setPositiveButton("确定",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:400-123-4567"));
//                if (ActivityCompat.checkSelfPermission(PersonalRelationActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                    // TODO: Consider calling
//                    //    ActivityCompat#requestPermissions
//                    // here to request the missing permissions, and then overriding
//                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                    //                                          int[] grantResults)
//                    // to handle the case where the user grants the permission. See the documentation
//                    // for ActivityCompat#requestPermissions for more details.
//                    return;
//                }
//                startActivity(intent);
//                    }
//                });
//        normalDialog.setNegativeButton("关闭",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //...To-do
//                    }
//                });
//        // 显示
//        normalDialog.show();
//    }

}