package com.nagstud.adnan.mobileapp_1;
// create the class file for about us xml file
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shubham Dilip Shendre aka SdS
 *            Adnan Kazi aka Addy
 *            Furqan
 *            Sadat Hussain
 *            Pranav aka PMB
 * for NagStud LLP Project nagpurstudents
 */
public class AboutusActivity extends AppCompatActivity {


    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add(" About Us");
        listDataHeader.add("Previous Work");
        listDataHeader.add("Privacy");

        // Adding child data under Group of Explist
        List<String> AboutUs = new ArrayList<String>();
        AboutUs.add("About Us :\n" +
                "\n" +
                "At Website.com, we believe everyone deserves to have a website or online store. Innovation and simplicity makes us happy: our goal is to remove any technical or financial barriers that can prevent business owners from making their own website. We're excited to help you on your journey!" +
                "Education is about teaching, learning skills and knowledge. Education also means helping people to learn how to do things and encouraging them to think about what they learn. It is also important for educators to teach ways to find and use information.In simple words we can say that a process which makes desireable change in human behaviour is known as education process\n" +
                "\n" +
                "Through education, the knowledge of society, country, and of the world is passed on from generation to generation. In democracies, through education, children and adults are supposed to learn how to be active and effective citizens.\n" +
                "\n" +
                "More specific, education helps and guide individuals to transform from one class to other. Empowered individuals, societies, countries by education are taking edge over individuals stand on bottom pyramid of growth.");



        List<String> PreviousWork = new ArrayList<String>();
        PreviousWork.add("Previous Work :\n" +
                "\n" +
                "At Website.com, we believe everyone deserves to have a website or online store. Innovation and simplicity makes us happy: our goal is to remove any technical or financial barriers that can prevent business owners from making their own website. We're excited to help you on your journey!");


        List<String> Privacy = new ArrayList<String>();
        Privacy.add("Privacy :\n" +
                "\n" +
                "A privacy policy is a statement or a legal document (in privacy law) that discloses some or all of the ways a party gathers, uses, discloses, and manages a customer or client's data. It fulfills a legal requirement to protect a customer or client's privacy. Personal information can be anything that can be used to identify an individual, not limited to the person's name, address, date of birth, marital status, contact information, ID issue and expiry date, financial records, credit information, medical history, where one travels, and intentions to acquire goods and services.[1] In the case of a business it is often a statement that declares a party's policy on how it collects, stores, and releases personal information it collects. It informs the client what specific information is collected, and whether it is kept confidential, shared with partners, or sold to other firms or enterprises.[2] Privacy policies typically represent a broader, more generalized treatment, as opposed to data use statements, which tend to be more detailed and specific.\n" +
                "\n" +
                "The exact contents of a certain privacy policy will depend upon the applicable law and may need to address requirements across geographical boundaries and legal jurisdictions. Most countries have their own legislation and guidelines of who is covered, what information can be collected, and what it can be used for. In general, data protection laws in Europe cover the private sector as well as the public sector. Their privacy laws apply not only to government operations but also to private enterprises and commercial transactions.");

        listDataChild.put(listDataHeader.get(0), AboutUs); // Header, Child data
        listDataChild.put(listDataHeader.get(1), PreviousWork);
        listDataChild.put(listDataHeader.get(2), Privacy);
    }
    //add the menu item in action bar
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            intent.putExtra("string", String.valueOf(item));
            startActivity(intent);
        } else if (id == R.id.action_share) {
            Intent i = new Intent(android.content.Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject test");
            i.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.nagpurstudents");
            startActivity(Intent.createChooser(i, "Share via"));
        } else if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
