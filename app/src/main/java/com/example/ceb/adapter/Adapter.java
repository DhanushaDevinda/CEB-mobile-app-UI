package com.example.ceb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ceb.Model.AccessByCensuModel;
import com.example.ceb.R;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {


    private List<AccessByCensuModel> modelList;

    public Adapter(List<AccessByCensuModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.accessby_cen_layout, viewGroup, false);
        return new Viewholder(view);





    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {

        String id = modelList.get(position).get_id();;
        String device = modelList.get(position).getDevice();
        String qty  = modelList.get(position).getQty();
        String hours = modelList.get(position).getHours();
        String power  = modelList.get(position).getPower();
        String kDay  = modelList.get(position).getkDay();
        viewholder.SetData(id,device,qty,hours,power,kDay);
    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

        private TextView devicetxt;
        private TextView qtyTxt;
        private TextView hdayTxt;
        private TextView powerTxt;
        private TextView kDayTxt;
        private TextView idText;




        public Viewholder(@NonNull View itemView) {
            super(itemView);

            devicetxt = itemView.findViewById(R.id.devicetxt);
            qtyTxt = itemView.findViewById(R.id.qtyTxt);
            hdayTxt = itemView.findViewById(R.id.hdayTxt);
            powerTxt = itemView.findViewById(R.id.powerTxt);
            kDayTxt = itemView.findViewById(R.id.kDayTxt);
            idText = itemView.findViewById(R.id.textid);
        }

        private void SetData(String id,String device, String qty, String hday, String power, String kday){

            idText.setText(id);
            devicetxt.setText(device);
            qtyTxt.setText(qty);
            hdayTxt.setText(hday);
            powerTxt.setText(power);
            kDayTxt.setText(kday);


        }

    }

}
