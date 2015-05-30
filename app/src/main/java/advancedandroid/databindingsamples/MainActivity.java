package advancedandroid.databindingsamples;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import advancedandroid.databindingsamples.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewDataBinding.setClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final int id = view.getId();
        if (id == R.id.variable_button) {
            startActivity(new Intent(MainActivity.this, VariableBindingActivity.class));
            return;
        }
        if (id == R.id.custom_binding_observable) {
            Toast.makeText(this, "not implemented", Toast.LENGTH_SHORT).show();
        }
    }

}
