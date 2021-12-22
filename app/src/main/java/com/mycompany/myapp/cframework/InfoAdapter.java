package com.mycompany.myapp.cframework;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Paul on 11/29/2017.
 */
public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.MyViewHolder> {
    private List<Info> infoLists;
    int i;

    public class  MyViewHolder extends RecyclerView.ViewHolder {
                public TextView titler, titleb, titleg, author, authob, authog;
                RelativeLayout lred, lblue, lgreen;
                View view;
                public MyViewHolder(View view) {

                    super(view);
                    this.view =view;
                    titleb = (TextView) view.findViewById(R.id.titleb);
                    titler = (TextView) view.findViewById(R.id.titler);
                    titleg = (TextView) view.findViewById(R.id.titleg);
                    authob = (TextView) view.findViewById(R.id.authob);
                    author = (TextView) view.findViewById(R.id.author);
                    authog = (TextView) view.findViewById(R.id.authog);
                    lred = (RelativeLayout) view.findViewById(R.id.lred);
                    lblue = (RelativeLayout) view.findViewById(R.id.lblue);
                    lgreen = (RelativeLayout) view.findViewById(R.id.lgreen);



                }
            }
                public InfoAdapter( List<Info>sanfoLists){
                    this.infoLists = sanfoLists;
                  i= this.getItemCount();
                }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.infolist, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Info info = infoLists.get(position);
        holder.titleb.setText(info.getTitle());
        holder.titler.setText(info.getTitle());
        holder.titleg.setText(info.getTitle());
        holder.authob.setText(info.getAuthority());
        holder.author.setText(info.getAuthority());
        holder.authog.setText(info.getAuthority());

            holder.lblue.setVisibility(holder.view.VISIBLE);
            holder.lred.setVisibility(holder.view.GONE);
            holder.lgreen.setVisibility(holder.view.GONE);
            if ((position % 2) == 0) {
                holder.lgreen.setVisibility(holder.view.VISIBLE);
                holder.lred.setVisibility(holder.view.GONE);
                holder.lblue.setVisibility(holder.view.GONE);
            }
            if ((position % 3) == 0) {
                holder.lred.setVisibility(holder.view.VISIBLE);
                holder.lgreen.setVisibility(holder.view.GONE);
                holder.lblue.setVisibility(holder.view.GONE);
            }
        }

    @Override
    public int getItemCount() {
        try {
            return infoLists.size();
        } catch (Exception e) {
        }
        return 0;
    }
}

