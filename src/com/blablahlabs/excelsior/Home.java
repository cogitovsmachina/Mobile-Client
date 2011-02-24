package com.blablahlabs.excelsior;



import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends ListActivity {
	private static String[] items={"lorem", "ipsum"};

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomTitle();
        setListViewHeaders();
        setContentView(R.layout.main);
	}

	private void setListViewHeaders() {
		adapter.addSection("Nacional",
				new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1,
					items));
		List<String> list=Arrays.asList(items);
	
		adapter.addSection("Global",
							new ArrayAdapter<String>(this,
							android.R.layout.simple_list_item_1,
							list));
		list=Arrays.asList(items);
		
		adapter.addSection("Dinero",
							new ArrayAdapter<String>(this,
							android.R.layout.simple_list_item_1,
							list));
		list=Arrays.asList(items);
		
		adapter.addSection("Comunidad",
				new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				list));
		list=Arrays.asList(items);
		
		adapter.addSection("Adrenalina",
				new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				list));
		list=Arrays.asList(items);
		
		adapter.addSection("Funci—n",
				new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				list));
		list=Arrays.asList(items);
		
		adapter.addSection("Opini—n",
				new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				list));
		list=Arrays.asList(items);
		
		setListAdapter(adapter);		
	}

	SectionedAdapter adapter=new SectionedAdapter() {
	protected View getHeaderView(String caption, int index,
												 View convertView,
								    			 ViewGroup parent) {
		TextView result=(TextView)convertView;
		
		if (convertView==null) {
			result=(TextView)getLayoutInflater()
							.inflate(R.layout.header,
							 null);
		}
		
		result.setText(caption);
		
		return(result);
	}
	};
        
	
    
    private void setCustomTitle() {
    	requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);		
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.news_image:     Toast.makeText(this, "You want to see news!", Toast.LENGTH_LONG).show();
                                break;
            case R.id.gallery_image:     Toast.makeText(this, "You want to go to gallery!", Toast.LENGTH_LONG).show();
                                break;
            case R.id.movies_image: Toast.makeText(this, "You want to go to movies!", Toast.LENGTH_LONG).show();
                                break;
        }
        return true;
    }
    
   
    
}