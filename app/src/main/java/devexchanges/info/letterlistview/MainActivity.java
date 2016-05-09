package devexchanges.info.letterlistview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> stringArrayList;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setData();
        adapter = new ListViewAdapter(this, R.layout.item_listview, stringArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, (String)parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setData() {
        stringArrayList = new ArrayList<>();
        stringArrayList.add("Quynh Trang");
        stringArrayList.add("Hoang Bien");
        stringArrayList.add("Duc Tuan");
        stringArrayList.add("Dang Thanh");
        stringArrayList.add("Xuan Luu");
        stringArrayList.add("Phan Thanh");
        stringArrayList.add("Kim Kien");
        stringArrayList.add("Ngo Trang");
        stringArrayList.add("Thanh Ngan");
        stringArrayList.add("Nguyen Duong");
        stringArrayList.add("Quoc Cuong");
        stringArrayList.add("Tran Ha");
        stringArrayList.add("Vu Danh");
        stringArrayList.add("Minh Meo");
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu) {
        getMenuInflater().inflate( R.menu.menu_main, menu);

        MenuItem myActionMenuItem = menu.findItem( R.id.action_search);
        final SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    adapter.filter("");
                    listView.clearTextFilter();
                } else {
                    adapter.filter(newText);
                }
                return true;
            }
        });

        return true;
    }
}
