package com.example.pc_.sendorder.view.database;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by pc- on 2017/8/15.
 */
@Table("OrderModel")
public class OrderModel {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    public int id;


    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    @Column("OrderContent")
    public  String orderContent;

    public String getAddressContent() {
        return addressContent;
    }

    public void setAddressContent(String addressContent) {
        this.addressContent = addressContent;
    }

    @Column("AddressContent")
    public String addressContent;

    public String getPhoneContent() {
        return phoneContent;
    }

    public void setPhoneContent(String phoneContent) {
        this.phoneContent = phoneContent;
    }

    @Column("PhoneContent")
    public String phoneContent;


    //是否有接单
    public boolean isHasTake() {
        return hasTake;
    }

    public void setHasTake(boolean hasTake) {
        this.hasTake = hasTake;
    }

    @Column("HasTake")
    public boolean  hasTake=false;


}
