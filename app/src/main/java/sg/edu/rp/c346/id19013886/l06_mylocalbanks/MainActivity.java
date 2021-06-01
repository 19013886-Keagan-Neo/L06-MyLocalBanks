package sg.edu.rp.c346.id19013886.l06_mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String bankClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    // Website and Contact Pare

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == tvDBS) {
            bankClicked = "DBS";
        } else if (v == tvOCBC) {
            bankClicked = "OCBC";
        } else if (v == tvUOB) {
            bankClicked = "UOB";
        }

        menu.setHeaderTitle(bankClicked + " row is clicked");

        getMenuInflater().inflate(R.menu.menu_bank, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (bankClicked.equalsIgnoreCase("DBS")) {
            if (id == R.id.websiteSelection) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbs_website)));
                startActivity(intentWebsite);
                return true;
            } else if (id == R.id.callSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.dbs_contact)));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.favouriteSelection) {
                if (tvDBS.getCurrentTextColor() == Color.RED) {
                    tvDBS.setTextColor(Color.BLACK);
                } else {
                    tvDBS.setTextColor(Color.RED);
                }
                return true;
            }

        } else if (bankClicked.equalsIgnoreCase("OCBC")) {
            if (id == R.id.websiteSelection) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbc_website)));
                startActivity(intentWebsite);
                return true;
            } else if (id == R.id.callSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.ocbc_contact)));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.favouriteSelection) {
                if (tvOCBC.getCurrentTextColor() == Color.RED) {
                    tvOCBC.setTextColor(Color.BLACK);
                } else {
                    tvOCBC.setTextColor(Color.RED);
                }
                return true;
            }

        } else if (bankClicked.equalsIgnoreCase("UOB")) {
            if (id == R.id.websiteSelection) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uob_website)));
                startActivity(intentWebsite);
                return true;
            } else if (id == R.id.callSelection) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uob_contact)));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.favouriteSelection) {
                if (tvUOB.getCurrentTextColor() == Color.RED) {
                    tvUOB.setTextColor(Color.BLACK);
                } else {
                    tvUOB.setTextColor(Color.RED);
                }
                return true;
            }

        }
        return super.onOptionsItemSelected(item); //pass menu item to the superclass implementation

    }

    // Language Part

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDBS.setText(getString(R.string.dbs_chin));
            tvOCBC.setText(getString(R.string.ocbc_chin));
            tvUOB.setText(getString(R.string.uob_chin));
            return true;
        } else {
            tvDBS.setText(getString(R.string.translate_error));
            tvOCBC.setText(getString(R.string.translate_error));
            tvUOB.setText(getString(R.string.translate_error));
        }

        return super.onOptionsItemSelected(item);
    }

}