package ma.ensa.volley;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AddFiliereActivity extends AppCompatActivity {
    private EditText code;
    private EditText libelle;
    private Button add;

    private RequestQueue requestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_filiere);

        code = findViewById(R.id.addcode);
        libelle = findViewById(R.id.addlibelle);
        add = findViewById(R.id.addbtn);
        requestQueue = Volley.newRequestQueue(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFiliere();
            }
        });

    }

    private void addFiliere() {
        String codes = code.getText().toString();
        String libelles = libelle.getText().toString();


        String insertUrl = "http://192.168.89.73:8080/api/v1/filieres";

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("code", codes);
            jsonBody.put("libelle", libelles);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                insertUrl, jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(), "Filiere created successfully ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddFiliereActivity.this, FiliereActivity.class);
                startActivity(intent);
                AddFiliereActivity.this.finish();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Erreur", error.toString());
            }
        });
        requestQueue.add(request);
    }
}

