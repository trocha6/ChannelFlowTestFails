package com.temppackage.viewmodeltest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOn


class NumbersProvider {
    val numbersFlow: Flow<Int> = channelFlow {
        var i = 0
        while (i < 10) {
            delay(100)
            send(i)
            i++
        }
    }.flowOn(Dispatchers.IO)
}