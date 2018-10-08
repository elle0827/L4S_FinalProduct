package elle0827.io.l4s_sns_apps_;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements CardAdapter.OnLikeClickListener {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference();

    List<Post> mCards;
    CardAdapter mCardAdapter;
    ListView listView;
    FloatingActionButton add_button;
    //    ImageView ImageId;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        position = getIntent().getIntExtra("POSITION", 0);

        listView = (ListView) findViewById(R.id.listView);
//        ImageId = (ImageView) findViewById(R.id.ImageId);
        mCards = new ArrayList<Post>();
        mCardAdapter = new CardAdapter(this, R.layout.card, mCards);
        mCardAdapter.setOnLikeClickListener(this);
        listView.setAdapter(mCardAdapter);
//        listViewがどこのデータと繋がれるか

        add_button = (FloatingActionButton) findViewById(R.id.add_button);


        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        reference.child("areas").child(String.valueOf(0)).child("area").child("places").child(String.valueOf(position)).child("posts").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                // Card card = dataSnapshot.getValue(Card.class);
                // mCardAdapter.add(card);
                // mCardAdapter.notifyDataSetChanged();

                Post post = dataSnapshot.getValue(Post.class);

//                Picasso.get().load(post.getUrl()).into(ImageId);
                mCardAdapter.add(post);
                mCardAdapter.notifyDataSetChanged();
                Log.d("DEBUGGG", post.getMemo());


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
//        reference.child("areas").child(String.valueOf(1)).child("area").child("places").child(String.valueOf(position)).child("posts").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                // Card card = dataSnapshot.getValue(Card.class);
//                // mCardAdapter.add(card);
//                // mCardAdapter.notifyDataSetChanged();
//
//                Post post = dataSnapshot.getValue(Post.class);
//
////                Picasso.get().load(post.getUrl()).into(ImageId);
//                mCardAdapter.add(post);
//                mCardAdapter.notifyDataSetChanged();
//                Log.d("DEBUGGG", post.getMemo());
//
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

//        reference.child("areas").child(String.valueOf(2)).child("area").child("places").child(String.valueOf(position)).child("posts").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                // Card card = dataSnapshot.getValue(Card.class);
//                // mCardAdapter.add(card);
//                // mCardAdapter.notifyDataSetChanged();
//
//                Post post = dataSnapshot.getValue(Post.class);
//
////                Picasso.get().load(post.getUrl()).into(ImageId);
//                mCardAdapter.add(post);
//                mCardAdapter.notifyDataSetChanged();
//                Log.d("DEBUGGG", post.getMemo());
//
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        reference.child("areas").child(String.valueOf(3)).child("area").child("places").child(String.valueOf(position)).child("posts").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                // Card card = dataSnapshot.getValue(Card.class);
//                // mCardAdapter.add(card);
//                // mCardAdapter.notifyDataSetChanged();
//
//                Post post = dataSnapshot.getValue(Post.class);
//
////                Picasso.get().load(post.getUrl()).into(ImageId);
//                mCardAdapter.add(post);
//                mCardAdapter.notifyDataSetChanged();
//                Log.d("DEBUGGG", post.getMemo());
//
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

    }

    @Override
    public void onLikeClick(int position) {

        Post card = mCardAdapter.getItem(position);
        if (card == null) return;

        int likeCount = card.getLikeCount();
        likeCount++;
        card.setLikeCount(likeCount);

        Map<String, Object> postValues = new HashMap<>();
        postValues.put("/" + card.getkey() + "/", card);
        // /=urlのことで,key一つ一つのアドレスに行き着く
        Toast.makeText(MainActivity.this, "いいねが押されたよ", Toast.LENGTH_SHORT).show();

        reference.updateChildren(postValues);

    }

}




