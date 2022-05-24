package co.tiagoaguiar.codelab.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private View btnImc;
    private RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btnImc = findViewById(R.id.btn_imc);
        rvMain = findViewById(R.id.main_rv);

        List<MainItem> mainItems = new ArrayList<>();
        mainItems.add(new MainItem(1, R.drawable.ic_baseline_wb_sunny_24, R.string.label_imc, Color.GREEN));
        mainItems.add(new MainItem(2, R.drawable.ic_baseline_visibility_24, R.string.label_tmb, Color.YELLOW));


        // 1 -> Definir o comportamento de exibição do layout da recyclerview
        // mosaic
        // grid
        // linear (horizontal | vertical)
        rvMain.setLayoutManager(new GridLayoutManager(this, 2));
        MainAdpter adpter = new MainAdpter(mainItems);
        rvMain.setAdapter(adpter);

        //btnImc.setOnClickListener(view -> {
        //Intent intent = new Intent(MainActivity.this, ImcActivity.class);
        //startActivity(intent);
        //});
    }

    private class MainAdpter extends RecyclerView.Adapter<MainViewHolder> {

        private List<MainItem> mainItems;

        public MainAdpter(List<MainItem> mainItems) {
            this.mainItems = mainItems;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(getLayoutInflater().inflate(R.layout.main_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            MainItem mainItemCurrent = mainItems.get(position);
            holder.bind(mainItemCurrent);
        }

        @Override
        public int getItemCount() {
            return mainItems.size();
        }
    }

    // Entenda com sendo a VIEW DA CELULA que está dentro do RecyclerView
    private class MainViewHolder extends RecyclerView.ViewHolder {

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(MainItem item) {
            TextView txtName = itemView.findViewById(R.id.item_txt_name);
            ImageView imageIcon = itemView.findViewById(R.id.item_img_icon);
            LinearLayout container = (LinearLayout) itemView.findViewById(R.id.btn_imc);


            txtName.setText(item.getTextStringId());
            imageIcon.setImageResource(item.getDrawableId());
            container.setBackgroundColor(item.getColor());

        }

    }

}