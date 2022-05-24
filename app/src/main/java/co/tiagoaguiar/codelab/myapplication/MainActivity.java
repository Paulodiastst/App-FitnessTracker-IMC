package co.tiagoaguiar.codelab.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

	//private View btnImc;
	private RecyclerView rvMain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//btnImc = findViewById(R.id.btn_imc);
		rvMain = findViewById(R.id.main_rv);


		// 1 -> Definir o comportamento de exibição do layout da recyclerview
			// mosaic
			// grid
		 	// linear (horizontal | vertical)
		rvMain.setLayoutManager(new LinearLayoutManager(this));

		MainAdpter adpter = new MainAdpter();
		rvMain.setAdapter(adpter);

		//btnImc.setOnClickListener(view -> {
			//Intent intent = new Intent(MainActivity.this, ImcActivity.class);
			//startActivity(intent);
		//});
	}

	private class MainAdpter extends RecyclerView.Adapter<MainViewHolder> {

		@NonNull
		@Override
		public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
			return new MainViewHolder(getLayoutInflater().inflate(R.layout.main_item, parent, false));
		}

		@Override
		public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
			holder.bind(position);
		}

		@Override
		public int getItemCount() {
			return 15;
		}
	}

	// Entenda com sendo a VIEW DA CELULA que está dentro do RecyclerView
	private class MainViewHolder extends RecyclerView.ViewHolder {

		public MainViewHolder(@NonNull View itemView) {
			super(itemView);
		}

		public void bind(int position) {
			TextView textTest = itemView.findViewById(R.id.textview_test);
			textTest.setText("teste de rolabem" + position);

		}

	}

}