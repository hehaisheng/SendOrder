package com.example.pc_.sendorder.view.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.pc_.sendorder.R;
import com.example.pc_.sendorder.view.model.DetailItem;

import java.util.List;

/**
 * Created by pc- on 2017/8/18.
 */
public class DetailAdapter extends BaseQuickAdapter<DetailItem> {
    public DetailAdapter(int layoutResId, List<DetailItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, DetailItem detailItem) {
        baseViewHolder.setText(R.id.detail_order_time,detailItem.getOrderTime())
                .setText(R.id.detail_order_content,detailItem.getOrderContent())
        .setText(R.id.detail_order_money,detailItem.getOrderMoney()+"元");

    }
}
