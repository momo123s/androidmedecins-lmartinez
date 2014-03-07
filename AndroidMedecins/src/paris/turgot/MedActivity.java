/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paris.turgot;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
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
        List<Medecin>lesMeds = DAO.getLesMeds(leDep);
        
        label.setText("Liste des medecins du : "+leDep);
        
        MedAdapter adapter = new MedAdapter(lesMeds, this);
        setListAdapter(adapter);
        
        
        

    }

}
