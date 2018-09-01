package com.voxtrail.sales.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.voxtrail.sales.R;
import com.voxtrail.sales.fragment.AddCallLogsFragment;
import com.voxtrail.sales.fragment.AddFragment;
import com.voxtrail.sales.fragmentcontroller.ActivityManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends ActivityManager {

    @BindView(R.id.iv_lead)
    ImageView iv_lead;
    @BindView(R.id.iv_contact)
    ImageView iv_contact;
    @BindView(R.id.iv_account)
    ImageView iv_account;
    @BindView(R.id.iv_deal)
    ImageView iv_deal;
    @BindView(R.id.iv_more)
    ImageView iv_more;

    @BindView(R.id.ll_lead)
    LinearLayout ll_lead;
    @BindView(R.id.ll_contact)
    LinearLayout ll_contact;
    @BindView(R.id.ll_account)
    LinearLayout ll_account;
    @BindView(R.id.ll_deal)
    LinearLayout ll_deal;
    @BindView(R.id.ll_more)
    LinearLayout ll_more;

//    @BindView(R.id.frag_leads)
//    Fragment frag_leads;
//    @BindView(R.id.frag_contact)
//    Fragment frag_contact;
//    @BindView(R.id.frag_account)
//    Fragment frag_account;
//    @BindView(R.id.frag_deals)
//    Fragment frag_deals;
//    @BindView(R.id.frag_more)
//    Fragment frag_more;

    @BindView(R.id.ll_lead_frag)
    LinearLayout ll_lead_frag;
    @BindView(R.id.ll_contact_frag)
    LinearLayout ll_contact_frag;
    @BindView(R.id.ll_account_frag)
    LinearLayout ll_account_frag;
    @BindView(R.id.ll_deal_frag)
    LinearLayout ll_deal_frag;
    @BindView(R.id.ll_more_frag)
    LinearLayout ll_more_frag;

    @BindView(R.id.tv_leads)
    TextView tv_leads;
    @BindView(R.id.tv_contacts)
    TextView tv_contacts;
    @BindView(R.id.tv_acounts)
    TextView tv_acounts;
    @BindView(R.id.tv_deals)
    TextView tv_deals;
    @BindView(R.id.tv_more)
    TextView tv_more;
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.menu_add_lead)
    FloatingActionButton menu_add_lead;
    @BindView(R.id.menu_add_contact)
    FloatingActionButton menu_add_contact;
    @BindView(R.id.menu_add_account)
    FloatingActionButton menu_add_account;
    @BindView(R.id.menu_add_deal)
    FloatingActionButton menu_add_deal;
    @BindView(R.id.menu_add_call)
    FloatingActionButton menu_add_call;

    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView nvDrawer;
    private Toolbar toolbar;
    @BindView(R.id.ic_ham)
    ImageView ic_ham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        settingNavDrawer();

        ll_lead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFragment(0);
            }
        });

        ll_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFragment(1);
            }
        });
        ll_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFragment(2);
            }
        });
        ll_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFragment(3);
            }
        });
        ll_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFragment(4);
            }
        });

        selectFragment(0);

        menu_add_lead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(R.id.frame_main, new AddFragment());
            }
        });

        menu_add_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(R.id.frame_main, new AddFragment());
            }
        });

        menu_add_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(R.id.frame_main, new AddFragment());
            }
        });

        menu_add_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(R.id.frame_main, new AddFragment());
            }
        });

        menu_add_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(R.id.frame_main, new AddCallLogsFragment());
            }
        });

    }

    public void selectFragment(int position) {
        iv_account.setImageResource(R.drawable.ic_account_unselected);
        iv_contact.setImageResource(R.drawable.ic_contact_unselected);
        iv_deal.setImageResource(R.drawable.ic_deals_unselected);
        iv_lead.setImageResource(R.drawable.ic_lead_unselected);
        iv_more.setImageResource(R.drawable.ic_more_unselected);

        tv_acounts.setTextColor(Color.parseColor("#757575"));
        tv_contacts.setTextColor(Color.parseColor("#757575"));
        tv_deals.setTextColor(Color.parseColor("#757575"));
        tv_leads.setTextColor(Color.parseColor("#757575"));
        tv_more.setTextColor(Color.parseColor("#757575"));

        ll_lead_frag.setVisibility(View.GONE);
        ll_contact_frag.setVisibility(View.GONE);
        ll_account_frag.setVisibility(View.GONE);
        ll_deal_frag.setVisibility(View.GONE);
        ll_more_frag.setVisibility(View.GONE);

        switch (position) {
            case 0:
                iv_lead.setImageResource(R.drawable.ic_lead_selected);
                ll_lead_frag.setVisibility(View.VISIBLE);
                tv_title.setText("Leads");
                tv_leads.setTextColor(Color.parseColor("#ffa800"));
                break;
            case 1:
                iv_contact.setImageResource(R.drawable.ic_contact_selected);
                ll_contact_frag.setVisibility(View.VISIBLE);
                tv_title.setText("Contact");
                tv_contacts.setTextColor(Color.parseColor("#ffa800"));
                break;
            case 2:
                iv_account.setImageResource(R.drawable.ic_account_selected);
                ll_account_frag.setVisibility(View.VISIBLE);
                tv_title.setText("Account");
                tv_acounts.setTextColor(Color.parseColor("#ffa800"));
                break;
            case 3:
                iv_deal.setImageResource(R.drawable.ic_deals_selected);
                ll_deal_frag.setVisibility(View.VISIBLE);
                tv_title.setText("Deal");
                tv_deals.setTextColor(Color.parseColor("#ffa800"));
                break;
            case 4:
                iv_more.setImageResource(R.drawable.ic_more_selected);
                ll_more_frag.setVisibility(View.VISIBLE);
                tv_title.setText("More");
                tv_more.setTextColor(Color.parseColor("#ffa800"));
                break;
        }
    }

    private void settingNavDrawer() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);

        View view = nvDrawer.inflateHeaderView(R.layout.home_header);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupDrawerContent(nvDrawer);

        setupDrawerToggle();
//        mDrawer.addDrawerListener(drawerToggle);
        drawerToggle.setDrawerIndicatorEnabled(false);

        nvDrawer.setItemIconTintList(null);
        ic_ham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.openDrawer(GravityCompat.START);
            }
        });
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    private void setupDrawerToggle() {
        drawerToggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        // Set the drawer toggle as the DrawerListener
        mDrawer.addDrawerListener(drawerToggle);
    }

    public void selectDrawerItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
//            case R.id.nav_books:
//                break;
//            case R.id.nav_my_library:
//                break;
//            case R.id.nav_my_profile:
//                break;
//            case R.id.nav_authors:
//                break;
//            case R.id.nav_write:
//                break;
//            case R.id.nav_gallery:
//                break;
//            case R.id.nav_contact_us:
//                break;
//            case R.id.nav_logout:
//                break;
        }
        mDrawer.closeDrawers();
    }


}
