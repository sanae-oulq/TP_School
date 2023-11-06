package ma.ensa.volley;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button gestionEtudiants; // Utilisez le bon ID
    private Button gestionFilieres; // Utilisez le bon ID
    private Button listeEtudiants; // Utilisez le bon ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestionEtudiants = findViewById(R.id.gestionEtudiants); // Utilisez le bon ID
        gestionFilieres = findViewById(R.id.gestionFilieres); // Utilisez le bon ID
        listeEtudiants = findViewById(R.id.listeEtudiants); // Utilisez le bon ID

        gestionEtudiants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EtudiantActivity.class);
                startActivity(intent);
            }
        });

        gestionFilieres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FiliereActivity.class);
                startActivity(intent);
            }
        });

        listeEtudiants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, f.class);
                startActivity(intent);
            }
        });
    }
}
