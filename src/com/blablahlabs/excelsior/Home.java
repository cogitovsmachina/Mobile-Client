package com.blablahlabs.excelsior;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.blablahlabs.excelsior.beans.ExcelsiorBean;
import com.blablahlabs.excelsior.beans.notas.NotaSeccion;
import com.blablahlabs.excelsior.beans.notas.NotaUltimaHora;
import com.blablahlabs.excelsior.net.Net;
import com.blablahlabs.excelsior.recursos.IU;
import com.blablahlabs.excelsior.recursos.Recursos;
import com.blablahlabs.excelsior.recursos.Recursos.Seccion;
import com.blablahlabs.excelsior.recursos.ShareMenu;
import com.commonsware.cwac.merge.MergeAdapter;

public class Home extends ListActivity {
	
    


	private static String[] items={"lorem", "ipsum"};

	private MergeAdapter mMergeAdapter=null;
	private ListAdapter mNotaAdapter=null;
	private ArrayAdapter<String> mArrayAdapter = null;
	private ProgressDialog dialog;
	private Net net;
	private Seccion seccion = Seccion.ULTIMA_HORA;


	private ExcelsiorBean excelsiorBean;
	private MergeAdapter lastNewsAdapter;

	private MergeAdapter nationalAdapter;
	
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		net = new Net(getApplicationContext());
        super.onCreate(savedInstanceState);
        setCustomTitle();
        setContentView(R.layout.main);
        setupViews();
        refresh();       
        
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
		        if (((RadioButton) v).isChecked()) {
					showAllNews();
		        } 
		    }
		});
		
		rNational.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        if (((RadioButton) v).isChecked()) {
					showNational();
		        } 
		    }
		});
		
		rGlobal.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (((RadioButton) v).isChecked()) {
					showGlobal();
				} 
			}
			
		});
		
		rMoney.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        if (((RadioButton) v).isChecked()) {
					showMoney();
		        } 
		    }

		});
		
		rCommunity.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        if (((RadioButton) v).isChecked()) {
					showCommunity();
		        } 
		    }

		});
		
		rAdrenaline.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        if (((RadioButton) v).isChecked()) {
					showAdrenaline();
		        } 
		    }

		});
		
		rFunction.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        if (((RadioButton) v).isChecked()) {
		        	showFunction();
		        } 
		    }

		});
		
		rOpinion.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        if (((RadioButton) v).isChecked()) {
		        	showOpinion();
		        } 
		    }

		});
	}

	/*
	 * 		Creating Headers and Adapters for each List
	 */ 
	private void showAllNews() {
		
		seccion = Seccion.ULTIMA_HORA;
		
   		lastNewsAdapter=new MergeAdapter();
		
		//Ultima Hora
		
		NotaAdapter nAdapter;
		ArrayList<NotaSeccion> itemsSeccionNacional= new ArrayList<NotaSeccion>();
		ArrayList<NotaSeccion> itemsSeccionGlobal = new ArrayList<NotaSeccion>();
		
		ArrayList<NotaSeccion> itemsSeccionDinero = new ArrayList<NotaSeccion>();
		ArrayList<NotaSeccion> itemsSeccionComunidad = new ArrayList<NotaSeccion>();
		ArrayList<NotaSeccion> itemsSeccionAdrenalina = new ArrayList<NotaSeccion>();
		ArrayList<NotaSeccion> itemsSeccionFuncion = new ArrayList<NotaSeccion>();
		
		
		NotaAdapterSeccion nAdapterSeccion;
		
		
		nAdapter = new NotaAdapter(Home.this, R.layout.row, (ArrayList<NotaUltimaHora>) excelsiorBean.getUltimaHora());
		lastNewsAdapter.addAdapter(nAdapter);
		
		//Nacional
		lastNewsAdapter.addView(buildNationalHeader());
		
		 
		itemsSeccionNacional.add(excelsiorBean.getSeccionNacional().get(0));
		itemsSeccionNacional.add(excelsiorBean.getSeccionNacional().get(1));
		
		
		 nAdapterSeccion = new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) itemsSeccionNacional);
		 lastNewsAdapter.addAdapter(nAdapterSeccion);
		
		 
		 
		//Global
		lastNewsAdapter.addView(buildGlobalHeader());
		

		itemsSeccionGlobal.add(excelsiorBean.getSeccionGlobal().get(0));
		itemsSeccionGlobal.add(excelsiorBean.getSeccionGlobal().get(1));
		
		nAdapterSeccion = new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) itemsSeccionGlobal);
		 	lastNewsAdapter.addAdapter(nAdapterSeccion);
		
		 	
		//Dinero
		lastNewsAdapter.addView(buildMoneylHeader());

		itemsSeccionDinero.add(excelsiorBean.getSeccionDinero().get(0));
		itemsSeccionDinero.add(excelsiorBean.getSeccionDinero().get(1));
		
		nAdapterSeccion = new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) itemsSeccionDinero);
		 	lastNewsAdapter.addAdapter(nAdapterSeccion);
		
		 	
		 	
		//Comunidad
		lastNewsAdapter.addView(buildCommunityHeader());

		itemsSeccionComunidad.add(excelsiorBean.getSeccionComunidad().get(0));
		itemsSeccionComunidad.add(excelsiorBean.getSeccionComunidad().get(1));
		
		nAdapterSeccion = new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) itemsSeccionComunidad);
		 	lastNewsAdapter.addAdapter(nAdapterSeccion);
		
		 	
		//Adrenalina
		lastNewsAdapter.addView(buildAdrenalineHeader());

		itemsSeccionAdrenalina.add(excelsiorBean.getSeccionAdrenalina().get(0));
		itemsSeccionAdrenalina.add(excelsiorBean.getSeccionAdrenalina().get(1));
		
		nAdapterSeccion = new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) itemsSeccionAdrenalina);
		 	lastNewsAdapter.addAdapter(nAdapterSeccion);
		 	
		 	
		 	
		//Funcion
		lastNewsAdapter.addView(buildFuntionHeader());

		itemsSeccionFuncion.add(excelsiorBean.getSeccionFuncion().get(0));
		itemsSeccionFuncion.add(excelsiorBean.getSeccionFuncion().get(1));
		
		nAdapterSeccion = new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) itemsSeccionFuncion);
		 	lastNewsAdapter.addAdapter(nAdapterSeccion);	
		 	
		//commit para actualizar la vista 
		setListAdapter(lastNewsAdapter);
		
		
		  
		       
			}
	/*
	 * 		Building National Adapter
	 */
	private void showNational() {	
		seccion = Seccion.NACIONAL;

		setListAdapter(new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) excelsiorBean.getSeccionNacional()));
	
	}
	
	/*
	 * 		Building Global Adapter
	 */
	private void showGlobal() {
		seccion = Seccion.GLOBAL;

		setListAdapter(new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) excelsiorBean.getSeccionGlobal()));
	}
	
	/*
	 * 		Building Money Adapter
	 */
	protected void showMoney() {
		seccion = Seccion.DINERO;

		setListAdapter(new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) excelsiorBean.getSeccionDinero()));
	}

	
	/*
	 * 		Building Community Adapter
	 */
	private void showCommunity() {
		seccion = Seccion.COMUNIDAD;

		setListAdapter(new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) excelsiorBean.getSeccionComunidad()));
	}
	
	/*
	 * 		Building Adrenaline Adapter
	 */
	private void showAdrenaline() {
		seccion = Seccion.ADRENALINA;

		setListAdapter(new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) excelsiorBean.getSeccionAdrenalina()));

	}
	
	/*
	 * 		Building Function Adapter
	 */
	private void showFunction() {
		seccion = Seccion.FUNCION;

		setListAdapter(new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) excelsiorBean.getSeccionFuncion()));

	}
	
	private void showOpinion() {
		seccion = Seccion.OPINION;

		mMergeAdapter=new MergeAdapter();
		
		
		/*
		 * 		Building Opinion Adapter
		 */
		mMergeAdapter.addView(buildOpinionnHeader());
		mMergeAdapter.addAdapter(buildOpinionList());			
		setListAdapter(mMergeAdapter);	
	}

	
	
	/*
	 * 		Last News Header
	 */
	private View buildLastNewsHeader() {
		TextView national = new TextView(this);		
		national.setCursorVisible(false);
		national.setFocusable(false);
		national.setClickable(false);
		national.setText("Ultimas Noticias");
		national.setTextSize(15);
		national.setClickable(false);
		national.setFocusableInTouchMode(false);
		national.setBackgroundResource(R.drawable.gradient_national_header);
		return(national);  	
	}	
	
	
	/*
	 * 		Last News
	 */
	private ArrayAdapter<String> buildLastNewsList() {
		return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}
	
	
	/*
	 * 		National Header
	 */
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
	
	/*
	 * 		National ListView
	 */
	private ListAdapter buildNationalList() {
		//ExcelsiorBean excelsiorBean = null ;
		//excelsiorBean.getSeccionNacional();
		//ArrayList<SeccionNacional> list = new ArrayList<SeccionNacional>();
		
		

//		return(new ArrayAdapter<String>(this,
//											android.R.layout.simple_list_item_1,
//											list));
//		return(new ArrayAdapter<NotaSeccion>(this,
//								R.layout.row,
//								 list));

		
		return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));

	}	


	/*
	 * 		Global Header
	 */
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
        
	
	/*
	 * 		Global ListView
	 */
	private ListAdapter buildGlobalList() {
		return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}
	
	
	/*
	 * 		Money Header
	 */
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
	
	
	/*
	 * 		Money ListView
	 */
	private ListAdapter buildMoneyList() {
		return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}
	
	
	/*
	 * 		Community Header
	 */
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
	
	
	
	/*
	 * 		Community ListView
	 */
	private ListAdapter buildCommunityList() {
		return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}

	/*
	 * 		Adrenaline Header
	 */
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
	
	/*
	*          Adrenaline ListView
	*/
	
	private ListAdapter buildAdrenalineList() {
		return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}
	
	/*
	*          Opinion Header
	*/
	
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
    
    /*
	*      	Function Header
	*/
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
	
	/*
	*      	Function ListView
	*/
	private ListAdapter buildFunctionList() {
		return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}


	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx	

	
	/*
	*      Setting Custom Title :)
	*/
	
    public void setCustomTitle() {
    	requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.window_title);
        
	}
    
    /*
	*      Inflating the option Menu
	*/
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }
    
	
	/*
	*  Giving logic to the option menu 
	*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share_image: 
            	ShareMenu.buildHomeShareMenu(getApplicationContext());
            	//buildShareMenu();
            	IU.showToast(getApplicationContext(), "this");
                                break;
            case R.id.gallery_image:     
            	Toast.makeText(this, "You want to go to gallery!", Toast.LENGTH_LONG).show();
                                break;
            case R.id.movies_image: 
            	Toast.makeText(this, "You want to go to movies!", Toast.LENGTH_LONG).show();
                                break;
            case R.id.refresh: 
            	refresh();
                                break;
        }
        return true;
    }
    
//    /*
//     *  Method to create ACTION_SEND Implementation :) 
//     */
//    private void buildShareMenu() {
//    	Intent mIntent = new Intent(android.content.Intent.ACTION_SEND);
//    	mIntent.setType("text/plain");
//    	mIntent.putExtra(Intent.EXTRA_TEXT, "Yo estoy informado con Excelsior para Android http://excelsior.com.mx");
//    	startActivity(Intent.createChooser(mIntent, "Compartir en"));		
//    }
    
    
    private void refresh() {
			new DownloadFilesTask().execute();
	}

	
	private class DownloadFilesTask extends AsyncTask<URL, Void, ExcelsiorBean> {
        
		protected void onPreExecute(){
    		dialog= ProgressDialog.show(Home.this, "Actualizando", "Actualizando los contenidos", true);
    		return;
    	}
    	
    	
    	protected ExcelsiorBean doInBackground(URL... urls) {
    		
    		ExcelsiorBean ans = null;
            try {
            	ans = net.getDataBean();
            	


			} catch (Exception e) {
				Log.e(Recursos.APP,"Ocurrio un error");
				Log.e(Recursos.APP,e.toString());
				e.printStackTrace();
			}
			
		
            return ans ;
        }
        

        protected void onPostExecute(ExcelsiorBean excelsiorBean_) {
        	dialog.dismiss();
        	if (excelsiorBean_ == null){
        		Toast.makeText(getApplicationContext(), "Ha ocurrido un error, intŽntalo m‡s tarde", Toast.LENGTH_SHORT).show();
        		
        	
        	}else{
        		
        		excelsiorBean=excelsiorBean_;
        		
        		showAllNews();
        }        		        		
        		
        	}


		

    }


	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
	 	lastNewsAdapter.getItem(position);
	 	
	 	Integer idNota = null;
	 			
	 	switch (seccion) {
		case ULTIMA_HORA:
			
			if (position >=0 && position <= 14){
				idNota= excelsiorBean.getUltimaHora().get(position).idNota;
			}

			else if (position >=16 && position <= 17){
				idNota= excelsiorBean.getSeccionNacional().get(position-16).idNota;
			}
			else if (position >=19 && position <= 20){
				idNota= excelsiorBean.getSeccionGlobal().get(position-19).idNota;
			}
			else if (position >=22 && position <= 23){
				idNota= excelsiorBean.getSeccionDinero().get(position-22).idNota;
			}
			else if (position >=25 && position <= 26){
				idNota= excelsiorBean.getSeccionComunidad().get(position-25).idNota;
			}
			else if (position >=28 && position <= 29){
				idNota= excelsiorBean.getSeccionAdrenalina().get(position-28).idNota;
			}
			else if (position >=31 && position <= 32){
				idNota= excelsiorBean.getSeccionFuncion().get(position-31).idNota;
			}
			
			break;
		case NACIONAL:
			idNota= excelsiorBean.getSeccionNacional().get(position).idNota;
			break;
		case GLOBAL:
			idNota= excelsiorBean.getSeccionGlobal().get(position).idNota;
			break;
		case DINERO:
			idNota= excelsiorBean.getSeccionDinero().get(position).idNota;
			break;
		case COMUNIDAD:
			idNota= excelsiorBean.getSeccionComunidad().get(position).idNota;
			break;
		case ADRENALINA:
			idNota= excelsiorBean.getSeccionAdrenalina().get(position).idNota;
			break;
		case FUNCION:
			idNota= excelsiorBean.getSeccionFuncion().get(position).idNota;
			break;	
		
		case OPINION:	
			break;
			
		default: 
			break;
				
	}
	 	
	 	if (idNota != null){	 	
			Intent i = new Intent(getApplication(), NoteActivity.class);  
			i.putExtra("id_nota", idNota);
			startActivity(i);
	 	}
	
	}
		
		 
}
	
	
	
    
   
    
