package com.rabhosle.tictactoe.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rabhosle.tictactoe.R;

import java.util.List;

/**
 * Created by rabhosle on 12/11/2018.
 */

public class GameCellAdapter extends RecyclerView.Adapter<GameCellAdapter.ViewHolder> {

    private List<String> values;

    public GameCellAdapter(List<String> myDataset) {
        values = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.grid_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String name = values.get(position);
        holder.cellContent.setText(name);
        holder.cellContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView cellContent;

        public ViewHolder(View itemView) {
            super(itemView);
            cellContent = (TextView) itemView.findViewById(R.id.txtContent);
        }
    }
}
