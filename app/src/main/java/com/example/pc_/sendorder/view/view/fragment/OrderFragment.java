package com.example.pc_.sendorder.view.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pc_.sendorder.R;
import com.example.pc_.sendorder.view.database.OrderModel;
import com.example.pc_.sendorder.view.view.adapter.OrderAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by pc- on 2017/8/13.
 */
public class OrderFragment extends BaseFragment {


    @BindView(R.id.order_recycler)
    RecyclerView orderRecycler;


    public OrderAdapter orderAdapter;
    public OrderModel orderModel;
    public List<OrderModel> orderModelList=new ArrayList<>();


    @Override
    public void rxPreLoad() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.order_fragment;
    }

    @Override
    public void initView() {

        orderRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void initData() {

        for(int i=0;i<10;i++){
            OrderModel orderModel=new OrderModel();
            orderModel.setOrderContent("华辉肠粉 猪肉半斤");
            orderModel.setAddressContent("晓港5号904");
            orderModel.setPhoneContent("15634218432");
            orderModelList.add(orderModel);
        }
        orderAdapter=new OrderAdapter(getActivity(),R.layout.order_item,orderModelList);
        orderRecycler.setAdapter(orderAdapter);
    }

    @Override
    public void initEvent() {

    }


}
