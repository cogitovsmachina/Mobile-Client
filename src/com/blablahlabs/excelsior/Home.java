package com.blablahlabs.excelsior;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.androidtitlan.ac.sharemenu.ShareMenu;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.blablahlabs.excelsior.asynctasks.AsyncNotes;
import com.blablahlabs.excelsior.beans.ExcelsiorBean;
import com.blablahlabs.excelsior.beans.notas.NotaOpinion;
import com.blablahlabs.excelsior.beans.notas.NotaSeccion;
import com.blablahlabs.excelsior.recursos.IU;
import com.blablahlabs.excelsior.recursos.Recursos;
import com.blablahlabs.excelsior.recursos.Recursos.Seccion;
import com.commonsware.cwac.merge.MergeAdapter;
import com.blablahlabs.excelsior.ImageLoader;

public class Home extends ListActivity {
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}


	@Override
	protected void onDestroy() {
		ImageLoader mImageLoader = new ImageLoader(this);
		mImageLoader.clearCache();
		super.onDestroy();
	}
	
	private MergeAdapter mMergeAdapter=null;
	private Seccion seccion = Seccion.ULTIMA_HORA;
	public static ExcelsiorBean excelsiorBean;
	private MergeAdapter lastNewsAdapter;
	private NotaAdapterOpinion nAdapterOpinion;
	private MergeAdapter mNationalMergeAdapter;
	private MergeAdapter mGlobalMergeAdapter;
	private MergeAdapter mMoneyAdapter;
	private MergeAdapter mCommunityAdapter;
	private MergeAdapter mAdrenalineAdapter;
	private MergeAdapter mFunctionAdapter;
	private MergeAdapter mOpinionAdapter;

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IU.setCustomTitle(this);	
        setContentView(R.layout.main);
        setupViews(); 
        updateNews();
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
		
		rLastNews.setChecked(true);
		
		rLastNews.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
		        if (((RadioButton) v).isChecked()) {
					showMainList();
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
	public void showMainList() {
		
		seccion = Seccion.ULTIMA_HORA;
		
   		lastNewsAdapter=new MergeAdapter();
		
   		
		//Ultima Hora
		
//		NotaAdapter nAdapter;
		ArrayList<NotaSeccion> itemsSeccionNacional= new ArrayList<NotaSeccion>();
		ArrayList<NotaSeccion> itemsSeccionGlobal = new ArrayList<NotaSeccion>();
		
		ArrayList<NotaSeccion> itemsSeccionDinero = new ArrayList<NotaSeccion>();
		ArrayList<NotaSeccion> itemsSeccionComunidad = new ArrayList<NotaSeccion>();
		ArrayList<NotaSeccion> itemsSeccionAdrenalina = new ArrayList<NotaSeccion>();
		ArrayList<NotaSeccion> itemsSeccionFuncion = new ArrayList<NotaSeccion>();
		ArrayList<NotaOpinion> itemsSeccionOpinion = new ArrayList<NotaOpinion>();
		
		
		NotaAdapterSeccion nAdapterSeccion;

		//Ads
		lastNewsAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		
		//Nacional
		lastNewsAdapter.addView(buildHeader("Nacional", R.drawable.gradient_national_header));
		
		 
		itemsSeccionNacional.add(excelsiorBean.getSeccionNacional().get(0));
		itemsSeccionNacional.add(excelsiorBean.getSeccionNacional().get(1));
		
		
		 nAdapterSeccion = new NotaAdapterSeccion(Home.this, R.layout.row, itemsSeccionNacional);
		 lastNewsAdapter.addAdapter(nAdapterSeccion);
		
		 
		 
		//Global
		lastNewsAdapter.addView(buildHeader("Global", R.drawable.gradient_global_header));
		

		itemsSeccionGlobal.add(excelsiorBean.getSeccionGlobal().get(0));
		itemsSeccionGlobal.add(excelsiorBean.getSeccionGlobal().get(1));
		
		nAdapterSeccion = new NotaAdapterSeccion(Home.this, R.layout.row, itemsSeccionGlobal);
		 	lastNewsAdapter.addAdapter(nAdapterSeccion);
		
		 	
		//Dinero
		lastNewsAdapter.addView(buildHeader("Dinero", R.drawable.gradient_money_header));

		itemsSeccionDinero.add(excelsiorBean.getSeccionDinero().get(0));
		itemsSeccionDinero.add(excelsiorBean.getSeccionDinero().get(1));
		
		nAdapterSeccion = new NotaAdapterSeccion(Home.this, R.layout.row, itemsSeccionDinero);
		 	lastNewsAdapter.addAdapter(nAdapterSeccion);
		
		//Ads
		lastNewsAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		 	
		//Comunidad
		lastNewsAdapter.addView(buildHeader("Comunidad", R.drawable.gradient_community_header));

		itemsSeccionComunidad.add(excelsiorBean.getSeccionComunidad().get(0));
		itemsSeccionComunidad.add(excelsiorBean.getSeccionComunidad().get(1));
		
		nAdapterSeccion = new NotaAdapterSeccion(Home.this, R.layout.row, itemsSeccionComunidad);
		 	lastNewsAdapter.addAdapter(nAdapterSeccion);
		
		 	
		//Adrenalina
		lastNewsAdapter.addView(buildHeader("Adrenalina", R.drawable.gradient_adrenaline_header));

		itemsSeccionAdrenalina.add(excelsiorBean.getSeccionAdrenalina().get(0));
		itemsSeccionAdrenalina.add(excelsiorBean.getSeccionAdrenalina().get(1));
		
		nAdapterSeccion = new NotaAdapterSeccion(Home.this, R.layout.row, itemsSeccionAdrenalina);
		 	lastNewsAdapter.addAdapter(nAdapterSeccion);
		 	
		 	
		 	
		//Funcion
		lastNewsAdapter.addView(buildHeader("Funci—n", R.drawable.gradient_function_header));

		itemsSeccionFuncion.add(excelsiorBean.getSeccionFuncion().get(0));
		itemsSeccionFuncion.add(excelsiorBean.getSeccionFuncion().get(1));
		
		nAdapterSeccion = new NotaAdapterSeccion(Home.this, R.layout.row, itemsSeccionFuncion);
		 	lastNewsAdapter.addAdapter(nAdapterSeccion);
		 	
		 	
		//Opinion
		lastNewsAdapter.addView(buildHeader("Opini—n", R.drawable.gradient_opinion_header));

		itemsSeccionOpinion.add(excelsiorBean.getOpinion().get(0));
		itemsSeccionOpinion.add(excelsiorBean.getOpinion().get(1));
		
		nAdapterOpinion = new NotaAdapterOpinion(Home.this, R.layout.row, itemsSeccionOpinion);
		lastNewsAdapter.addAdapter(nAdapterOpinion);
		
		//Ads
		lastNewsAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		 	
		//commit para actualizar la vista 
		setListAdapter(lastNewsAdapter);
		
		
		  
		       
			}
	/*
	 * 		Building National Adapter
	 */
	private void showNational() {	
		seccion = Seccion.NACIONAL;
		
   		mNationalMergeAdapter=new MergeAdapter();

		mNationalMergeAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		mNationalMergeAdapter.addAdapter(new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) excelsiorBean.getSeccionNacional()));
		mNationalMergeAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		setListAdapter(mNationalMergeAdapter);		
		
	
	}
	
	/*
	 * 		Building Global Adapter
	 */
	private void showGlobal() {
		seccion = Seccion.GLOBAL;
		
		mGlobalMergeAdapter = new MergeAdapter();

		mGlobalMergeAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		mGlobalMergeAdapter.addAdapter(new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) excelsiorBean.getSeccionGlobal()));
		mGlobalMergeAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		setListAdapter(mGlobalMergeAdapter);		

	}
	
	/*
	 * 		Building Money Adapter
	 */
	protected void showMoney() {
		seccion = Seccion.DINERO;

		mMoneyAdapter = new MergeAdapter();

		mMoneyAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		mMoneyAdapter.addAdapter(new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) excelsiorBean.getSeccionDinero()));
		mMoneyAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		setListAdapter(mMoneyAdapter);
	}

	
	/*
	 * 		Building Community Adapter
	 */
	private void showCommunity() {
		seccion = Seccion.COMUNIDAD;

		mCommunityAdapter = new MergeAdapter();

		mCommunityAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		mCommunityAdapter.addAdapter(new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) excelsiorBean.getSeccionComunidad()));
		mCommunityAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		setListAdapter(mCommunityAdapter);
	}
	
	/*
	 * 		Building Adrenaline Adapter
	 */
	private void showAdrenaline() {
		seccion = Seccion.ADRENALINA;
		
		mAdrenalineAdapter = new MergeAdapter();

		mAdrenalineAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		mAdrenalineAdapter.addAdapter(new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) excelsiorBean.getSeccionAdrenalina()));
		mAdrenalineAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		setListAdapter(mAdrenalineAdapter);
		
	}
	
	/*
	 * 		Building Function Adapter
	 */
	private void showFunction() {
		seccion = Seccion.FUNCION;
		
		mFunctionAdapter = new MergeAdapter();

		mFunctionAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		mFunctionAdapter.addAdapter(new NotaAdapterSeccion(Home.this, R.layout.row, (ArrayList<NotaSeccion>) excelsiorBean.getSeccionFuncion()));
		mFunctionAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		setListAdapter(mFunctionAdapter);

	}
	
	private void showOpinion() {
		seccion = Seccion.OPINION;

		mOpinionAdapter=new MergeAdapter();
		mOpinionAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		mOpinionAdapter.addAdapter(new NotaAdapterOpinion(Home.this, R.layout.row, (ArrayList<NotaOpinion>) excelsiorBean.getOpinion()));
		mOpinionAdapter.addView(setAd("file:///android_asset/ad.html"), true);
		setListAdapter(mOpinionAdapter);
				
	}
	
    
	private View buildHeader(String title, int background){
		
		TextView textview = new TextView(this);		
		textview.setCursorVisible(false);
		textview.setFocusable(false);
		textview.setClickable(false);
		textview.setFocusableInTouchMode(false);
		textview.setText(title);
		textview.setTextSize(20);
		textview.setTypeface(Typeface.DEFAULT_BOLD);
		textview.setBackgroundResource(background);
		return(textview);	  	
		
	}
	
