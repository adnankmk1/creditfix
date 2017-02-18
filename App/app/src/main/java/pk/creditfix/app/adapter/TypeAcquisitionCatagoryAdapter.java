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
import pk.creditfix.app.model.TypeAcquisitionModel;

/**
 * Created by Adnan Ali on 2/18/2017.
 */

public class TypeAcquisitionCatagoryAdapter extends RecyclerView.Adapter<TypeAcquisitionCatagoryAdapter.TypeAcquisitionCatagoryViewHolder> {

    public static TypeAcquisitionCatagoryListener sTypeAcquisitionCatagoryListener;

    Context context;
    List<TypeAcquisitionModel> typeModelList;

    public TypeAcquisitionCatagoryAdapter(Context context, List<TypeAcquisitionModel> typeModelList){
        this.context = context;
        this. typeModelList = typeModelList;
    }

    @Override
    public TypeAcquisitionCatagoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.customer_acquistion_item, null);
        TypeAcquisitionCatagoryViewHolder viewHolder = new TypeAcquisitionCatagoryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TypeAcquisitionCatagoryViewHolder holder, int position) {
        TypeAcquisitionModel typeModel = typeModelList.get(position);

        holder.textView.setText(typeModel.getProductTypeName());
        holder.imageView.setImageResource(typeModel.getProductTypeImage());
    }

    @Override
    public int getItemCount() {
        return typeModelList.size();
    }

    public interface TypeAcquisitionCatagoryListener{
        public void onClickListener(View view, int position);
    }

    public void setTypeAcquisitionCatagoryListener(TypeAcquisitionCatagoryListener sTypeAcquisitionCatagoryListener){
        TypeAcquisitionCatagoryAdapter.sTypeAcquisitionCatagoryListener = sTypeAcquisitionCatagoryListener;
    }

    public static class TypeAcquisitionCatagoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;
        ImageView imageView;
        public TypeAcquisitionCatagoryViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.acquisition_txt);
            imageView = (ImageView) view.findViewById(R.id.acquisition_img);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            sTypeAcquisitionCatagoryListener.onClickListener(view, getAdapterPosition());
        }
    }
}
