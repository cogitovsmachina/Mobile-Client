package com.blablahlabs.excelsior;

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
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.blablahlabs.excelsior.asynctasks.AsyncNotes;
import com.blablahlabs.excelsior.beans.ExcelsiorBean;
import com.blablahlabs.excelsior.beans.notas.NotaSeccion;
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
        setCustomTitle();	
        setContentView(R.layout.main);
        setupViews();
        refresh();}

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

		});}

	/*
	 * 		Creating Headers and Adapters for each List
	 */ 
	public void showMainList() {
		
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
		
		//lastNewsAdapter.addView(setTempAd(R.drawable.ad_space));

		
		nAdapter = new NotaAdapter(Home.this, R.layout.row, excelsiorBean.getUltimaHora());
		lastNewsAdapter.addAdapter(nAdapter);
		
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
		lastNewsAdapter.addView(buildHeader("Funci�n", R.drawable.gradient_function_header));

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

		mMergeAdapter=new MergeAdapter();
		
		
		/*
		 * 		Building Opinion Adapter
		 */
		mMergeAdapter.addView(buildHeader("Opini�n", R.drawable.gradient_opinion_header));
		mMergeAdapter.addAdapter(buildOpinionList());			
		setListAdapter(mMergeAdapter);	
	}
	
	//Opinion ListView
    private ListAdapter buildOpinionList() {
    	return(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,
				new ArrayList<String>(Arrays.asList(items))));
	}
    
	private View buildHeader(String title, int background){
		
		TextView textview = new TextView(this);		
		textview.setTextColor(R.color.header_text);
		textview.setCursorVisible(false);
		textview.setFocusable(false);
		textview.setClickable(false);
		textview.setFocusableInTouchMode(false);
		textview.setText(title);
		textview.setTextSize(25);
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
            	ShareMenu.buildShareMenu(getApplicationContext(),
            			 Recursos.TITULO_COMPARTIR,
            			 Recursos.COMPARTIR_HOME);
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
    private void refresh() {
			new AsyncNotes(this).execute();
	}

/*    
private class ImageLoaderAsyncTask extends AsyncTask<URL, Void, Bitmap> {
    	
    	private Activity activity;
		private int idFoto;
		private Net net;
		private View imagen;
		


		public ImageLoaderAsyncTask (Activity activity, int idFoto, View imagen ){
    		
    			this.activity = activity;
    			this.idFoto = idFoto;
    			this.imagen = imagen;
    		
    		return;
    	}
    	
    	
		@Override
		protected void onPreExecute(){
			this.net = new Net(this.activity.getApplicationContext());
			image.setBackgroundResource(R.drawable.row_photo);
			return;
    	}
    	
    	
    	@Override
		protected Bitmap doInBackground(URL... urls) {

    		Bitmap img = null;
            try {
            	img = net.getImagenLista(this.idFoto);
			} catch (Exception e) {
				Log.e(Recursos.APP,"Ocurrio un error");
				Log.e(Recursos.APP,e.toString());
				e.printStackTrace();
			}
			

			
            return img;
        }
        

        @Override
		protected void onPostExecute(Bitmap imagen) {    	
        	if (imagen != null)
        		image.setImageBitmap(imagen);
        }
    }
	
*/    

   

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
	 	lastNewsAdapter.getItem(position);
	 	
	 	Integer idNota = null;
	 	Integer idFoto = null;
	 			
	 	switch (seccion) {
		case ULTIMA_HORA:
			
			if (position >=0 && position <= 14){
				idNota= excelsiorBean.getUltimaHora().get(position).idNota;
			}

			else if (position >=16 && position <= 17){
				idNota= excelsiorBean.getSeccionNacional().get(position-16).idNota;
				idFoto= excelsiorBean.getSeccionNacional().get(position-16).idFotoPortada;
			}
			else if (position >=19 && position <= 20){
				idNota= excelsiorBean.getSeccionGlobal().get(position-19).idNota;
				idFoto= excelsiorBean.getSeccionGlobal().get(position-19).idFotoPortada;
			}
			else if (position >=22 && position <= 23){
				idNota= excelsiorBean.getSeccionDinero().get(position-22).idNota;
				idFoto= excelsiorBean.getSeccionDinero().get(position-22).idFotoPortada;
			}
			else if (position >=25 && position <= 26){
				idNota= excelsiorBean.getSeccionComunidad().get(position-25).idNota;
				idFoto= excelsiorBean.getSeccionComunidad().get(position-25).idFotoPortada;
			}
			else if (position >=28 && position <= 29){
				idNota= excelsiorBean.getSeccionAdrenalina().get(position-28).idNota;
				idFoto= excelsiorBean.getSeccionAdrenalina().get(position-28).idFotoPortada;
			}
			else if (position >=31 && position <= 32){
				idNota= excelsiorBean.getSeccionFuncion().get(position-31).idNota;
				idFoto= excelsiorBean.getSeccionFuncion().get(position-31).idFotoPortada;
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
			break;
			
		default: 
			break;
				
	}
	 	
	 	if (idNota != null){	 	
			Intent i = new Intent(getApplication(), NoteActivity.class);  
			i.putExtra("id_nota", idNota);
			i.putExtra("id_foto", idFoto);
			startActivity(i);
	 	}
	
	}
	
}
	
	
	
    
   
    
