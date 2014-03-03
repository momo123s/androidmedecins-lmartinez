package paris.turgot;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends ListActivity {
 private List<String> lesDeps;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lesDeps = DAO.getLesDeps();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lesDeps);
        setListAdapter(adapter);

        
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
    
        //Toast.makeText(getApplicationContext(), "Bonjour "+lesNoms.get(position), Toast.LENGTH_LONG).show();
        Intent inter = new Intent (this, MedActivity.class);
        inter.putExtra("leDep",lesDeps.get(position) );
        startActivity(inter);
        
    }
  
}