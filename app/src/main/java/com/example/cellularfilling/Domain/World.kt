package com.example.cellularfilling.Domain

import com.example.cellularfilling.R
import kotlin.random.Random

class World {
    private val cells = mutableListOf<Cell>()
    private var livingStreak: Int = 0
    private var deadStreak: Int = 0

    fun addRandomCell() {
        val newCell: Cell
        if (Random.nextBoolean()) {
            newCell = LivingCell(R.drawable.living_cell, "Живая", "и шевелится!")
            livingStreak++
            deadStreak = 0
        } else {
            newCell = DeadCell(R.drawable.dead_cell, "Мёртвая", "или прикидывается")
            deadStreak++
            livingStreak = 0
        }
        cells.add(newCell)
        checkStreaks()
    }

    private fun checkStreaks() {
        if (livingStreak == 3) {
            cells.add(LivingCell(R.drawable.life_cell, "Жизнь", "Ку-ку!"))
            livingStreak = 0
        } else if (deadStreak == 3) {
            cells.add(DeadCell(R.drawable.death_cell, "Мёртвая", "Жизнь рядом умирает"))
            deadStreak = 0
            lifeEnd()
        }
    }

    fun getCells(): List<Cell> = cells

    private fun lifeEnd() {
        // Проверить, является ли последняя добавленная клетка клеткой смерти
        val lastIndex = cells.size - 1
        if (lastIndex >= 0 && cells[lastIndex] is DeadCell) {
            // Проверить предыдущую клетку
            if (lastIndex > 0 && cells[lastIndex - 1] is LivingCell) {
                cells[lastIndex - 1] = DeadCell(R.drawable.death_cell, "Мёртвая", "Жизнь рядом умирает")
            }
            // Проверить клетку перед предыдущей
            if (lastIndex > 1 && cells[lastIndex - 2] is LivingCell) {
                cells[lastIndex - 2] = DeadCell(R.drawable.death_cell, "Мёртвая", "Жизнь рядом умирает")
            }
        }
    }
}