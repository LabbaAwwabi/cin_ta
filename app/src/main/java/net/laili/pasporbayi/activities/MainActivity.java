package net.laili.pasporbayi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import net.laili.pasporbayi.R;
import net.laili.pasporbayi.auth.LoginActivity;
import net.laili.pasporbayi.database.DaoCatatanImunisasi;
import net.laili.pasporbayi.database.DaoCatatanKunjungan;
import net.laili.pasporbayi.database.DaoDataAnak;
import net.laili.pasporbayi.database.DaoPerkembanganBayi;
import net.laili.pasporbayi.database.DaoRiwayatKelahiran;
import net.laili.pasporbayi.database.DaoRiwayatKesehatanBayi;
import net.laili.pasporbayi.utils.AppSessionManager;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private boolean doubleBackToExitPressedOnce = false;

    private AppSessionManager appSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appSessionManager = new AppSessionManager(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerLayout = navigationView.getHeaderView(0);
        TextView emailUser = (TextView) headerLayout.findViewById(R.id.text_email_user);
        emailUser.setText(appSessionManager.getEmailUser());

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

        if (id == R.id.nav_beranda) {
            // Handle the camera action
        } else if (id == R.id.nav_data_balita) {

        } else if (id == R.id.nav_tumbuh_kembang) {

        } else if (id == R.id.nav_imunisasi) {

        } else if (id == R.id.nav_info_app) {

        } else if (id == R.id.nav_contact) {

        } else if (id == R.id.nav_logout) {
            logout();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        } else {
            return false;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
