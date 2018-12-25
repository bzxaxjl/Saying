package com.example.bzx.finalwork.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by bzx on 2018/11/27.
 */

public class message_fans extends BmobObject {

    private _User initiator;
    private _User acceptor;
    private String acceptor_id;

    public _User getInitiator() {
        return initiator;
    }
    public void setInitiator(_User initiator) {
        this.initiator = initiator;
    }

    public _User getAcceptor() {
        return acceptor;
    }
    public void setAcceptor(_User acceptor) {
        this.acceptor = acceptor;
    }

    public String getAcceptor_id() {
        return acceptor_id;
    }
    public void setAcceptor_id(String acceptor_id) {
        this.acceptor_id = acceptor_id;
    }

}
