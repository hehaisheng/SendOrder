package com.example.pc_.sendorder.view.view.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pc_.sendorder.R;
import com.example.pc_.sendorder.view.database.OrderModel;
import com.example.pc_.sendorder.view.utils.AutoSplit;

import java.util.List;

/**
 * Created by pc- on 2017/8/15.
 */
public class OrderAdapter extends BaseQuickAdapter<OrderModel> {

    public static final int REQUEST_PHONE_CODE = 20;

    public Context context;

    public OrderAdapter(int layoutResId, List<OrderModel> data) {
        super(layoutResId, data);
    }


    public OrderAdapter(Context context, int layoutResId, List<OrderModel> data) {
        this(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, OrderModel orderModel) {
        baseViewHolder.setText(R.id.order_address_detail_text, AutoSplit.autoSplit(orderModel.getOrderContent()))
                .setText(R.id.order_address_detail_text, orderModel.getAddressContent())
                .setText(R.id.order_phone_detail_text, orderModel.getPhoneContent());

        final String phoneString=orderModel.getPhoneContent();
        baseViewHolder.getView(R.id.order_phone_detail_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(context,"请许可拨打订单用户电话",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phoneString));
                    context.startActivity(intent);
                }

            }
        });
    }


}
