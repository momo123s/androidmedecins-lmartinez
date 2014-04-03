/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paris.turgot;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lmartinez
 */
public class MedActivity extends ListActivity {

    private List<Medecin> lesMeds;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.meds);
        TextView label = (TextView) findViewById(R.id.label);
        Intent inter = getIntent();
        String leDep = inter.getStringExtra("leDep");
        DAO.getLesMeds(leDep);
        final List<Medecin> lesMeds = DAO.getLesMeds(leDep);
        final EditText keyInput =(EditText) findViewById(R.id.textSearch);
        Button button = (Button) findViewById(R.id.buttonRecherche);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                List<Medecin> rechercheMed = new ArrayList<Medecin>();
                for (Medecin unMed : lesMeds) {
                    if (unMed.getNom().toLowerCase().startsWith(keyInput.getText().toString().toLowerCase())) {
                        rechercheMed.add(unMed);
                    }

                }
                MedAdapter adapter = new MedAdapter(rechercheMed, getApplicationContext());
                setListAdapter(adapter);
            }
        });

        label.setText("Liste des medecins du : " + leDep);

        MedAdapter adapter = new MedAdapter(lesMeds, this);
        setListAdapter(adapter);

    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+ ((Medecin)l.getItemAtPosition(position)).getTel()));
        startActivity(callIntent);
    }

}
