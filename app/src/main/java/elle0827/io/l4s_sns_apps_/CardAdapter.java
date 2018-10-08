package elle0827.io.l4s_sns_apps_;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class CardAdapter extends ArrayAdapter<Post> {
    private List<Post> mCards;
    OnLikeClickListener likeClickListener = null;
//＜＞ダイアモンド演算子：List<A> 中身がAのList

    public CardAdapter(Context context, int layoutResourceId, List<Post> objects) {
        super(context, layoutResourceId, objects);

        mCards = objects;

    }

    @Override
    public int getCount() {
        return mCards.size();
    }
//    ニュース（要素数）が何個あるか

    @Override
    public Post getItem(int position) {
        return mCards.get(position);
    }

    //なんばん目のニュース（要素）か
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        final Post item = getItem(position);
        if (item != null) {
            viewHolder.titleTextView.setText(item.getMemo());
            viewHolder.contentTextView.setText(item.getUrl());
            Picasso.get().load(item.getUrl()).into(viewHolder.ImageId);
            viewHolder.likecountTextView.setText(String.valueOf(item.getLikeCount()));
            viewHolder.likeImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (likeClickListener != null) {
                        likeClickListener.onLikeClick(position);
                    }
                }


            });
        }

        return convertView;

    }


    public Post getCardBykey(String key) {
        for (Post card : mCards) {
            if (card.getkey().equals(key)) {
                return card;
            }
        }
        return null;
    }


    public void setOnLikeClickListener(OnLikeClickListener likeClickListener) {
        this.likeClickListener = likeClickListener;
    }


    public static class ViewHolder {
        ImageView likeImage;
        TextView titleTextView;
        TextView contentTextView;
        ImageView ImageId;
        TextView likecountTextView;

        public ViewHolder(View view) {
            likeImage = (ImageView) view.findViewById(R.id.like_image);
            titleTextView = (TextView) view.findViewById(R.id.titleTextView);
            contentTextView = (TextView) view.findViewById(R.id.contentTextView);
            ImageId = (ImageView) view.findViewById(R.id.ImageId);
            likecountTextView = (TextView) view.findViewById(R.id.like_count);
        }
    }

    interface OnLikeClickListener {
        void onLikeClick(int position);
    }
}
