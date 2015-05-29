package advancedandroid.databindingsamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class CustomBindingClassNameActivity extends AppCompatActivity {
    class CustomViewHolder extends RecyclerView.ViewHolder {
        final advancedandroid.databindingsamples.CustomBindingItem bindingItem;

        public CustomViewHolder(advancedandroid.databindingsamples.CustomBindingItem bindingItem, View itemView) {
            super(itemView);
            this.bindingItem = bindingItem;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_binding_class_name);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerView.Adapter<CustomViewHolder>(){


            @Override
            public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                final advancedandroid.databindingsamples.CustomBindingItem bindingItem = advancedandroid.databindingsamples.CustomBindingItem.inflate(getLayoutInflater());
                final View root = bindingItem.getRoot();
                return new CustomViewHolder(bindingItem, root);
            }

            @Override
            public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
                customViewHolder.bindingItem.setI(i);
            }

            @Override
            public int getItemCount() {
                return 100;
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
