package elle0827.io.l4s_sns_apps_;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference();
    EditText titleEditText;
    EditText contentEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        titleEditText = (EditText) findViewById(R.id.title);
        contentEditText = (EditText) findViewById(R.id.content);


    }

    public void save(View v) {
        String title = titleEditText.getText().toString();
        String content = contentEditText.getText().toString();
        String key = reference.push().getKey();
//        pushのタイミングをtimekeyとする
        // Card card = new Card(key,title,content,0);
        /*
        reference.child(key).setValue(card).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                finish();
            }
        });
        */
    }

}
