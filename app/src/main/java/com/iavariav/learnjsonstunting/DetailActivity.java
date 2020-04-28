package com.iavariav.learnjsonstunting;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivDetail;
    private TextView tvTitleDetail;
    private TextView tvJenisDetail;
    private TextView tvIsiDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();

        Glide.with(this).load(getIntent()
                .getStringExtra("URL_IMAGE"))
                .error(R.drawable.ic_dashboard_black_24dp)
                .into(ivDetail);

        tvTitleDetail.setText(getIntent().getStringExtra("TITLE"));
        tvJenisDetail.setText(getIntent().getStringExtra("JENIS"));
        tvIsiDetail.setText(getIntent().getStringExtra("ISI"));
    }

    private void initView() {
        ivDetail = findViewById(R.id.iv_detail);
        tvTitleDetail = findViewById(R.id.tv_title_detail);
        tvJenisDetail = findViewById(R.id.tv_jenis_detail);
        tvIsiDetail = findViewById(R.id.tv_isi_detail);
    }
}
