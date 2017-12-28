package net.kenhlaptrinh.androidlistview.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import net.kenhlaptrinh.androidlistview.R;
import net.kenhlaptrinh.androidlistview.adapter.MainAdapter;
import net.kenhlaptrinh.androidlistview.model.NhanVat;
import net.kenhlaptrinh.androidlistview.presenter.MainPresenter;
import net.kenhlaptrinh.androidlistview.presenter.MainPresenterImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private ListView listView;

    private MainPresenter mainPresenter = null;

    private List<NhanVat> listNhanVat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        mainPresenter = new MainPresenterImpl(this);
        mainPresenter.getListItem("kenhlaptrinh.net");

        Toast toast = Toast.makeText(getApplicationContext(), "https://kenhlaptrinh.net", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

    @Override
    public void onFetchComplete(Object obj) {
        listNhanVat = (List<NhanVat>) obj;
        listView.setAdapter(new MainAdapter(getApplicationContext(), listNhanVat));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplication(), listNhanVat.get(i).getTen_nhan_vat().toUpperCase(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onFetchFailed(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

}
