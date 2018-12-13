package com.rabhosle.tictactoe.activities;

/**
 * Created by rabhosle on 12/11/2018.
 */

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rabhosle.tictactoe.R;
import com.rabhosle.tictactoe.adapters.GameCellAdapter;
import com.rabhosle.tictactoe.model.DataModel;
import com.rabhosle.tictactoe.utils.ItemOffsetDecoration;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements GameCellAdapter.ItemListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView txtInfo;

    private ArrayList<DataModel> gridCell;

    //holds the current players status
    private String currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //initialze all the view
        initViews();

        //setup the game
        setUpCells();
    }


    private void initViews() {

        txtInfo = (TextView) findViewById(R.id.information);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        //grid recycler view with 3 column
        layoutManager = new GridLayoutManager(this, 3);

        //decorator for grid cells spacing
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.grid_offset);
        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setLayoutManager(layoutManager);
    }

    private void setUpCells() {
        //show information text
        txtInfo.setVisibility(View.VISIBLE);

        //set X as the default current player for new game
        currentPlayer = this.getResources().getString(R.string.XPlayer);

        //setup the grid cells with defalut values
        gridCell = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            gridCell.add(new DataModel("", i, this.getResources().getColor(R.color.activeGrid), false));
        }

        mAdapter = new GameCellAdapter(this);
        ((GameCellAdapter) mAdapter).setItems(gridCell);

        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(DataModel item) {
        //hide the information
        txtInfo.setVisibility(View.INVISIBLE);

        //for every click on the cell call play method
        playGame(item);
    }

    private void playGame(DataModel item) {
        String winner = null;

        //check if the clicked cell is already played
        if (!gridCell.get(item.index).isPlayed) {

            //update the grid with the played value players name
            gridCell.get(item.index).text = currentPlayer;
            //set background as grey so that cell will appear as inactive
            gridCell.get(item.index).color = this.getResources().getColor(R.color.inactiveGrid);
            gridCell.get(item.index).isPlayed = true;

            //Update the grid view once playerhas played
            ((GameCellAdapter) mAdapter).setItems(gridCell);
            mAdapter.notifyDataSetChanged();

            //now change the player
            if (currentPlayer.equals(this.getResources().getString(R.string.XPlayer))) {
                currentPlayer = this.getResources().getString(R.string.OPlayer);
            } else {
                currentPlayer = this.getResources().getString(R.string.XPlayer);
            }

            //check form the winner
            winner = winnerPlayerCheck();
        } else {
            Toast.makeText(this, this.getResources().getString(R.string.slotOccupied), Toast.LENGTH_SHORT).show();
        }

        if (winner != null && !winner.equalsIgnoreCase("")) {
            if (winner.equalsIgnoreCase(this.getResources().getString(R.string.string_draw))) {
                startNewGame(this.getResources().getString(R.string.draw_message));
            } else {
                startNewGame(String.format(this.getResources().getString(R.string.result_message), winner));
            }
        }
    }


    //starts a new game
    private void startNewGame(String result) {

        //code for showing the alert dialog
        new AlertDialog.Builder(this)
                .setTitle(this.getResources().getString(R.string.dialog_title))
                .setMessage(result)
                .setPositiveButton(this.getResources().getString(R.string.positiveButton), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setUpCells();
                    }
                })
                .setNegativeButton(this.getResources().getString(R.string.negativeButton), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setCancelable(false)
                .show();
    }


    private String winnerPlayerCheck() {
        for (int a = 0; a < 8; a++) {
            String winningCondition = null;

            //these all are the winning conditions for a player
            switch (a) {
                case 0:
                    winningCondition = gridCell.get(0).text + gridCell.get(1).text + gridCell.get(2).text;
                    break;
                case 1:
                    winningCondition = gridCell.get(3).text + gridCell.get(4).text + gridCell.get(5).text;
                    break;
                case 2:
                    winningCondition = gridCell.get(6).text + gridCell.get(7).text + gridCell.get(8).text;
                    break;
                case 3:
                    winningCondition = gridCell.get(0).text + gridCell.get(3).text + gridCell.get(6).text;
                    break;
                case 4:
                    winningCondition = gridCell.get(1).text + gridCell.get(4).text + gridCell.get(7).text;
                    break;
                case 5:
                    winningCondition = gridCell.get(2).text + gridCell.get(5).text + gridCell.get(8).text;
                    break;
                case 6:
                    winningCondition = gridCell.get(0).text + gridCell.get(4).text + gridCell.get(8).text;
                    break;
                case 7:
                    winningCondition = gridCell.get(2).text + gridCell.get(4).text + gridCell.get(6).text;
                    break;
            }

            // for any of the above 8 winning conditions
            //if all the values in grid are same i.e 'X' or 'O'
            //subsequent player is the winner
            if (winningCondition.equals(this.getResources().getString(R.string.xWinCondition))) {
                return this.getResources().getString(R.string.XPlayer);
            } else if (winningCondition.equals(this.getResources().getString(R.string.oWinCondition))) {
                return this.getResources().getString(R.string.OPlayer);
            }
        }

        //
        for (int a = 0; a < 9; a++) {
            if (gridCell.get(a).text == "") {
                break;
            }
            //if all grid cells are played without any win condition, game ends in  a draw
            else if (a == 8) return this.getResources().getString(R.string.string_draw);

        }

        //show next player's turn
        Toast.makeText(this, "" + currentPlayer + "'s turn", Toast.LENGTH_SHORT).show();
        return "";
    }
}
