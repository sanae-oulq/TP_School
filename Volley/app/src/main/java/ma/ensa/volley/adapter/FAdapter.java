package ma.ensa.volley.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ma.ensa.volley.R;
import ma.ensa.volley.beans.Etudiant;
import ma.ensa.volley.beans.Etudiant;

public class FAdapter extends RecyclerView.Adapter<FAdapter.EtudiantViewHolder> {
    private static final String TAG = "FAdapter";
    private List<Etudiant> etudiants;
    private Context context;



    public FAdapter(Context context, List<Etudiant> etudiants) {
        this.etudiants = etudiants;
        this.context = context;

    }


    @NonNull
    @Override
    public EtudiantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(this.context).inflate(R.layout.f_item,
                viewGroup, false);
        final EtudiantViewHolder holder = new EtudiantViewHolder(v);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull EtudiantViewHolder starViewHolder, int i) {

        Log.d(TAG, "onBindView call ! "+ i);
        starViewHolder.firstname.setText(etudiants.get(i).getFirstName());
        starViewHolder.lastname.setText(etudiants.get(i).getLastName());
        starViewHolder.filiere.setText(etudiants.get(i).getFiliere().getCode());


    }
    @Override
    public int getItemCount() {
        return etudiants.size();
    }
    public class EtudiantViewHolder extends RecyclerView.ViewHolder {
        TextView firstname;
        TextView lastname;
        TextView filiere;


        RelativeLayout parent;
        public EtudiantViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname = itemView.findViewById(R.id.firstname);
            lastname = itemView.findViewById(R.id.lastname);
            filiere = itemView.findViewById(R.id.filiere);

        }
    }
}