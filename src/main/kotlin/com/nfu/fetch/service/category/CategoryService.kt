package com.nfu.fetch.service.category

import com.nfu.fetch.repository.category.CategoryRepository
import com.nfu.fetch.repository.category.QCategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository,
    private val qCategoryRepository: QCategoryRepository,
) {
}