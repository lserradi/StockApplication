package com.lara.s.lopez.stockapplication.util

import com.lara.s.lopez.domain.model.CategoryType
import javax.inject.Inject

open class FormatNameViewUtil @Inject constructor() {

    fun formatCategoryStock(category: CategoryType): String {
        val nameCategory = when (category) {
            CategoryType.PRIMARY -> "Primary"
            CategoryType.INDUSTRY_AND_ENERGY -> "Industry & Energy"
            CategoryType.BUILDING -> "Building"
        }
        return StringBuilder(nameCategory).toString()
    }
}