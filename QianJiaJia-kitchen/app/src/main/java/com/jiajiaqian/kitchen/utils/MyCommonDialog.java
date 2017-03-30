package com.jiajiaqian.kitchen.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 自定义封装的通用对话框
 * @Date 2017-03-30 15:54
 * @email qianjiajia_2013@126.com
 */
public class MyCommonDialog {
    private Context context;
    private int customeLayoutId;
    private String dialogTitle;
    private String dialogMessage;
    private String positiveText;
    private String negativeText;

    private View dialogView;
    private OnDialogListener listener;
    //带有自定义view的构造器
    public MyCommonDialog(Context context, int customeLayoutId, String dialogTitle, String positiveText, String negativeText) {
        this.context = context;
        this.customeLayoutId = customeLayoutId;
        this.dialogTitle = dialogTitle;
        this.positiveText = positiveText;
        this.negativeText = negativeText;
        this.dialogView=View.inflate(context,customeLayoutId,null);
    }
    //不带自定义view的构造器
    public MyCommonDialog(Context context, String dialogMessage, String dialogTitle, String positiveText, String negativeText) {
        this.context = context;
        this.dialogTitle = dialogTitle;
        this.dialogMessage = dialogMessage;
        this.positiveText = positiveText;
        this.negativeText = negativeText;
    }

    public View getDialogView() {
        return dialogView;
    }

    public void setDialogView(View dialogView) {
        this.dialogView = dialogView;
    }

    public void showDialog(){
        CustomDialog.Builder dialog=new CustomDialog.Builder(context);
        dialog.setTitle(dialogTitle);//设置标题
        //注意:dialogMessage和dialogView是互斥关系也就是dialogMessage存在dialogView就不存在,dialogView不存在dialogMessage就存在
        if (dialogMessage!=null){
            Toast.makeText(context, "Kitchen即将启用电话", Toast.LENGTH_SHORT).show();
            dialog.setMessage(dialogMessage);//设置对话框内容
        }else{

            dialog.setContentView(dialogView);//设置对话框的自定义view对象
        }
        /**
         * 尽管有两个点击事件监听器,可以通过我们自定义的监听器设置一个标记变量,从而可以实现将两个点击事件合并成一个
         * 监听器OnDialogListener
         * */
        //确定意图传入positive标记值
        dialog.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
                if (listener!=null){
                    listener.dialogListener("positive",dialogView,dialogInterface,which);
                }
            }
            //取消意图传入negative标记值
        }).setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
                if (listener!=null){
                    listener.dialogListener("negative",dialogView,dialogInterface,which);
                }
            }
        }).create().show();
    }
    //注册监听器方法
    public MyCommonDialog setOnDiaLogListener(OnDialogListener listener){
        this.listener=listener;
        return this;//把当前对象返回,用于链式编程
    }
    //定义一个监听器接口
    public interface OnDialogListener{
        //customView　这个参数需要注意就是如果没有自定义view,那么它则为null
        public void dialogListener(String btnType, View customView, DialogInterface dialogInterface, int which);
    }
}