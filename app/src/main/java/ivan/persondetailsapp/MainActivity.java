package ivan.persondetailsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Fields
    ListView personList;
    String[] names;
    ArrayList<Person> people = new ArrayList<Person>();


    /**
     * Adding a variation of students and workers to the Person ArrayList
     * Then adding the people from the ArrayList to string array called names which is used to display the name of the person on the ListView.
     */
    public void addPeople() {
        people.add(new Student("Ivan", "Kana", 24, "Fosnavåg", 6062, "NTNU i Ålesund", "DATA-2013-Bachelor"));
        people.add(new Student("Jarle", "Vartdal", 18, "Ramsvika", 6010, "NTNU i Ålesund", "DATA-2013-Bachelor"));
        people.add(new Workers("Gøran", "Hovde", 25, "Liberty City", 305, "Rockstar Games", "Grand Theft Auto Dpt", "Game Tester"));
        people.add(new Student("Per Olav", "Eikrem", 28, "Ulsteinvik", 6023, "NTNU i Gjørvik", "MobilApp-2016-Master"));
        people.add(new Workers("Ramin", "Esfandari", 33, "Oslo", 6021, "Ubisoft", "Assassins Creed Dpt", "Software Developer"));
        people.add(new Workers("Ole Martin", "Brattvåg", 41, "Ålesund Spjelkavika", 6019, "OSC", "Simulation Dpt", "Support Manager"));
        people.add(new Workers("Girts", "Strazdins", 30, "Ålesund Moa", 6008, "NTNU i Ålesund", "Computer Engineering", "Teacher/Professor"));

        names = new String[people.size()];
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).getName() + " " + people.get(i).getLastName());
            names[i] = (people.get(i).getName() + " " + people.get(i).getLastName());
        }


    }

    /**
     * Calling add people method so the people gets added to ArrayList
     * Getting the ListView object from XML and assigning them to our field/global variable
     * Adding ArrayAdapter which is needed to handle listView
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addPeople();

        // Get ListView object from xml
        personList = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, names);

        // Assign adapter to personList (ListView)
        personList.setAdapter(adapter);

        // ListView Item Click Listener
        personList.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            /**
             * Once an item is clicked on the ListView, the person clicked is passed to the intent, which is handled on the PersonDetails Activity
             * You enter a new activity, clicking the back button from your android phone will return you back to this screen
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;


                Intent personDetailsActivity = new Intent(MainActivity.this, PersonDetailsActivity.class);

                personDetailsActivity.putExtra("Person", people.get(itemPosition));
                startActivity(personDetailsActivity);

            }

        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