private WebView setAd(String file){
		WebView ad = new WebView(this);	
		ad.loadUrl(file);
		ad.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		//		ad.setBackgroundColor(R.color.background_ad);
		return(ad);	  	
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
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
        switch (item.getItemId()) {
            case R.id.share_image: 
            	ShareMenu.buildShareMenu(getApplicationContext(),
            	Recursos.TITULO_COMPARTIR,
            	Recursos.COMPARTIR_HOME);
            	break;
            	
            case R.id.gallery_image:
            	ByteArrayOutputStream byteAO = new ByteArrayOutputStream();
            	ObjectOutput output;
            	try {
            		output = new ObjectOutputStream(byteAO);
            		output.writeObject(excelsiorBean.getFotoGaleria());
            	} catch (IOException e) {
            		e.printStackTrace();
            		IU.showToast(Home.this , "Hubo un error al serializar: " + e.getLocalizedMessage());
            	}   
            	byte[] bytes = byteAO.toByteArray();
            	
				startActivity( new Intent(this, GalleryListActivity.class).putExtra("bean", bytes));
            	break;
            	
            case R.id.movies_image:            	
            	ByteArrayOutputStream bos = new ByteArrayOutputStream();
            	ObjectOutput out;
            	try {
            		out = new ObjectOutputStream(bos);
            		out.writeObject(excelsiorBean.getVideosPagina());
            	} catch (IOException e) {
            		e.printStackTrace();
            		IU.showToast(Home.this , "Hubo un error al serializar: " + e.getLocalizedMessage());
            	}   
            	byte[] bytes1 = bos.toByteArray();
            	
				startActivity( new Intent(this, VideoListActivity.class).putExtra("bean", bytes1));
				break;
				
            case R.id.refresh: 
            	updateNews();
            	break;
        }
        return true;
    }
    
    private void updateNews() { 
			new AsyncNotes(this).execute();
	} 

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
	 	
	 	Integer idNota = null;
	 	Integer idFoto = null;
	 			
	 	switch (seccion) {
		case ULTIMA_HORA:
			

			if (position >=2 && position <= 3){
				idNota= excelsiorBean.getSeccionNacional().get(position-2).idNota;
				idFoto= excelsiorBean.getSeccionNacional().get(position-2).idFotoPortada;
			}
			else if (position >=5 && position <= 6){
				idNota= excelsiorBean.getSeccionGlobal().get(position-5).idNota;
				idFoto= excelsiorBean.getSeccionGlobal().get(position-5).idFotoPortada;
			}
			else if (position >=8 && position <= 9){
				idNota= excelsiorBean.getSeccionDinero().get(position-8).idNota;
				idFoto= excelsiorBean.getSeccionDinero().get(position-8).idFotoPortada;
			}
			else if (position >=12 && position <= 13){
				idNota= excelsiorBean.getSeccionComunidad().get(position-12).idNota;
				idFoto= excelsiorBean.getSeccionComunidad().get(position-12).idFotoPortada;
			}
			else if (position >=15 && position <= 16){
				idNota= excelsiorBean.getSeccionAdrenalina().get(position-15).idNota;
				idFoto= excelsiorBean.getSeccionAdrenalina().get(position-15).idFotoPortada;
			}
			else if (position >=18 && position <= 19){
				idNota= excelsiorBean.getSeccionFuncion().get(position-18).idNota;
				idFoto= excelsiorBean.getSeccionFuncion().get(position-18).idFotoPortada;
			}
			else if (position >=21 && position <= 22){
				idNota = excelsiorBean.getOpinion().get(position-21).idNota;
				idFoto = excelsiorBean.getOpinion().get(position-21).idFotoPortada;
			}
			
			break;
		case NACIONAL:
			idNota= excelsiorBean.getSeccionNacional().get(position-1).idNota;
			idFoto= excelsiorBean.getSeccionNacional().get(position-1).idFotoPortada;
			break;
		case GLOBAL:
			idNota= excelsiorBean.getSeccionGlobal().get(position-1).idNota;
			idFoto= excelsiorBean.getSeccionGlobal().get(position-1).idFotoPortada;
			break;
		case DINERO:
			idNota= excelsiorBean.getSeccionDinero().get(position-1).idNota;
			idFoto= excelsiorBean.getSeccionDinero().get(position-1).idFotoPortada;
			break;
		case COMUNIDAD:
			idNota= excelsiorBean.getSeccionComunidad().get(position-1).idNota;
			idFoto= excelsiorBean.getSeccionComunidad().get(position-1).idFotoPortada;
			break;
		case ADRENALINA:
			idNota= excelsiorBean.getSeccionAdrenalina().get(position-1).idNota;
			idFoto= excelsiorBean.getSeccionAdrenalina().get(position-1).idFotoPortada;
			break;
		case FUNCION:
			idNota= excelsiorBean.getSeccionFuncion().get(position-1).idNota;
			idFoto= excelsiorBean.getSeccionFuncion().get(position-1).idFotoPortada;
			break;	
		
		case OPINION:	
			idNota= excelsiorBean.getOpinion().get(position-1).idNota;
			idFoto= excelsiorBean.getOpinion().get(position-1).idFotoPortada;
			break;
			
		default: 
			break;
				
	}
	 	
	 	if (idNota != null){	 	
			Intent i = new Intent(getApplication(), ViewNoteActivity.class);  
			i.putExtra("id_nota", idNota);
			i.putExtra("id_foto", idFoto);
			startActivity(i);
	 	}
	
	}
	
}
	
	
	
    
   
    
