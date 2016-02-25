package ivan.persondetailsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

/**
 * This is the second activity which displays the person's details
 */
public class PersonDetailsActivity extends AppCompatActivity {

    TextView name, lastName, age, address, postNo, custom1StaticText, custom2StaticText, custom3StaticText, custom1, custom2, custom3;
    ImageView profilePic;


    /**
     * Getting the TextView and ImageView objects from XML and assigning them to our fields/global variables
     * Getting the Person Object from the intent which is the picked person from the person list
     * Setting the name, last name, age address, post number TextView according to the person picked on the previous activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persondetails);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = (TextView) findViewById(R.id.textViewName);
        lastName = (TextView) findViewById(R.id.textViewLastName);
        age = (TextView) findViewById(R.id.textViewAge);
        address = (TextView) findViewById(R.id.textViewAddress);
        postNo = (TextView) findViewById(R.id.textViewPostNo);
        custom1 = (TextView) findViewById(R.id.textViewCust1);
        custom2 = (TextView) findViewById(R.id.textViewCust2);
        custom3 = (TextView) findViewById(R.id.textViewCust3);
        custom1StaticText = (TextView) findViewById(R.id.textViewCustom1);
        custom2StaticText = (TextView) findViewById(R.id.textViewCustom2);
        custom3StaticText = (TextView) findViewById(R.id.textViewCustom3);
        profilePic = (ImageView) findViewById(R.id.imageView);


        Person person = (Person) getIntent().getSerializableExtra("Person");
        name.setText(person.getName());
        lastName.setText(person.getLastName());

        //Converting int value to string, because textView shows String value. If I didn't do this then the app would of crashed
        age.setText(Integer.toString(person.getAge()));
        address.setText(person.getAddress());
        postNo.setText(Integer.toString(person.getPostNo()));


        /**
         * If the person picked is a "Student", then the School, the class of the student and a default student avatar should appear
         * If the student is Ivan then a personal profile picture should appear
         * If the person is a "Worker", then the company, department, role and a default worker avatar should appear
         */
        if (person instanceof Student) {
            System.out.println("This is a Student");
            profilePic.setImageResource(R.mipmap.studentpic);
            custom1StaticText.setText("School:");
            custom2StaticText.setText("Class:");
            custom1.setText(((Student) person).getSchool());
            custom2.setText(((Student) person).getClassOfStudent());
            if (person.getName().contains("Ivan")) {
                profilePic.setImageResource(R.mipmap.ivanpic);
            }
        } else if (person instanceof Workers) {
            System.out.println("This is a Worker");
            profilePic.setImageResource(R.mipmap.workerpic);
            custom1StaticText.setText("Company:");
            custom2StaticText.setText("Department:");
            custom3StaticText.setText("Role:");
            custom1.setText(((Workers) person).getCompany());
            custom2.setText(((Workers) person).getDepartment());
            custom3.setText(((Workers) person).getRole());
        }


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
