package com.mvgx.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Arthur
 * @Date 2023/03/27 14:17
 */
public class UserEntity implements Serializable {


    /**
     * uid : 2811
     * sub : uob_admin@mvgx.com
     * code : B00011010001
     * fullName : uob adminx
     * pid : 10000552
     * t2fa : 0
     * exp : 1679988672
     * iat : 1679981472
     * rol : ["PRIVILEGE_CAMPV2_LOGIN","PRIVILEGE_CAMPV2_CLIENT_NOKYC_C","PRIVILEGE_CAMPV2_OTC_BASIC_OD_C","PRIVILEGE_CAMPV2_HOME_MENU","PRIVILEGE_CAMPV2_COMMISSION_MENU","PRIVILEGE_CAMPV2_UM_MENU","PRIVILEGE_CAMPV2_WITHDRAW_MENU","PRIVILEGE_CAMPV2_DEPOSIT_MENU","PRIVILEGE_CAMPV2_SETTLEMENT_MENU","PRIVILEGE_CAMPV2_ST_MENU","PRIVILEGE_CAMPV2_OTC_MENU","PRIVILEGE_CAMPV2_TPP_MENU","PRIVILEGE_CAMPV2_CLIENT_MENU","ROLE_CAMP_UOB_ENTERPRISES_ADMIN_ROLE","ROLE_CAMP_company_UOB"]
     */

    private int uid;
    private String sub;
    private String code;
    private String fullName;
    private int pid;
    private int t2fa;
    private int exp;
    private int iat;
    private List<String> rol;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getSub() {
        return sub == null ? "" : sub;
    }

    public void setSub(String sub) {
        this.sub = sub == null ? "" : sub;
    }

    public String getCode() {
        return code == null ? "" : code;
    }

    public void setCode(String code) {
        this.code = code == null ? "" : code;
    }

    public String getFullName() {
        return fullName == null ? "" : fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? "" : fullName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getT2fa() {
        return t2fa;
    }

    public void setT2fa(int t2fa) {
        this.t2fa = t2fa;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getIat() {
        return iat;
    }

    public void setIat(int iat) {
        this.iat = iat;
    }

    public List<String> getRol() {
        if (rol == null) {
            return new ArrayList<>();
        }
        return rol;
    }

    public void setRol(List<String> rol) {
        this.rol = rol;
    }
}
