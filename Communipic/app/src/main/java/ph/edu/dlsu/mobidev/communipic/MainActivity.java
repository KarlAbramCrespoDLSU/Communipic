package ph.edu.dlsu.mobidev.communipic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Picture> listChores;
    RecyclerView rvChores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvChores = (RecyclerView) findViewById(R.id.rv_chores);

        listChores = new ArrayList<Picture>();


        PictureAdapter pictureAdapter = new PictureAdapter(listChores);
        rvChores.setAdapter(pictureAdapter);

        rvChores.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));

    }
}
