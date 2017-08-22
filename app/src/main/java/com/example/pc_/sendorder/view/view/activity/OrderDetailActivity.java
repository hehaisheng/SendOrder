package com.example.pc_.sendorder.view.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.pc_.sendorder.R;
import com.example.pc_.sendorder.view.model.DetailItem;
import com.example.pc_.sendorder.view.view.adapter.DetailAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by pc- on 2017/8/18.
 */
public class OrderDetailActivity extends BaseActivity {
    @BindView(R.id.detail_title)
    TextView detailTitle;
    @BindView(R.id.detail_recycler)
    RecyclerView detailRecycler;

    public List<DetailItem> detailItemList=new ArrayList<>();

    public int allMoney=0;

    public DetailAdapter detailAdapter;

    @Override
    public int getLayout() {
        return R.layout.detail_activity;
    }

    @Override
    public void initView() {

        detailRecycler.setLayoutManager(new LinearLayoutManager(this));
        for(int i=0;i<15;i++){
            DetailItem detailItem=new DetailItem();
            detailItem.setOrderTime("订单时间:"+System.currentTimeMillis());
            detailItem.setOrderContent("华辉肠粉....猪肉半斤"+i);
            detailItem.setOrderMoney(i);
            detailItemList.add(detailItem);
            allMoney+=i;
        }

        detailTitle.setText("今日收入:"+allMoney);
        detailAdapter=new DetailAdapter(R.layout.detail_item,detailItemList);
        detailRecycler.setAdapter(detailAdapter);

    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }


}
