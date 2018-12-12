package com.rabhosle.tictactoe.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rabhosle.tictactoe.R;
import com.rabhosle.tictactoe.model.DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rabhosle on 12/11/2018.
 */

public class GameCellAdapter extends RecyclerView.Adapter<GameCellAdapter.ViewHolder> {

    private ArrayList<DataModel> values;
    protected ItemListener mListener;

    public GameCellAdapter(ArrayList<DataModel> myDataset, ItemListener itemListener) {
        values = myDataset;
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

        public TextView cellContent;
        public LinearLayout layout;
        public DataModel item;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            cellContent = (TextView) itemView.findViewById(R.id.txtContent);
            layout = (LinearLayout) itemView.findViewById(R.id.layout);
        }

        public void setData(DataModel item) {
            this.item = item;

            cellContent.setText(item.text);
            layout.setBackgroundColor(Color.parseColor(item.color));
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    public interface ItemListener {
        void onItemClick(DataModel item);
    }
}
