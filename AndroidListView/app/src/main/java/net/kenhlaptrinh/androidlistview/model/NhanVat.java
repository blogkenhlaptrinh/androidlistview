package net.kenhlaptrinh.androidlistview.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TUNGDUONG on 28/12/2017.
 */

public class NhanVat {

    @SerializedName("id_nhan_vat")
    private int id_nhan_vat;
    @SerializedName("ten_nhan_vat")
    private String ten_nhan_vat;
    @SerializedName("mo_ta")
    private String mo_ta;
    @SerializedName("hinh_anh")
    private String hinh_anh;

    public int getId_nhan_vat() {
        return id_nhan_vat;
    }

    public void setId_nhan_vat(int id_nhan_vat) {
        this.id_nhan_vat = id_nhan_vat;
    }

    public String getTen_nhan_vat() {
        return ten_nhan_vat;
    }

    public void setTen_nhan_vat(String ten_nhan_vat) {
        this.ten_nhan_vat = ten_nhan_vat;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public String getHinh_anh() {
        return hinh_anh;
    }

    public void setHinh_anh(String hinh_anh) {
        this.hinh_anh = hinh_anh;
    }
}
