package com.example.quiziha.framework

import android.os.Bundle

sealed class OnClickEvent {
    data class OnClick(val clickId: String, val bundle : Bundle? = null) : OnClickEvent()
    data class Back(val bundle : Bundle? = null) : OnClickEvent()
}