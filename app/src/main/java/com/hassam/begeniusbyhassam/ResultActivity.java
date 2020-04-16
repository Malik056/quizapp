package com.hassam.begeniusbyhassam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private String userId;
    private RecyclerView mResultList;
    private TextView user;
    private ImageButton mBtnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        userId = getIntent().getStringExtra("email");
        MyDb myDb = MyDb.getInstance(getApplicationContext());
        user = findViewById(R.id.username);


        user.setText(userId+"'s Result");

        List<HashMap<String, Object>> data = myDb.getUserScores(userId);
        Log.d("userScore => ", String.valueOf(myDb.getUserScores(userId)));
        mResultList = findViewById(R.id.resultSheet);
        mResultList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ScoreAdapter adapter = new ScoreAdapter(getApplicationContext(), data);
        mResultList.setAdapter(adapter);

        mBtnLogout = findViewById(R.id.btnLogout);
        mBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

class ViewHolder extends RecyclerView.ViewHolder {

    TextView mScore, subjectName,mGrade;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mScore = itemView.findViewById(R.id.txtScore);
        subjectName = itemView.findViewById(R.id.subjectName);
        mGrade = itemView.findViewById(R.id.txtGrade);
    }
}

class ScoreAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context ctx;
    private List<HashMap<String, Object>> data;

    public ScoreAdapter(Context ctx, List<HashMap<String, Object>> data) {
        this.ctx = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx.getApplicationContext()).inflate(R.layout.result_sheet_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        double score = (double) data.get(position).get("score");
        holder.mScore.setText((String.valueOf(score)));
        holder.subjectName.setText((String) (data.get(position).get("subjectName")));
        holder.mGrade.setText(score < 7 ? "Fail" : "Pass");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
