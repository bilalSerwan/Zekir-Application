package com.fastlink.zekirapp.di

import com.fastlink.zekirapp.appData.model.ZekirModel
import com.fastlink.zekirapp.appData.zekirData

object ZekirSingleton {
    private val _zekirs = mutableListOf<ZekirModel>()
    fun getZekirsByCategoryId(categoryId: Int): List<ZekirModel> {
        var zekirs = _zekirs.filter { it.categoryId == categoryId }
        zekirs = zekirs.map { zekir ->
            zekir.copy(counter = 0)
        }
        return zekirs
    }

    init {
        addZekrs()
    }

    private fun addZekrs() {
        for (i in zekirData) {
            _zekirs.add(i.copy(counter = 0))
        }
    }
}
