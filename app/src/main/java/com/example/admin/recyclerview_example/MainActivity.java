package com.example.admin.recyclerview_example;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private ArrayList<MyModel> myModels;

    @Override
    public void onClick(View view) {
        Log.d("V", "View: " + view.getTag());
        int position = Integer.parseInt(view.getTag().toString());
        boolean state = myModels.get(position).state;
        myModels.get(position).state = state;
        adapter.notifyItemChanged(position);
    }

    class MyModel {
        public String title;
        public boolean state;
        private long id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = RecyclerView.class.cast(findViewById(R.id.recyclerView));
        recyclerView.setOnClickListener(this);

        myModels = new ArrayList<>();
        
        for (int i = 0; i < 80; i++) {
            MyModel nModel = new MyModel();
            nModel.title = "Item number " + i;
            nModel.id = i;
            myModels.add(nModel);
        }
        
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        adapter = new RecyclerAdapter(myModels);
        recyclerView.setAdapter(adapter);
    }

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements View.OnClickListener{
        private static final String TAG = "ViewHolder";
        private ArrayList<MyModel> myModels;
        int i;

        @Override
        public void onClick(View view) {
            Log.d(TAG, "V adaptere: " + view.getParent());
           // Log.d(TAG,  "hashCode " + myModels.get(view.getTag().toString()) );
            Integer position = (Integer) view.getTag();
            myModels.get(position).state = !myModels.get(position).state;
            //notifyItemChanged(position);
            view.setBackgroundColor(myModels.get(position).state ? Color.CYAN : Color.WHITE);
//            Log.d(TAG, "Vasja: " + view.getTag(R.id.recyclerView));
        }

        public  class ViewHolder extends RecyclerView.ViewHolder{

            public TextView tvTitle;
            public TextView tvId;
            private View itemView;
            private MyModel myModel;

            public ViewHolder(View itemView) {
                super(itemView);
                this.itemView = itemView;
                tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
                tvId = (TextView)itemView.findViewById(R.id.tvId);
            }

            public void bindModel(MyModel mymodel){
                myModel = mymodel;
                tvId.setText(""+myModel.id);
                tvTitle.setText(myModel.title);
                itemView.setTag(Integer.valueOf(getAdapterPosition()));
//                itemView.setTag(R.id.recyclerView, "Vasja");
                itemView.setBackgroundColor(mymodel.state ? Color.CYAN : Color.WHITE);
            }
        }

        public RecyclerAdapter(ArrayList<MyModel> myModels) {
            this.myModels = myModels;
        }

        @Override
        public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_item, parent, false);
            v.setOnClickListener(this);

            ViewHolder viewHolder = new ViewHolder(v);
            Log.d(TAG, "V count:" + ++i);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, final int position) {

            final MyModel model = myModels.get(position);
            holder.bindModel(model);
        }

        @Override
        public int getItemCount() {
            return myModels.size();
        }
    }
}
