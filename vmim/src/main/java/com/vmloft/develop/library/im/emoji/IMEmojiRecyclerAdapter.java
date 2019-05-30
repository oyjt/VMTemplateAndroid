package com.vmloft.develop.library.im.emoji;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vmloft.develop.library.im.R;
import com.vmloft.develop.library.tools.adapter.VMAdapter;
import com.vmloft.develop.library.tools.adapter.VMHolder;
import com.vmloft.develop.library.tools.utils.VMLog;

/**
 * Create by lzan13 on 2019/5/29 14:16
 *
 * 表情适配器
 */
public class IMEmojiRecyclerAdapter extends VMAdapter<IMEmojiItem, IMEmojiRecyclerAdapter.EmojiHolder> {

    private IMEmojiGroup mEmojiGroup;


    public IMEmojiRecyclerAdapter(Context context, IMEmojiGroup group) {
        super(context);
        mEmojiGroup = group;
        mDataList = mEmojiGroup.mEmojiItemList;
        VMLog.d("初始化表情适配器 表情数: %d", getItemCount());
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int type) {
        View view = mInflater.inflate(R.layout.im_emoji_recycler_view_item, parent, false);
        return new EmojiHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        IMEmojiItem item = getItemData(position);
        if (item.isEmoji) {
            holder.mIconView.setImageResource(item.mEmojiResId);
            holder.mNameView.setVisibility(View.GONE);
        } else {
            // TODO 从服务器下载的表情加载
        }
    }

    class EmojiHolder extends VMHolder {
        public ImageView mIconView;
        public TextView mNameView;

        public EmojiHolder(View itemView) {
            super(itemView);
            mIconView = itemView.findViewById(R.id.im_emoji_item_icon_iv);
            mNameView = itemView.findViewById(R.id.im_emoji_item_name_tv);
        }
    }
}
