package net.laili.pasporbayi.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import net.laili.pasporbayi.BuildConfig;
import net.laili.pasporbayi.R;
import net.laili.pasporbayi.auth.LoginActivity;
import net.laili.pasporbayi.database.DaoCatatanImunisasi;
import net.laili.pasporbayi.database.DaoCatatanKunjungan;
import net.laili.pasporbayi.database.DaoDataAnak;
import net.laili.pasporbayi.database.DaoPerkembanganBayi;
import net.laili.pasporbayi.database.DaoRiwayatKelahiran;
import net.laili.pasporbayi.database.DaoRiwayatKesehatanBayi;
import net.laili.pasporbayi.fragments.BerandaFragment;
import net.laili.pasporbayi.fragments.DataBalitaFragment;
import net.laili.pasporbayi.fragments.ImunisasiFragment;
import net.laili.pasporbayi.fragments.TumbuhKembangFragment;
import net.laili.pasporbayi.utils.AppSessionManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    private AppSessionManager appSessionManager;
    private boolean doubleBackToExitPressedOnce = false;
    private int curId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        appSessionManager = new AppSessionManager(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        View headerLayout = navigationView.getHeaderView(0);
        TextView emailUser = (TextView) headerLayout.findViewById(R.id.text_email_user);
        emailUser.setText(appSessionManager.getEmailUser());

        getSupportActionBar().setTitle("Beranda");
        curId = R.id.nav_beranda;
        navigationView.setCheckedItem(curId);
        Fragment fragment = new BerandaFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_main, fragment);
        transaction.commit();

        Log.i("CheckDao", "perkembangan bayi : " + DaoPerkembanganBayi.getInstance(this).find().size());
//        Log.i("CheckDao", DaoCatatanImunisasi.getInstance(this).find().toString());
//        Log.i("CheckDao", DaoCatatanKunjungan.getInstance(this).find().toString());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return;
            }

            doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "klik BACK dua kali untuk keluar", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 1000);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //handle primary nav
        if (item.getGroupId() == R.id.primary_menu) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Fragment fragment = null;
            switch (id) {
                case R.id.nav_beranda:
                    fragment = new BerandaFragment();
                    getSupportActionBar().setTitle("Beranda");
                    break;
                case R.id.nav_data_balita:
                    fragment = new DataBalitaFragment();
                    getSupportActionBar().setTitle("Data Balita");
                    break;
                case R.id.nav_tumbuh_kembang:
                    fragment = new TumbuhKembangFragment();
                    getSupportActionBar().setTitle("Tumbuh Kembang");
                    break;
                case R.id.nav_imunisasi:
                    fragment = new ImunisasiFragment();
                    getSupportActionBar().setTitle("Imunisasi");
                    break;
            }
            transaction.replace(R.id.fragment_main, fragment);
            transaction.commit();
        }
        //handle secondary nav
        else {
            switch (id) {
                case R.id.nav_info_app:
                    startActivity(new Intent(this, AboutAppActivity.class));
                    break;
                case R.id.nav_contact:
                    composeEmail();
                    break;
                case R.id.nav_logout:
                    logout();
                    startActivity(new Intent(this, LoginActivity.class));
                    finish();
                    break;
            }
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void composeEmail() {
        String body = "";
        try {
            body = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            body = "\n\n-----------------------------\nPlease don't remove this information\n Device OS: Android \n Device OS version: " +
                    Build.VERSION.RELEASE + "\n App Version: " + body + "\n Device Brand: " + Build.BRAND +
                    "\n Device Model: " + Build.MODEL + "\n Device Manufacturer: " + Build.MANUFACTURER;
        } catch (PackageManager.NameNotFoundException e) {

        }

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{BuildConfig.EMAIL_DEVELOPER});
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void logout() {
        appSessionManager.clearSession();
        appSessionManager.setLoginState(false);

        DaoCatatanImunisasi.getInstance(this).reset();
        DaoPerkembanganBayi.getInstance(this).reset();
        DaoCatatanKunjungan.getInstance(this).remove();
        DaoDataAnak.getInstance(this).remove();
        DaoRiwayatKelahiran.getInstance(this).remove();
        DaoRiwayatKesehatanBayi.getInstance(this).remove();
    }
}
