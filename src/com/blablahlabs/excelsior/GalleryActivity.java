package com.blablahlabs.excelsior;

import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blablahlabs.excelsior.beans.ExcelsiorFotoGaleria;
import com.blablahlabs.excelsior.beans.ExcelsiorSingleFotoGaleria;
import com.blablahlabs.excelsior.recursos.IU;


public class GalleryActivity extends Activity {

	@Override
	protected void onPause() {
		gallery.destroyDrawingCache();
		gallery.removeAllViewsInLayout();
		gallery = null;
		
        excelsiorFotoGaleria = null;
        GalleryListActivity.excelsiorFotoGaleria = null;
		super.onPause();
	}

	private ExcelsiorFotoGaleria excelsiorFotoGaleria;
	private Gallery gallery; 
    private ImageView imgView;
	private TextView txtView;
		
		
	
	  @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        IU.setCustomTitle(this);
	        setContentView(R.layout.gallery);
	       
	        
	        excelsiorFotoGaleria = GalleryListActivity.excelsiorFotoGaleria;
	        
	        Collections.reverse(excelsiorFotoGaleria.excelsiorSingleFotoGaleria);
	         
			imgView = (ImageView)findViewById(R.id.image);	
			this.txtView = (TextView)findViewById(R.id.note_content);
			
			imgView.setImageBitmap(excelsiorFotoGaleria.excelsiorSingleFotoGaleria.get(0).getImagen());
            txtView.setText(  excelsiorFotoGaleria.excelsiorSingleFotoGaleria.get(0).getDescripcion() );
	        
	         gallery = (Gallery) findViewById(R.id.gallery);
	         gallery.setAdapter(new AddImgAdp(this, excelsiorFotoGaleria.excelsiorSingleFotoGaleria ));
	     

	         gallery.setOnItemClickListener(new OnItemClickListener() {
	            public void onItemClick(AdapterView parent, View v, int position, long id) {
	                imgView.setImageBitmap(excelsiorFotoGaleria.excelsiorSingleFotoGaleria.get(position).getImagen());
	                txtView.setText(  excelsiorFotoGaleria.excelsiorSingleFotoGaleria.get(position).getDescripcion() );
	            }
	        });
	        
	  }	
	  
	  public class AddImgAdp extends BaseAdapter {
	        int GalItemBg;
	        private Context cont;
			private List<ExcelsiorSingleFotoGaleria> excelsiorSingleFotoGaleria;

	        public AddImgAdp(Context c, List<ExcelsiorSingleFotoGaleria> excelsiorSingleFotoGaleria) {
	            cont = c;
	            TypedArray typArray = obtainStyledAttributes(R.styleable.GalleryTheme);
	            GalItemBg = typArray.getResourceId(R.styleable.GalleryTheme_android_galleryItemBackground, 0);
	            typArray.recycle();
	            this.excelsiorSingleFotoGaleria = excelsiorSingleFotoGaleria;
	        }

	        public int getCount() {
	        	return excelsiorSingleFotoGaleria.size();	             
	        }

	        public Object getItem(int position) {
	            return position;
	        }

	        public long getItemId(int position) {
	            return position;
	        }

	        public View getView(int position, View convertView, ViewGroup parent) {
	            ImageView imgView = new ImageView(cont);

	            imgView.setImageBitmap(excelsiorSingleFotoGaleria.get(position).getImagen());
	            imgView.setLayoutParams(new Gallery.LayoutParams(140, 100));
	            imgView.setScaleType(ImageView.ScaleType.FIT_XY);
	            imgView.setBackgroundResource(GalItemBg);
	            
	            return imgView;
	        }
	    }

	  

}
