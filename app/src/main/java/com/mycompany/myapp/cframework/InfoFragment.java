package com.mycompany.myapp.cframework;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 11/25/2017.
 */
public class InfoFragment extends Fragment {
    List<Info> InfoLists = new ArrayList<>();
    InfoAdapter infoAdapter;
    RecyclerView recyclerView;
    FloatingActionButton refresh,add;
    TextView load, loadb, loadc, texty, refrensh, adde, rjane;
    RotateAnimation spin, spina;
    TranslateAnimation translatea, translateb, translatec;
    Button infodone;
    CountDownTimer timer, timerb;
    ScaleAnimation Rollout, Rollin;
    ArrayList<String> forList;
    ListView list;
    RelativeLayout la, ard;
    EditText infobody, infoautho, infotitle;
    String sinfobody, sinfoautho, sinfotitle;
    View r;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View m = inflater.inflate(R.layout.infoo,container,false);
        refresh = (FloatingActionButton)m.findViewById(R.id.faa);
        add = (FloatingActionButton)m.findViewById(R.id.fac);
        load = (TextView)m.findViewById(R.id.load);
        loadb = (TextView)m.findViewById(R.id.loadb);
        refrensh = (TextView)m.findViewById(R.id.refrensh);
        adde = (TextView)m.findViewById(R.id.adde);
        loadc = (TextView)m.findViewById(R.id.loadc);
        texty = (TextView)m.findViewById(R.id.texty);
        rjane = (TextView)m.findViewById(R.id.rjane);
        refresh.setOnClickListener(refreshClicker);
        spin = new RotateAnimation(0,360,50,50);
        spina = new RotateAnimation(0,360,42,42);
         translatea = new TranslateAnimation(0,0,0,10);
         translateb = new TranslateAnimation(0,0,0,-11);
         translatec = new TranslateAnimation(0,0,0,8);
        forList = new ArrayList<String>();
        Rollout = new ScaleAnimation(1,1,0,1);
        Rollin = new ScaleAnimation(1,1,1,0);
        la = (RelativeLayout)m.findViewById(R.id.la);
        ard = (RelativeLayout)m.findViewById(R.id.ard);
        add.setOnClickListener(addListener);
        infodone =(Button)m.findViewById(R.id.infodone);
        infodone.setOnClickListener(infodoneListener);
        infoautho = (EditText)m.findViewById(R.id.ediauthor);
        infobody = (EditText)m.findViewById(R.id.edi);
        infotitle = (EditText)m.findViewById(R.id.infotitle);
        recyclerView = (RecyclerView)m.findViewById(R.id.list);
        infoAdapter = new InfoAdapter(InfoLists);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(infoAdapter);
        return m;
    }
    View.OnClickListener refreshClicker = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
              r = view;

            spin.setDuration(2000);
            Rollout.setDuration(700);
            loadc.setVisibility(view.VISIBLE);
            loadb.setVisibility(view.VISIBLE);
            load.setVisibility(view.VISIBLE);
           loadc.startAnimation(Rollout);
            loadb.startAnimation(Rollout);
            load.startAnimation(Rollout);
            refresh.startAnimation(spin);
            CountDownTimer timer = new CountDownTimer(500,1500) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    rjane.setText("    Refreshing...");
                    texty.setText("refreshing...");
                    translatea.setDuration(500);
                    translatea.setRepeatCount(10);
                    translateb.setDuration(500);
                    translateb.setRepeatCount(10);
                    translatec.setDuration(500);
                    translatec.setRepeatCount(10);
                    load.startAnimation(translatea);
                    loadb.startAnimation(translateb);
                    loadc.startAnimation(translatec);


                    CountDownTimer timerb = new CountDownTimer(5000,1000) {
                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {

                        if(forList.isEmpty()){
                            Rollin.setDuration(700);
                            loadc.startAnimation(Rollin);
                            loadb.startAnimation(Rollin);
                            load.startAnimation(Rollin);
                            CountDownTimer timerb = new CountDownTimer(600,300) {
                                @Override
                                public void onTick(long l) {

                                }

                                @Override
                                public void onFinish() {
                                          loadc.setVisibility(view.GONE);
                                          loadb.setVisibility(view.GONE);
                                          load.setVisibility(view.GONE);
                                    rjane.setText("Your Information List");
                                        texty.setText("No rececent\n News or Information");

                                }
                            }.start();
                        }
                        }
                    }.start();
                }
            }.start();

        }
    };
    View.OnClickListener addListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            r = view;
            spina.setDuration(500);
            spina.setRepeatCount(1);
            add.startAnimation(spina);
            CountDownTimer count = new CountDownTimer(800,500) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    try {
                        recyclerView.setVisibility(r.GONE);
                    }
                    catch (Exception e){}
                    rjane.setVisibility(r.GONE);
                    texty.setVisibility(r.GONE);
//            list.setVisibility(view.GONE);
                    refrensh.setVisibility(r.GONE);
                    adde.setVisibility(r.GONE);
                    refresh.setVisibility(r.GONE);
                    add.setVisibility(r.GONE);
                    ard.setVisibility(r.VISIBLE);
                }
            }.start();

        }
    };
    View.OnClickListener infodoneListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            ard.setVisibility(view.GONE);
            sinfoautho = infoautho.getText().toString();
            sinfobody = infobody.getText().toString();
            sinfotitle = infotitle.getText().toString();
            Info info = new Info(sinfotitle,sinfoautho);
            recyclerView.setVisibility(r.VISIBLE);
            InfoLists.add(info);
            infoAdapter.notifyDataSetChanged();
            refresh.setVisibility(r.VISIBLE);
            add.setVisibility(r.VISIBLE);
            rjane.setVisibility(r.VISIBLE);
     }
    };

}
