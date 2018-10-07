package elle0827.io.l4s_sns_apps_;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
    }

    public void moveToJapan(View view) {
        Intent intent = new Intent(this, CountryActivity.class);
        intent.putExtra("POSITION", 0);
        startActivity(intent);
    }

    public void moveToAsia(View view) {
        Intent intent = new Intent(this, CountryActivity.class);
        intent.putExtra("POSITION", 1);
        startActivity(intent);
    }

    public void moveToEurope(View view) {
        Intent intent = new Intent(this, CountryActivity.class);
        intent.putExtra("POSITION", 2);
        startActivity(intent);
    }

    public void moveToAmerica(View view) {
        Intent intent = new Intent(this, CountryActivity.class);
        intent.putExtra("POSITION", 3);
        startActivity(intent);
    }
}
