package com.zlb.component.module.recommand;


import com.zlb.component.module.BaseModel;

/**
 * @author zlb
 * 首页推荐
 */
public class BaseReCommandModel extends BaseModel {

    public String ecode;
    public String emsg;
    public RecommandModel data;

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public String getEmsg() {
        return emsg;
    }

    public void setEmsg(String emsg) {
        this.emsg = emsg;
    }

    public RecommandModel getData() {
        return data;
    }

    public void setData(RecommandModel data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseReCommandModel{" +
                "ecode='" + ecode + '\'' +
                ", emsg='" + emsg + '\'' +
                ", data=" + data +
                '}';
    }
}
