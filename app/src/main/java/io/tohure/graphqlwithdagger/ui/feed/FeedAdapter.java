package io.tohure.graphqlwithdagger.ui.feed;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.tohure.graphqlwithdagger.FeedQuery;
import io.tohure.graphqlwithdagger.R;

/**
 * Created by tohure on 1/03/18.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedItemViewHolder> {

    private final List<FeedQuery.FeedEntry> feedEntries;

    FeedAdapter() {
        this.feedEntries = new ArrayList<>();
    }

    void addData(List<FeedQuery.FeedEntry> feedEntries) {
        this.feedEntries.addAll(feedEntries);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FeedItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_feed, parent, false);
        return new FeedItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdapter.FeedItemViewHolder holder, int position) {

        if (feedEntries.get(position).postedBy() != null) {
            holder.lblItem1.setText(String.format("@%s", feedEntries.get(position).postedBy().login()));
        } else {
            holder.lblItem1.setText(String.valueOf(feedEntries.get(position).id()));
        }

        if (feedEntries.get(position).repository() != null) {
            holder.lblItem2.setText(feedEntries.get(position).repository().fragments().repositoryFragment().full_name());
        } else {
            holder.lblItem2.setText(R.string.not_repository);
        }

    }

    @Override
    public int getItemCount() {
        return feedEntries.size();
    }

    class FeedItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView lblItem1;
        private final TextView lblItem2;

        FeedItemViewHolder(View itemView) {
            super(itemView);
            lblItem1 = itemView.findViewById(R.id.lblItem1);
            lblItem2 = itemView.findViewById(R.id.lblItem2);
        }
    }
}
