package com.enterprise.bfire.firedeals;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class ProductDetails extends AppCompatActivity {
    TextView product;
    TextView category;
    TextView price, pros1, pros2, pros3, cons1, cons2, cons3;
    ImageView contentImage;
    ProgressBar progressBar;
    Button buyButton;
    Bundle bundle = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        product = findViewById(R.id.product_name_product_details);
        category = findViewById(R.id.category_product_details);
        price = findViewById(R.id.price_product_details);
        pros1 = findViewById(R.id.pros1_product_details);
        pros2 = findViewById(R.id.pros2_product_details);
        pros3 = findViewById(R.id.pros3_product_details);
        cons1 = findViewById(R.id.cons1_product_details);
        cons2 = findViewById(R.id.cons2_product_details);
        cons3 = findViewById(R.id.cons3_product_details);
        contentImage = findViewById(R.id.image_view_product_details);
        progressBar =  findViewById(R.id.progress_bar_product_details);
        buyButton = findViewById(R.id.buy_button_product_details);

        bundle = getIntent().getExtras();
        String productInfo = bundle.getString("productName");
        String categoryInfo = bundle.getString("category");
        String priceInfo = bundle.getString("price");
        String pros1Info = bundle.getString("pros1");
        String pros2Info = bundle.getString("pros2");
        String pros3Info = bundle.getString("pros3");
        String cons1Info = bundle.getString("cons1");
        String cons2Info = bundle.getString("cons2");
        String cons3Info = bundle.getString("cons3");
        final String affiliateLink = bundle.getString("affiliateLink");
        String image = bundle.getString("imageLink");

        product.setText(productInfo);
        category.setText(categoryInfo);
        price.setText("Price: ₹"+priceInfo);
        pros1.setText("1. "+pros1Info);
        pros2.setText("2. "+pros2Info);
        pros3.setText("3. "+pros3Info);
        cons1.setText("1. "+cons1Info);
        cons2.setText("2. "+cons2Info);
        cons3.setText("3. "+cons3Info);



        ImageLoader.getInstance().displayImage(image, contentImage, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBar.setVisibility(View.GONE);
            }
        });
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Uri uri = Uri.parse(affiliateLink); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
        });

    }
}
