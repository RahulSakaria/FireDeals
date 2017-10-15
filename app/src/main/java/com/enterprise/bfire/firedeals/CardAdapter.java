package com.enterprise.bfire.firedeals;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * Created by HP on 12-08-2017.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private ProgressBar progressBar;
    private List<CardItem> cardItems;

    private Context context;
    private LayoutInflater inflater;
    private int resource;
    public CardAdapter(Context context,int resource,List<CardItem> objects) {
        this.context = context;
        this.resource = resource;
        cardItems = objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardAdapter.ViewHolder holder, final int position) {
        final CardItem cardItem = cardItems.get(position);


        ImageLoader.getInstance().displayImage(cardItems.get(position).getImageLink(), holder.productImage, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
        holder.productName.setText(cardItem.getProductName());
        holder.productType.setText(cardItem.getProductType());
        holder.price.setText("Price:"+" ₹"+cardItem.getPrice());
        holder.pros1.setText("1."+cardItem.getPros1());
        holder.pros2.setText("2. "+cardItem.getPros2());
        holder.pros3.setText("3. "+cardItem.getPros3());
        holder.cons1.setText("1. "+cardItem.getCons1());
        holder.cons2.setText("2. "+cardItem.getCons2());
        holder.cons3.setText("3. "+cardItem.getCons3());
        holder.buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = cardItems.get(position).getAffiliateLink().toString();

                Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });
        holder.currentItem = cardItems.get(position);
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView productImage;
        public TextView productName,productType,price,pros1,pros2,pros3,cons1,cons2,cons3;
        public View view;
        public Button buyNow;
        public CardItem currentItem;


        public ViewHolder(View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progress_bar_card);
            productImage = itemView.findViewById(R.id.product_card_image);
            productName = itemView.findViewById(R.id.product_name_card);
            productType = itemView.findViewById(R.id.product_type_card);
            buyNow = itemView.findViewById(R.id.buy_now_button_card);
            price = itemView.findViewById(R.id.product_price_card);
            pros1 = itemView.findViewById(R.id.product_pros1_card);
            pros2 = itemView.findViewById(R.id.product_pros2_card);
            pros3 = itemView.findViewById(R.id.product_pros3_card);
            cons1 = itemView.findViewById(R.id.product_cons1_card);
            cons2 = itemView.findViewById(R.id.product_cons2_card);
            cons3 = itemView.findViewById(R.id.product_cons3_card);
            view = itemView;
        }
    }
}
