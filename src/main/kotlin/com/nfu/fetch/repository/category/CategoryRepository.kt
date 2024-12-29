package com.nfu.fetch.repository.category

import com.nfu.fetch.entity.category.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository: JpaRepository<Category, Long> {
}