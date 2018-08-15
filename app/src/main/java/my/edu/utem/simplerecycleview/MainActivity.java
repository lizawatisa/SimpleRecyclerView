package my.edu.utem.simplerecycleview;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        CustomAdapter adapter = new CustomAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView wordTextView;

        public CustomViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.custom_row, parent, false)); //buka fail custom_row
            wordTextView = itemView.findViewById(R.id.wordTextView);
        }
    }

    public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder>{

        public final String[] restaurantNames;

        public  CustomAdapter(Context context){
            Resources resources = context.getResources();
            restaurantNames = resources.getStringArray(R.array.restaurant_name);
        }
        //utk find view id row nak pakai yg mana. akan link dgn custom_row.xml
        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new CustomViewHolder(LayoutInflater.from(viewGroup.getContext()),viewGroup); //standard coding hanya tukar CustomViewHolder
        }

        //apa nak tunjuk utk setiap row
        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
            customViewHolder.wordTextView.setText(restaurantNames[i]);
        }

        //brp kali
        @Override
        public int getItemCount() {
            //return 10; //ada 10 row
            return restaurantNames.length;
        }
    }
}
