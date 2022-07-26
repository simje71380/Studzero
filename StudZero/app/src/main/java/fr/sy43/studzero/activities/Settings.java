package fr.sy43.studzero.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fr.sy43.studzero.R;
import fr.sy43.studzero.sqlite.helper.DatabaseHelper;

/**
 * This class is used for the settings screen of the app
 */
public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.history);

        //set status bar name
        getSupportActionBar().setTitle("Settings");

        TextView txtV = findViewById(R.id.TextViewDate);
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        txtV.setText(DatabaseHelper.getStringWithoutTimeFromDate(db.getCurrentBudget().getDateNextBudget()));
        db.closeDB();
        Button btn = (Button) findViewById(R.id.SettingsButtonReset);
        btn.setOnClickListener(new View.OnClickListener() {
            /**
             * Reset Button pressed -> launch the creation of a new budget
             * @param v
             */
            public void onClick(View v) {
                finish();
                //go new budget 1 with caller = settings
                Intent intent = new Intent(getApplicationContext(), New_Budget_1.class);
                intent.putExtra("caller", "Settings"); //permet à la nouvelle activity de connaitre son lanceur
                startActivity(intent);
            }
        });

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.settings);
        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            /**
             * This function is used by the nav bar the bottom of the screen.
             * If calls an activity depending on the item selected by the user.
             * @param item
             * @return
             */
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.add_payements:
                        startActivity(new Intent(getApplicationContext(), AddPayments.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.settings:
                        return true;
                    case R.id.stats:
                        startActivity(new Intent(getApplicationContext(), Stats.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.history:
                        startActivity(new Intent(getApplicationContext(), History.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}