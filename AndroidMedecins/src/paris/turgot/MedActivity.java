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
        setContentView(R.layout.noms);
        
        lesMeds = DAO.getLesMeds(String dep);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lesMeds);
        setListAdapter(adapter);        
    }
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.noms);
        TextView label = (TextView)findViewById(R.id.label);
        Intent inter = getIntent();
        String nom = inter.getStringExtra("leNom");
        label.setText(nom);
    
}
