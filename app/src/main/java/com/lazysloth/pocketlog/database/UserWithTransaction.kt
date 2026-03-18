package com.lazysloth.pocketlog.database

import androidx.room.Embedded
import androidx.room.Relation

data class TransactionByUser(
    @Embedded val id : User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val transactionById: List<Transaction>? = null
)
