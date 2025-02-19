package com.example.cafe2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderDetailActivity extends AppCompatActivity {
    private static final String EXTRA_USERNAME = "username";
    private static final String EXTRA_DRINK = "drink";
    private static final String EXTRA_DRINK_TYPE = "drinkType";
    private static final String EXTRA_ADDITIVES = "additives";
    private TextView tv_additives;
    private TextView tvDrinkType;
    private TextView tvDrinkName;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        Intent intent = getIntent();
        setContentViews(intent);
    }

    private void setContentViews(Intent intent) {
        tvName.setText(intent.getStringExtra(EXTRA_USERNAME));
        tvDrinkName.setText(intent.getStringExtra(EXTRA_DRINK));
        tvDrinkType.setText(intent.getStringExtra(EXTRA_DRINK_TYPE));
        tv_additives.setText(
                intent.getStringExtra(EXTRA_ADDITIVES)
                        .replace("[", "")
                        .replace("]", " "));
    }

    public static Intent newIntent(
            Context context,
            String username,
            String drink,
            String drinkType,
            String additives
    ) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra(EXTRA_USERNAME, username);
        intent.putExtra(EXTRA_DRINK, drink);
        intent.putExtra(EXTRA_DRINK_TYPE, drinkType);
        intent.putExtra(EXTRA_ADDITIVES, additives);
        return intent;
    }

    private void initViews() {
        tvName = findViewById(R.id.tvName);
        tvDrinkName = findViewById(R.id.tvDrinkName);
        tvDrinkType = findViewById(R.id.tvDrinkType);
        tv_additives = findViewById(R.id.tv_additives);
    }
}