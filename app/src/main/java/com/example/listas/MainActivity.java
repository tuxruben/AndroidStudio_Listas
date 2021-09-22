package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] array = new String[] {
                "Elemento 1"
                ,"Elemento 2"
                ,"Elemento 3"
                ,"Elemento 4"
                ,"Elemento 5"
                ,"Elemento 6"
        };
//Creación del adaptador, vamos a escoger el layout
//simple_list_item_1, que los mostr
        ListAdapter adaptador = new ArrayAdapter<String>(
                this, android.R.layout.simple_expandable_list_item_1, array);
//Asociamos el adaptador a la vista.
        ListView lv = (ListView) findViewById(android.R.id.list);
// Vincula la lista con el adaptador a través del método ListView.setAdapter():
        lv.setAdapter(adaptador);
//Evento que se disparará al pulsar en un elemento de la lista
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView< ?> arg0, View arg1, int arg2,
                                    long arg3) {
                ListAdapter la = (ListAdapter) arg0.getAdapter();
                Toast.makeText(
                        arg1.getContext()
                        ,la.getItem(arg2).toString()
                        ,Toast.LENGTH_LONG)
                        .show();




                if (arg2 == 0){
                    // Abre una nueva Activity:
                    Intent myIntent = new Intent(arg1.getContext(), nuevaActivity.class);
                    startActivity(myIntent);
                }else if(arg2 == 1){

                    Intent myIntent;
                    myIntent = new Intent(arg1.getContext(), segundaactivity.class);
                    startActivity(myIntent);
                }else if(arg2 == 2){
                    // Abre una nueva Activity:
                    Intent myIntent;
                    myIntent = new Intent(arg1.getContext(), terceraActivity.class);
                    startActivity(myIntent);
                }


            }

        });
    }

}
