package elle0827.io.l4s_sns_apps_;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CountryActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference();

    ImageView countryimageview;
    ListView listView;
    List<Country> mcountries;
    CountryAdapter mCountryAdapter;


    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_county);

        position = getIntent().getIntExtra("POSITION", 0);

        countryimageview = (ImageView) findViewById(R.id.countryimageview);
        listView = (ListView) findViewById(R.id.listView);

        mcountries = new ArrayList<Country>();
        mCountryAdapter = new CountryAdapter(this, R.layout.country, mcountries);
        //mCountryAdapter.setOnLikeClickListener(this);//
        listView.setAdapter(mCountryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CountryActivity.this, MainActivity.class);
                intent.putExtra("POSITION", position);
                startActivity(intent);
            }
        });

        reference.child("areas").child(String.valueOf(position)).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Area area = dataSnapshot.getValue(Area.class);
                Log.d("DEBUGGG", area.getPlaces().toString());

                // url形式の画像を表示する
                Picasso.get().load(area.getUrl()).into(countryimageview);

                mCountryAdapter.addAll(area.getPlaces());
                mCountryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
