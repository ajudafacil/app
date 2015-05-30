package br.com.ajudafacil.ajudafacilapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import org.json.JSONArray;

import java.util.ArrayList;


public class PerfilActivity extends ActionBarActivity {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String nome;
    String mensagem;
    String tipoSanguineo;
    ArrayList<String> telefones = new ArrayList<String>();
    ArrayList<String> doencas = new ArrayList<String>();
    String[] tiposSanguineos = {"AB+", "AB-", "A+", "A-", "B+", "B-", "O+", "O-"};

    Spinner fieldSpinner;
    EditText fieldNome;
    EditText fieldMensagem;
    ListView listTelefones;
    ListView listDoencas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        prefs = getSharedPreferences("ajudafacil", 0);
        editor = prefs.edit();

        nome = prefs.getString("nome","");
        mensagem = prefs.getString("mensagem","");
        tipoSanguineo = prefs.getString("tipoSanguineo","");

        fieldSpinner = (Spinner) findViewById(R.id.spinner);
        fieldNome = (EditText) findViewById(R.id.editText);
        fieldMensagem = (EditText) findViewById(R.id.editText2);
        listTelefones = (ListView) findViewById(R.id.listTelefones);
        listDoencas = (ListView) findViewById(R.id.listDoencas);

        ArrayAdapter<String> tiposSanguineosAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tiposSanguineos);
        tiposSanguineosAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fieldSpinner.setAdapter(tiposSanguineosAdapter);

        fieldNome.setText(nome);
        fieldMensagem.setText(mensagem);

        try {

            JSONArray jsonTelefones = new JSONArray(prefs.getString("telefones", "[]"));
            for (int i = 0; i < jsonTelefones.length(); i++) {
                telefones.add(jsonTelefones.getString(i));
            }

            JSONArray jsonDoencas = new JSONArray(prefs.getString("doencas", "[]"));
            for (int i = 0; i < jsonDoencas.length(); i++) {
                doencas.add(jsonDoencas.getString(i));
            }

            ArrayAdapter<String> listaTelefonesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, telefones);
            ArrayAdapter<String> listaDoencasAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, doencas);

            listTelefones.setAdapter(listaTelefonesAdapter);
            listDoencas.setAdapter(listaDoencasAdapter);



        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /*
    JSONArray jsonArray = new JSONArray();
    jsonArray.put(1);
    jsonArray.put(2);
    Editor editor = prefs.edit();
    editor.putString("key", jsonArray.toString());
    System.out.println(jsonArray.toString());
    editor.commit();
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_perfil, menu);
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
