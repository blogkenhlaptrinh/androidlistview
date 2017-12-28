package net.kenhlaptrinh.androidlistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.kenhlaptrinh.androidlistview.R;
import net.kenhlaptrinh.androidlistview.model.NhanVat;

import java.util.List;

/**
 * Created by TUNGDUONG on 28/12/2017.
 */

public class MainAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<NhanVat> listNhanVat = null;
    private NhanVat nhanVat = null;

    public MainAdapter(Context context, List<NhanVat> listNhanVat) {
        this.context = context;
        this.listNhanVat = listNhanVat;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if (listNhanVat != null) {
            return listNhanVat.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.item_main, viewGroup, false);
        }

        ImageView imvHinhAnh = (ImageView) view.findViewById(R.id.imvHinhAnh);
        TextView tvHoTen = (TextView) view.findViewById(R.id.tvHoTen);
        TextView tvMoTa = (TextView) view.findViewById(R.id.tvMoTa);

        nhanVat = listNhanVat.get(i);
        tvHoTen.setText(nhanVat.getTen_nhan_vat());
        tvMoTa.setText(nhanVat.getMo_ta());
        Picasso.with(context).load(nhanVat.getHinh_anh()).resize(80, 80).into(imvHinhAnh);

        return view;
    }

}
