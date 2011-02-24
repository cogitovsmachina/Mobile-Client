package com.blablahlabs.excelsior;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class HomeListView extends ListActivity {
	private static String[] items={"lorem", "ipsum", "dolor",
											"sit", "amet", "consectetuer",
											"adipiscing", "elit", "morbi",
											"vel", "ligula", "vitae",
											"arcu", "aliquet", "mollis",
											"etiam", "vel", "erat",
											"placerat", "ante",
											"porttitor", "sodales",
											"pellentesque", "augue",
											"purus"};
	
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		
		adapter.addSection("Original",
						new ArrayAdapter<String>(this,
							android.R.layout.simple_list_item_1,
							items));
		
		List<String> list=Arrays.asList(items);
		
		Collections.shuffle(list);

		adapter.addSection("Shuffled",
							new ArrayAdapter<String>(this,
							android.R.layout.simple_list_item_1,
							list));
		
		list=Arrays.asList(items);
		
		Collections.shuffle(list);

		adapter.addSection("Re-shuffled",
							new ArrayAdapter<String>(this,
							android.R.layout.simple_list_item_1,
							list));
		
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
}