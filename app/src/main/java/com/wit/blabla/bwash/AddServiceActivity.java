package com.wit.blabla.bwash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AddServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);

        final EditText txtName= findViewById(R.id.editText_Name);
        final EditText  txtLocation= findViewById(R.id.editText_Location);
        final EditText  txtTime= findViewById(R.id.editText_OpenTime);
        final EditText  txtPrice= findViewById(R.id.editText_Price);
        final EditText  txtDescription= findViewById(R.id.editText_desription);

        Button btSumbit = findViewById(R.id.button_sumbit);

        btSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "http://localhost:8080/BWash/createService";

               StringRequest sq= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {

                   }
               }, new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {

                   }
               }) {
                   protected Map<String , String> getParams(){
                       Map<String, String> parr = new HashMap<String, String>();

                       parr.put("serviceName",txtName.getText().toString());
                       parr.put("servicePrices",txtPrice.getText().toString());
                       parr.put("serviceDescription",txtDescription.getText().toString());

                       return parr;
                   }
               };
               AppController.getInstance().addToRequestQueue(sq);
                Toast.makeText(getApplicationContext(), "Vua news published Successfully!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
