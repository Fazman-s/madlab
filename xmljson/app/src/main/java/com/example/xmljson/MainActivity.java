package com.example.xmljson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,tt1;
    Button b1,b2;
    JSONObject city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        tt1=findViewById(R.id.tt1);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    AssetManager assetManager=getAssets();
                    InputStream istream=assetManager.open("jsondata.json");
                    int size=istream.available();
                    byte [] buffer=new byte[size];
                    istream.read(buffer);
                    istream.close();
                    tt1.setText("JSON Data is ");
                    city=new JSONObject(new String(buffer,"UTF-8"));
                    t1.setText("City Name: "+city.getString("city_name"));
                    t2.setText("Latitude: "+city.getString("latitude"));
                    t3.setText("Longitude: "+city.getString("longitude"));
                    t4.setText("Temperature: "+city.getString("temperature"));
                    t5.setText("Humidity: "+city.getString("humidity"));

                } catch (Exception e){}
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream is=getAssets().open("xmldata.xml");
                    DocumentBuilderFactory dbfactory=DocumentBuilderFactory.newInstance();
                    DocumentBuilder dbuilder=dbfactory.newDocumentBuilder();
                    Document doc=dbuilder.parse(is);
                    tt1.setText("XML Data is ");
                    NodeList nodeList=doc.getElementsByTagName("city");
                    Node node=nodeList.item(0);
                    Element e=(Element) node;
                    t1.setText("City Name :"+e.getElementsByTagName("city_name").item(0).getTextContent());
                    t2.setText("Latitude :"+e.getElementsByTagName("latitude").item(0).getTextContent());
                    t3.setText("Longitude :"+e.getElementsByTagName("longitude").item(0).getTextContent());
                    t4.setText("Temperature :"+e.getElementsByTagName("temperature").item(0).getTextContent());
                    t5.setText("Humidity :"+e.getElementsByTagName("humidity").item(0).getTextContent());

                }catch (Exception e){}
            }
        });

    }
}