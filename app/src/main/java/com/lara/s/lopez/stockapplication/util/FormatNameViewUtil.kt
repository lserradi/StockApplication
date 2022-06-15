package com.lara.s.lopez.stockapplication.util

import com.lara.s.lopez.domain.model.CategoryType
import javax.inject.Inject

open class FormatNameViewUtil @Inject constructor() {

    fun formatNameStock(nameStock: String, nameView: String): String {
        return StringBuilder(nameView).append(": ").append(nameStock).toString()
    }

    fun formatHotStock(hotStock: String, nameView: String): String {
        return StringBuilder(nameView).append(": ").append(hotStock).toString()
    }

    fun formatRicCodeStock(ricCodeStock: String, nameView: String): String {
        return StringBuilder(nameView).append(": ").append(ricCodeStock).toString()
    }

    fun formatCategoryStock(category: CategoryType, nameView: String): String {
        val nameCategory = when (category) {
            CategoryType.PRIMARY -> "Primary"
            CategoryType.INDUSTRY_AND_ENERGY -> "Industry & Energy"
            CategoryType.BUILDING -> "Building"
        }
        return StringBuilder(nameView).append(": ").append(nameCategory).toString()
    }
}