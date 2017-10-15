package com.enterprise.bfire.firedeals;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    public CardAdapter(Context context, int resource, List<CardItem> objects) {
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
        holder.price.setText("Price:" + " ₹" + cardItem.getPrice());
        holder.buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = cardItems.get(position).getAffiliateLink().toString();
                try {
                    Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    context.startActivity(intent);
                } catch (Exception e) {
                    System.out.print(e);
                }


            }
        });
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("productName",cardItem.getProductName());
                intent.putExtra("category",cardItem.getProductType());
                intent.putExtra("price",cardItem.getPrice());
                intent.putExtra("pros1",cardItem.getPros1());
                intent.putExtra("pros2",cardItem.getPros2());
                intent.putExtra("pros3",cardItem.getPros3());
                intent.putExtra("cons1",cardItem.getCons1());
                intent.putExtra("cons2",cardItem.getCons2());
                intent.putExtra("cons3",cardItem.getCons3());
                intent.putExtra("affiliateLink",cardItem.getAffiliateLink());
                intent.putExtra("imageLink",cardItem.getImageLink());
                context.startActivity(intent);
            }
        });
        holder.currentItem = cardItems.get(position);
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView productImage;
        public TextView productName, price;
        public View view;
        public Button buyNow;
        public CardItem currentItem;
        public RelativeLayout relativeLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progress_bar_card);
            productImage = itemView.findViewById(R.id.product_card_image);
            productName = itemView.findViewById(R.id.product_name_card);
            buyNow = itemView.findViewById(R.id.buy_now_button_card);
            price = itemView.findViewById(R.id.product_price_card);
            relativeLayout = itemView.findViewById(R.id.relative_layout_cards);
            view = itemView;
        }
    }
}
