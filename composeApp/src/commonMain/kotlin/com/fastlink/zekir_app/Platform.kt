package com.fastlink.zekir_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform