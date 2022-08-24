package com.vmloft.develop.library.im.chat.msg

import android.view.LayoutInflater
import android.view.ViewGroup

import com.vmloft.develop.library.im.bean.IMMessage
import com.vmloft.develop.library.im.databinding.ImItemMsgCallReceiveDelegateBinding

/**
 * Create by lzan13 on 2021/01/05 17:56
 * 描述：展示通话记录消息 Item
 */
class MsgCallReceiveDelegate(listener: BItemLongListener<IMMessage>) : MsgCommonDelegate<ImItemMsgCallReceiveDelegateBinding>(longListener = listener) {

    override fun initVB(inflater: LayoutInflater, parent: ViewGroup) = ImItemMsgCallReceiveDelegateBinding.inflate(inflater, parent, false)

    override fun onBindView(holder: BItemHolder<ImItemMsgCallReceiveDelegateBinding>, item: IMMessage) {
        super.onBindView(holder, item)

        holder.binding.imMsgContentTV.text = item.body
    }
}
