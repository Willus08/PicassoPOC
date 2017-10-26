package helpme_productions.com.picassopoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    RecyclerView images;
    RecyclerViewAdapater adapater;
    RecyclerView.LayoutManager layoutManager;
    DefaultItemAnimator animator;
    List<String> listOfImagesURL = new ArrayList<>();
    ImageView starting;
    Picasso.Builder builder;
    ExecutorService pool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = (RecyclerView) findViewById(R.id.rvRecyclerView);
        starting = (ImageView) findViewById(R.id.ivSetPicture);
        pool = Executors.newFixedThreadPool(5);
        builder = new Picasso.Builder(this);
        builder.executor(pool);
        Picasso picasso = builder.build();


        picasso
                .load("http://orig14.deviantart.net/f485/f/2016/147/3/d/rwby_crescent_rose_and_qrow_s_scythe_by_archeoalex-da3yeu6.png")
                .into(starting);
        setupImageURLList();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        adapater = new RecyclerViewAdapater(listOfImagesURL);
        layoutManager = new LinearLayoutManager(this);
        animator = new DefaultItemAnimator();

        images.setItemAnimator(animator);
        images.setAdapter(adapater);
        images.setLayoutManager(layoutManager);
    }

    private void setupImageURLList() {
        listOfImagesURL.add("http://www.fireworks-advertising.com/sites/fireworks-advertising.com/files/imagecache/inline_content_default_width/clients/Mountain%20dew%20logo%20_%20fireworks%20advertising.jpg");
        listOfImagesURL.add("http://www.llamatastic.com/site/wp-content/uploads/2012/01/Dragon.jpg");
        listOfImagesURL.add("http://img11.deviantart.net/c203/i/2012/131/c/4/excalibur_by_epar3d-d4zf7eq.jpg");
        listOfImagesURL.add("http://images2.fanpop.com/images/photos/2800000/Master-Sword-Wallpaper-the-legend-of-zelda-2832786-1920-1200.jpg");
        listOfImagesURL.add("http://fc02.deviantart.net/fs34/i/2008/304/3/d/Triforce_2_by_5995260108.png");
        listOfImagesURL.add("http://orig14.deviantart.net/f485/f/2016/147/3/d/rwby_crescent_rose_and_qrow_s_scythe_by_archeoalex-da3yeu6.png");
//        listOfImagesURL.add("");
//        listOfImagesURL.add("");
//        listOfImagesURL.add("");
//        listOfImagesURL.add("");
//        listOfImagesURL.add("");
//        listOfImagesURL.add("");
//        listOfImagesURL.add("");
//        listOfImagesURL.add("");
//        listOfImagesURL.add("");
//        listOfImagesURL.add("");

    }
}
