package com.ggave.gastosapp.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ggave.gastosapp.R;
import com.ggave.gastosapp.models.Operation;
import java.util.List;
public class OperationsAdapter extends RecyclerView.Adapter<OperationsAdapter.ViewHolder> {

    private List<Operation> operations;

    public void setOperations(List<Operation> operations){
        this.operations = operations;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView fechatipoText;
        TextView montoText;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            fechatipoText = itemView.findViewById(R.id.fecha_tipo_text);
            montoText = itemView.findViewById(R.id.Monto_text);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_operation, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Operation operation = this.operations.get(i);

        Context context = viewHolder.itemView.getContext();

        viewHolder.fechatipoText.setText(operation.getFecha()+" "+operation.getOperacion());
        viewHolder.montoText.setText("     S/."+String.valueOf(operation.getMonto()));
    }
    @Override
    public int getItemCount(){
        return this.operations.size();
    }
}
