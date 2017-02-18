package pk.creditfix.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pk.creditfix.app.R;
import pk.creditfix.app.model.CustomerAcquisitionModel;

/**
 * Created by Adnan Ali on 2/17/2017.
 */

public class CustomerAcquisitionCatagoryAdapter extends RecyclerView.Adapter<CustomerAcquisitionCatagoryAdapter.CustomerAcquisitionCatagoryViewHolder> {

    public static CustomerAcquisitionClickListener sCustomerAcquisitionClickListener;

    private List<CustomerAcquisitionModel> acquisitionModelList;
    Context context;

    public CustomerAcquisitionCatagoryAdapter(Context context, List<CustomerAcquisitionModel> acquisitionModelList){
        this.context = context;
        this.acquisitionModelList = acquisitionModelList;
    }

    @Override
    public CustomerAcquisitionCatagoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.customer_acquistion_item, null);
        CustomerAcquisitionCatagoryViewHolder vh = new CustomerAcquisitionCatagoryViewHolder(view);
        return vh;
    }



    @Override
    public void onBindViewHolder(CustomerAcquisitionCatagoryViewHolder holder, int position) {
        CustomerAcquisitionModel acquisitionModel = acquisitionModelList.get(position);
        holder.textView.setText(acquisitionModel.getProductName());
        holder.imageView.setImageResource(acquisitionModel.getProductImage());
    }

    @Override
    public int getItemCount() {
        return acquisitionModelList.size();
    }
    public void setOnItemClickListener(CustomerAcquisitionClickListener clickListener) {
        CustomerAcquisitionCatagoryAdapter.sCustomerAcquisitionClickListener = clickListener;
    }

    public interface CustomerAcquisitionClickListener {
        void onItemClick(int position, View v);
    }

    public static class CustomerAcquisitionCatagoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
        public ImageView imageView;
        public CustomerAcquisitionCatagoryViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.acquisition_txt);
            imageView = (ImageView) view.findViewById(R.id.acquisition_img);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            sCustomerAcquisitionClickListener.onItemClick(getAdapterPosition(), view);
        }
    }
}
