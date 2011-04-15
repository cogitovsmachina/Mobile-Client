package com.blablahlabs.excelsior;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.androidtitlan.ac.sharemenu.ShareMenu;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.blablahlabs.excelsior.asynctasks.AsyncNotes;
import com.blablahlabs.excelsior.beans.ExcelsiorBean;
import com.blablahlabs.excelsior.beans.notas.NotaOpinion;
import com.blablahlabs.excelsior.beans.notas.NotaSeccion;
import com.blablahlabs.excelsior.recursos.IU;
import com.blablahlabs.excelsior.recursos.Recursos;
import com.blablahlabs.excelsior.recursos.Recursos.Seccion;
import com.commonsware.cwac.merge.MergeAdapter;

public class Home extends ListActivity {
	private static String[] items={"lorem", "ipsum"};

	private MergeAdapter mMergeAdapter=null;
	private Seccion seccion = Seccion.ULTIMA_HORA;
	public ExcelsiorBean excelsiorBean;
	private MergeAdapter lastNewsAdapter;

	
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
		
		
		NotaAdapterSeccion nAdapterSeccion;

		
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

//		mMergeAdapter=new MergeAdapter();
		
		setListAdapter(new NotaAdapterOpinion(Home.this, R.layout.row, (ArrayList<NotaOpinion>) excelsiorBean.getOpinion()));

//		
//		mMergeAdapter.addView(buildHeader("Opini—n", R.drawable.gradient_opinion_header));
//		mMergeAdapter.addAdapter(buildOpinionList());			
//		setListAdapter(mMergeAdapter);	
//		
		
	}
	
	//Opinion ListView
    private ListAdapter buildOpinionList() {
    	return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
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
	
@SuppressWarnings("unused")
private View setTempAd(int drawable){
		ImageView imageView = new ImageView(this);		
		imageView.setBackgroundResource(drawable);
		imageView.setAdjustViewBounds(true);
		return(imageView);	  	
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
			

			if (position >=1 && position <= 2){
				idNota= excelsiorBean.getSeccionNacional().get(position-1).idNota;
				idFoto= excelsiorBean.getSeccionNacional().get(position-1).idFotoPortada;
			}
			else if (position >=4 && position <= 5){
				idNota= excelsiorBean.getSeccionGlobal().get(position-4).idNota;
				idFoto= excelsiorBean.getSeccionGlobal().get(position-4).idFotoPortada;
			}
			else if (position >=7 && position <= 8){
				idNota= excelsiorBean.getSeccionDinero().get(position-7).idNota;
				idFoto= excelsiorBean.getSeccionDinero().get(position-7).idFotoPortada;
			}
			else if (position >=10 && position <= 11){
				idNota= excelsiorBean.getSeccionComunidad().get(position-10).idNota;
				idFoto= excelsiorBean.getSeccionComunidad().get(position-10).idFotoPortada;
			}
			else if (position >=13 && position <= 14){
				idNota= excelsiorBean.getSeccionAdrenalina().get(position-13).idNota;
				idFoto= excelsiorBean.getSeccionAdrenalina().get(position-13).idFotoPortada;
			}
			else if (position >=16 && position <= 17){
				idNota= excelsiorBean.getSeccionFuncion().get(position-16).idNota;
				idFoto= excelsiorBean.getSeccionFuncion().get(position-16).idFotoPortada;
			}
			
			break;
		case NACIONAL:
			idNota= excelsiorBean.getSeccionNacional().get(position).idNota;
			idFoto= excelsiorBean.getSeccionNacional().get(position).idFotoPortada;
			break;
		case GLOBAL:
			idNota= excelsiorBean.getSeccionGlobal().get(position).idNota;
			idFoto= excelsiorBean.getSeccionGlobal().get(position).idFotoPortada;
			break;
		case DINERO:
			idNota= excelsiorBean.getSeccionDinero().get(position).idNota;
			idFoto= excelsiorBean.getSeccionDinero().get(position).idFotoPortada;
			break;
		case COMUNIDAD:
			idNota= excelsiorBean.getSeccionComunidad().get(position).idNota;
			idFoto= excelsiorBean.getSeccionComunidad().get(position).idFotoPortada;
			break;
		case ADRENALINA:
			idNota= excelsiorBean.getSeccionAdrenalina().get(position).idNota;
			idFoto= excelsiorBean.getSeccionAdrenalina().get(position).idFotoPortada;
			break;
		case FUNCION:
			idNota= excelsiorBean.getSeccionFuncion().get(position).idNota;
			idFoto= excelsiorBean.getSeccionFuncion().get(position).idFotoPortada;
			break;	
		
		case OPINION:	
			idNota= excelsiorBean.getOpinion().get(position).idNota;
			idFoto= excelsiorBean.getOpinion().get(position).idFotoPortada;
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
	
	
	
    
   
    
