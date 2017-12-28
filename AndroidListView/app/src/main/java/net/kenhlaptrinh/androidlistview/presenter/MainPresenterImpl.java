package net.kenhlaptrinh.androidlistview.presenter;

import net.kenhlaptrinh.androidlistview.model.NhanVat;
import net.kenhlaptrinh.androidlistview.retrofit.ApiClient;
import net.kenhlaptrinh.androidlistview.view.MainView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TUNGDUONG on 28/12/2017.
 */

public class MainPresenterImpl implements MainPresenter{

    private MainView mainView= null;
    private ApiClient apiClient = null;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        this.apiClient = new ApiClient();
    }

    @Override
    public void getListItem(String token) {
        Call<List<NhanVat>> call = apiClient.getClient().getListItem(token);
        call.enqueue(new Callback<List<NhanVat>>() {
            @Override
            public void onResponse(Call<List<NhanVat>> call, Response<List<NhanVat>> response) {
                if (response.body() != null) {
                    mainView.onFetchComplete(response.body());
                } else {
                    mainView.onFetchFailed(null);
                }
            }

            @Override
            public void onFailure(Call<List<NhanVat>> call, Throwable t) {
                mainView.onFetchFailed(t.getMessage().toString());
            }
        });
    }

}
