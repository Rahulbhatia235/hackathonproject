package intent.mohit.com.hackathonproject;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class details extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button button;Spinner dropdown;String text,sp1,disas;
    EditText Name,Contact;
    Spinner State,City;
    String server_url="http://192.168.43.127/details.php";
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.enterbutton);
        Name=(EditText)findViewById(R.id.etname);
        Contact=(EditText)findViewById(R.id.etcontact);
        State=(Spinner)findViewById(R.id.spinner1);
        City=(Spinner) findViewById(R.id.spinner2);
        dropdown=(Spinner)findViewById(R.id.etdisas);
        builder=new AlertDialog.Builder(details.this);
        String[] items=new String[]{"Cyclone","Earthquake","Flood", "Landslide", "Tsunami"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(details.this,android.R.layout.simple_spinner_dropdown_item,items);
        dropdown.setAdapter(adapter);// iss adapter me vlue ni ja ri kya kre phir? ye error copy paste kro..us page se pohochne se pehle hi crsh kr rha
        disas=dropdown.getSelectedItem().toString();
        //disas=String.valueOf(dropdown.getSelectedItem());
        State.setOnItemSelectedListener(details.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name,contact;
                name=Name.getText().toString();
                contact=Contact.getText().toString();
                StringRequest stringRequest=new StringRequest(Request.Method.POST, server_url
                        , new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(details.this,response,Toast.LENGTH_SHORT).show();
                        builder.setTitle("Server Response");
                        builder.setMessage("Response :"+response);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Name.setText("");
                                Contact.setText("");
                            }
                        });
                        AlertDialog alertDialog=builder.create();
                        alertDialog.show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(details.this,"Error...."+error.getMessage(),Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params= new HashMap<String,String>();
                        params.put("name",name);
                        params.put("contact",contact);
                        params.put("state",sp1);
                        params.put("city",text);
                        params.put("disas",disas);
                        return params;
                    }
                };
                intent.mohit.com.hackathonproject.MySingleton.getInstance(details.this).addToRequest(stringRequest);


            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {
        // TODO Auto-generated method stub
        sp1= String.valueOf(State.getSelectedItem());
        //  Toast.makeText(MainActivity.this, sp1, Toast.LENGTH_SHORT).show();

        if(sp1.contentEquals("Jammu Kashmir")) {
            List<String> list = new ArrayList<String>();
            list.add("Srinagar");
            list.add("Leh Ladakh");
            list.add("Sonamarg");
            list.add("Phalgam");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            City.setAdapter(dataAdapter);
            text=City.getSelectedItem().toString();
            //text=String.valueOf(City.getSelectedItem());
        }
        if(sp1.contentEquals("Madhya Pradesh")) {
            List<String> list = new ArrayList<String>();
            list.add("Bhopal");
            list.add("Indore");
            list.add("Ujjain");
            list.add("Gwalior");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            City.setAdapter(dataAdapter2);
            text=City.getSelectedItem().toString();
            //text=String.valueOf(City.getSelectedItem());
        }
        if(sp1.contentEquals("Uttar Pradesh"))
        {
            List<String> list = new ArrayList<String>();
            list.add("Varanasi");
            list.add("Lucknow");
            list.add("Allahabad");
            list.add("Gorakhpur");
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3.notifyDataSetChanged();
            State.setAdapter(dataAdapter3);
            text=City.getSelectedItem().toString();
            //text=String.valueOf(City.getSelectedItem());
        }
        if(sp1.contentEquals("Maharashtra"))
        {
            List<String> list = new ArrayList<String>();
            list.add("Mumbai");
            list.add("Pune ");
            list.add("Nagpur");
            list.add("Nashik");
            list.add("Aurangabad");
            ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter4.notifyDataSetChanged();
            City.setAdapter(dataAdapter4);
            text=City.getSelectedItem().toString();
            //text=String.valueOf(City.getSelectedItem());
        }
        if(sp1.contentEquals("Gujarat"))
        {
            List<String> list = new ArrayList<String>();
            list.add("Ahmedabad");
            list.add("Surat");
            list.add("Rajkot");
            list.add("Bhuj");
            ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter5.notifyDataSetChanged();
            City.setAdapter(dataAdapter5);
            text=City.getSelectedItem().toString();
            //text=String.valueOf(City.getSelectedItem());
        }
        if(sp1.contentEquals("Rajasthan"))
        {
            List<String> list = new ArrayList<String>();
            list.add("Jaipur");
            list.add("Udaipur");
            list.add("Jodhpur");
            list.add("Kota");
            ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter6.notifyDataSetChanged();
            City.setAdapter(dataAdapter6);
            text=City.getSelectedItem().toString();
            //text=String.valueOf(City.getSelectedItem());
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}

