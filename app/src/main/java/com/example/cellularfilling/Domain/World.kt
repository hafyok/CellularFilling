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
            cells.add(DeadCell(R.drawable.death_cell, "Мёртвая", "Жизнь умирает"))
            deadStreak = 0
        }
    }

    fun getCells(): List<Cell> = cells
}