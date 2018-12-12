package com.rabhosle.tictactoe.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.rabhosle.tictactoe.R;
import com.rabhosle.tictactoe.adapters.GameCellAdapter;
import com.rabhosle.tictactoe.model.DataModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GameActivity extends AppCompatActivity implements GameCellAdapter.ItemListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<DataModel> gridCell;
    private String currentPlayer = "X";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initViews();
        setUpCells();

    }


    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setUpCells() {
        gridCell = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            gridCell.add(new DataModel("", i, "#ffffff", false));
        }
        mAdapter = new GameCellAdapter(gridCell, this);

        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(DataModel item) {
        startGame(item);
        // Toast.makeText(getApplicationContext(), item + " is clicked", Toast.LENGTH_SHORT).show();
    }

    private void startGame(DataModel item) {
        //  input = new Scanner(System.in);
        // gridCell = new String[9];

        String winner = null;
        //  populateEmptyBoard();

        //  System.out.println("Welcome to 2 Player Tic Tac Toe.");
        //  System.out.println("--------------------------------");
        // printBoard();
        // System.out.println("X's will play first. Enter a slot number to place X input:");

        while (winner == null) {
            int numInput = item.index;
            if (!gridCell.get(item.index).isPlayed) {
                gridCell.get(item.index).text = currentPlayer;
                gridCell.get(item.index).color = "#A9A9A9";
                if (currentPlayer.equals("X")) {
                    currentPlayer = "O";
                } else {
                    currentPlayer = "X";
                }
                winner = winnerPlayerCheck();
            } else {
                Toast.makeText(this, "Slot is not empty", Toast.LENGTH_SHORT).show();
            }
        }
        if (winner.equalsIgnoreCase("draw")) {
            Toast.makeText(this, "It's a draw! ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Congratulations! " + winner + "'s have won!", Toast.LENGTH_SHORT).show();
        }
    }


    private String winnerPlayerCheck() {
        for (int a = 0; a < 8; a++) {
            String winningCondition = null;
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
            if (winningCondition.equals("XXX")) {
                return "X";
            } else if (winningCondition.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (gridCell.get(a).text == "") {
                break;
            } else if (a == 8) return "draw";
        }

        Toast.makeText(this, "" + currentPlayer + "'s turn", Toast.LENGTH_SHORT).show();
        return null;
    }
}
