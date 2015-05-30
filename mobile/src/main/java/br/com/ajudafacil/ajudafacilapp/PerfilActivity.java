package br.com.ajudafacil.ajudafacilapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;


public class PerfilActivity extends ActionBarActivity {
    SharedPreferences prefs = this.getSharedPreferences("ajudafacil", 0);
    SharedPreferences.Editor editor = prefs.edit();
    String nome;
    String mensagem;
    String tipoSanguineo;
    String[] telefones;
    String[] doencas;

    private String[] tiposSanguineos = {"AB+", "AB-", "A+", "A-", "B+", "B-", "O+", "O-"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nome = prefs.getString("nome","");
        mensagem = prefs.getString("mensagem","");
        tipoSanguineo = prefs.getString("tipoSanguineo","");
        try {

            JSONArray jsonTelefones = new JSONArray(prefs.getString("telefones", "[]"));
            for (int i = 0; i < jsonTelefones.length(); i++) {
                Log.d("jsonTelefones ", jsonTelefones.getInt(i) + "");
            }

            JSONArray jsonDoencas = new JSONArray(prefs.getString("doencas", "[]"));
            for (int i = 0; i < jsonDoencas.length(); i++) {
                Log.d("jsonDoencas ", jsonTelefones.getInt(i) + "");
            }



        } catch (Exception e) {
            e.printStackTrace();
        }


    }


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
