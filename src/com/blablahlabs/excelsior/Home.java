package com.blablahlabs.excelsior;

import java.util.ArrayList;
import java.util.Arrays;


import com.commonsware.cwac.merge.MergeAdapter;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class Home extends ListActivity {
	private static String[] items={"lorem", "ipsum"};

	private MergeAdapter mMergeAdapter=null;
	private ArrayAdapter<String> mArrayAdapter=null;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomTitle();
        setContentView(R.layout.main);
        setupViews();
        showAllNews();
  
	}

	private void setupViews() {
		final RadioButton rLastNews = (RadioButton)findViewById(R.id.last_hour);
		final RadioButton rNational = (RadioButton)findViewById(R.id.national);
		final RadioButton rGlobal = (RadioButton)findViewById(R.id.global);
		final RadioButton rMoney = (RadioButton)findViewById(R.id.money);
		final RadioButton rCommunity = (RadioButton)findViewById(R.id.community);
		final RadioButton rAdrenaline = (RadioButton)findViewById(R.id.adrenaline);
		final RadioButton rFunction = (RadioButton)findViewById(R.id.show);
		final RadioButton rOpinion = (RadioButton)findViewById(R.id.opinion);
		
		rLastNews.setPressed(true);
		
		rLastNews.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        // Perform action on clicks, depending on whether it's now checked
		        if (((RadioButton) v).isChecked()) {
					showAllNews();
		        } 
		    }
		});
		
		rNational.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        // Perform action on clicks, depending on whether it's now checked
		        if (((RadioButton) v).isChecked()) {
					showNational();
		        } 
		    }
		});
		
		rGlobal.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Perform action on clicks, depending on whether it's now checked
				if (((RadioButton) v).isChecked()) {
					showGlobal();
					Toast.makeText(Home.this, "Selected", Toast.LENGTH_SHORT).show();
				} 
			}
			
		});
		
		rMoney.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        // Perform action on clicks, depending on whether it's now checked
		        if (((RadioButton) v).isChecked()) {
					showMoney();
		        } 
		    }

		});
		
		rCommunity.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        // Perform action on clicks, depending on whether it's now checked
		        if (((RadioButton) v).isChecked()) {
					showCommunity();
		        } 
		    }

		});
		
		rAdrenaline.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        // Perform action on clicks, depending on whether it's now checked
		        if (((RadioButton) v).isChecked()) {
					showAdrenaline();
		        } 
		    }

		});
		
		rFunction.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        // Perform action on clicks, depending on whether it's now checked
		        if (((RadioButton) v).isChecked()) {
		        	showFunction();
		        } 
		    }

		});
		
		rOpinion.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        // Perform action on clicks, depending on whether it's now checked
		        if (((RadioButton) v).isChecked()) {
		        	showOpinion();
		        } 
		    }

		});
		
		

	}


	private void showAllNews() {
		//Creating Headers and Adapters for each List
		        
		        mMergeAdapter=new MergeAdapter();
		        
		        //Last News List
		        mArrayAdapter=buildLastNewsList();
				mMergeAdapter.addAdapter(mArrayAdapter);
				
				//National
				mMergeAdapter.addView(buildNationalHeader());
				mMergeAdapter.addAdapter(buildNationalList());
				
				//Global
				mMergeAdapter.addView(buildGlobalHeader());
				mMergeAdapter.addAdapter(buildGlobalList());
				
				//Money
				mMergeAdapter.addView(buildMoneylHeader());
				mMergeAdapter.addAdapter(buildMoneyList());
				
				//Community
				mMergeAdapter.addView(buildCommunityHeader());
				mMergeAdapter.addAdapter(buildCommunityList());
				
				//Adrenaline
				mMergeAdapter.addView(buildAdrenalineHeader());
				mMergeAdapter.addAdapter(buildAdrenalineList());
				
				//Function
				mMergeAdapter.addView(buildFuntionHeader());
				mMergeAdapter.addAdapter(buildFunctionList());
				
				//Opinion
				mMergeAdapter.addView(buildOpinionnHeader());
				mMergeAdapter.addAdapter(buildOpinionList());
				
				setListAdapter(mMergeAdapter);		
			}
	
	private void showNational() {
		  	mMergeAdapter=new MergeAdapter();
			
			//National
			mMergeAdapter.addView(buildNationalHeader());
			mMergeAdapter.addAdapter(buildNationalList());			
			setListAdapter(mMergeAdapter);		
		
	}
	protected void showMoney() {
		mMergeAdapter=new MergeAdapter();
		
		//Money
		mMergeAdapter.addView(buildMoneylHeader());
		mMergeAdapter.addAdapter(buildMoneyList());			
		setListAdapter(mMergeAdapter);	
	}

	private void showGlobal() {
		mMergeAdapter=new MergeAdapter();
		
		//Global
		mMergeAdapter.addView(buildGlobalHeader());
		mMergeAdapter.addAdapter(buildGlobalList());			
		setListAdapter(mMergeAdapter);	
	}
	
	private void showCommunity() {
		mMergeAdapter=new MergeAdapter();
		
		//Community
		mMergeAdapter.addView(buildCommunityHeader());
		mMergeAdapter.addAdapter(buildCommunityList());			
		setListAdapter(mMergeAdapter);	
	}
	
	private void showAdrenaline() {
		mMergeAdapter=new MergeAdapter();
		
		//Community
		mMergeAdapter.addView(buildAdrenalineHeader());
		mMergeAdapter.addAdapter(buildAdrenalineList());			
		setListAdapter(mMergeAdapter);	
	}
	
	private void showFunction() {
		mMergeAdapter=new MergeAdapter();
		
		//Community
		mMergeAdapter.addView(buildFuntionHeader());
		mMergeAdapter.addAdapter(buildFunctionList());			
		setListAdapter(mMergeAdapter);	
	}
	
	private void showOpinion() {
		mMergeAdapter=new MergeAdapter();
		
		//Community
		mMergeAdapter.addView(buildOpinionnHeader());
		mMergeAdapter.addAdapter(buildOpinionList());			
		setListAdapter(mMergeAdapter);	
	}

	
	

	//Last News
	private ArrayAdapter<String> buildLastNewsList() {
		return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}
	
	//National Header
	private View buildNationalHeader() {
		TextView national = new TextView(this);		
		national.setCursorVisible(false);
		national.setFocusable(false);
		national.setClickable(false);
		national.setText("Nacional");
		national.setTextSize(30);
		national.setClickable(false);
		national.setFocusableInTouchMode(false);
		national.setBackgroundResource(R.drawable.gradient_national_header);
		return(national);  	
	}	
	
	//National ListView
	private ListAdapter buildNationalList() {
		return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}

	//Global Header
	private View buildGlobalHeader() {
		TextView global = new TextView(this);		
		global.setCursorVisible(false);
		global.setFocusable(false);
		global.setClickable(false);
		global.setText("Global");
		global.setTextSize(30);
		global.setClickable(false);
		global.setFocusableInTouchMode(false);
		global.setBackgroundResource(R.drawable.gradient_global_header);
		return(global);  	
	}
        
	//Global ListView
	private ListAdapter buildGlobalList() {
		return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}
	
	//Money Header
	private View buildMoneylHeader() {
		TextView money = new TextView(this);		
		money.setCursorVisible(false);
		money.setFocusable(false);
		money.setClickable(false);
		money.setText("Dinero");
		money.setTextSize(30);
		money.setClickable(false);
		money.setFocusableInTouchMode(false);
		money.setBackgroundResource(R.drawable.gradient_money_header);
		return(money);    	
	}
	
	//Money ListView
	private ListAdapter buildMoneyList() {
		return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}
	
	//Community Header
	private View buildCommunityHeader() {
		TextView community = new TextView(this);		
		community.setCursorVisible(false);
		community.setFocusable(false);
		community.setClickable(false);
		community.setText("Comunidad");
		community.setTextSize(30);
		community.setClickable(false);
		community.setFocusableInTouchMode(false);
		community.setBackgroundResource(R.drawable.gradient_community_header);
		return(community);  
	}
	
	//Community ListView
	private ListAdapter buildCommunityList() {
		return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}

	//Adrenaline Header
	private View buildAdrenalineHeader() {
		TextView adrenaline = new TextView(this);		
		adrenaline.setCursorVisible(false);
		adrenaline.setFocusable(false);
		adrenaline.setClickable(false);
		adrenaline.setText("Adrenalina");
		adrenaline.setTextSize(30);
		adrenaline.setClickable(false);
		adrenaline.setFocusableInTouchMode(false);
		adrenaline.setBackgroundResource(R.drawable.gradient_adrenaline_header);
		return(adrenaline);  
	}
	
	//Adrenaline ListView
	private ListAdapter buildAdrenalineList() {
		return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}
	
    //Opinion Header
	private View buildOpinionnHeader() {
		TextView opinion = new TextView(this);		
		opinion.setCursorVisible(false);
		opinion.setFocusable(false);
		opinion.setClickable(false);
		opinion.setText("Opini—n");
		opinion.setTextSize(30);
		opinion.setClickable(false);
		opinion.setFocusableInTouchMode(false);
		opinion.setBackgroundResource(R.drawable.gradient_opinion_header);
		return(opinion);
	}
	
	//Opinion ListView
    private ListAdapter buildOpinionList() {
    	return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}
    
	//Function Header
	private View buildFuntionHeader() {
		TextView function = new TextView(this);		
		function.setCursorVisible(false);
		function.setFocusable(false);
		function.setClickable(false);
		function.setText("Funci—n");
		function.setTextSize(30);
		function.setClickable(false);
		function.setFocusableInTouchMode(false);
		function.setBackgroundResource(R.drawable.gradient_function_header);
		return(function); 	
		}
	
	//Function ListView
	private ListAdapter buildFunctionList() {
		return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}


	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx	

	//Setting Custom Title :)
    private void setCustomTitle() {
    	requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
        
	}
    //Inflating the option Menu
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }
    
	
	//Giving logic to the option menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share_image:   
            	buildShareMenu();
                                break;
            case R.id.gallery_image:     
            	Toast.makeText(this, "You want to go to gallery!", Toast.LENGTH_LONG).show();
                                break;
            case R.id.movies_image: 
            	Toast.makeText(this, "You want to go to movies!", Toast.LENGTH_LONG).show();
                                break;
        }
        return true;
    }
    //Method to create ACTION_SEND Implementation :)
	private void buildShareMenu() {
		Intent mIntent = new Intent(android.content.Intent.ACTION_SEND);
		mIntent.setType("text/plain");
		mIntent.putExtra(Intent.EXTRA_TEXT, "Yo estoy informado con Excelsior para Android http://excelsior.com.mx");
		startActivity(Intent.createChooser(mIntent, "Compartir en"));		
	}
	
	
		
		 
}
	
	
	
    
   
    
