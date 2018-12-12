package com.rabhosle.tictactoe.adapters;

/**
 * Created by rabhosle on 12/11/2018.
 */


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rabhosle.tictactoe.R;
import com.rabhosle.tictactoe.model.DataModel;

import java.util.ArrayList;


public class GameCellAdapter extends RecyclerView.Adapter<GameCellAdapter.ViewHolder> {

    private ArrayList<DataModel> values;
    private ItemListener mListener;

    public GameCellAdapter(ItemListener itemListener) {
        mListener = itemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.grid_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(values.get(position));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView cellContent;
        private DataModel item;

        private ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            cellContent = (TextView) itemView.findViewById(R.id.txtContent);
        }

        public void setData(DataModel item) {
            this.item = item;
            cellContent.setText(item.text);
            cellContent.setBackgroundColor(item.color);
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    //set values for grid cells
    public void setItems(ArrayList<DataModel> values) {
        this.values = values;
    }

    //interface for handling clicks of the grid cells in activity
    //this interface will be implemented in the activity
    public interface ItemListener {
        void onItemClick(DataModel item);
    }


}
