package net.kenhlaptrinh.androidlistview.retrofit;

import net.kenhlaptrinh.androidlistview.model.NhanVat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by TUNG DUONG on 28/05/2017.
 */

public interface API {

    @FormUrlEncoded
    @POST("list-json-doraemon.php")
    Call<List<NhanVat>> getListItem(@Field("token") String token);

}
