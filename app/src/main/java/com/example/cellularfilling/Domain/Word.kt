package com.example.cellularfilling.Domain

import com.example.cellularfilling.R
import kotlin.random.Random

class Word {
    private val cells = mutableListOf<Cell>()
    private var livingStreak: Int = 0
    private var deadStreak: Int = 0
    
    fun addRandomCell(){
        val newCell: Cell
        if(Random.nextBoolean()){
            newCell = LivingCell(R.drawable.living_cell, "Живая", "и шевелится!")
            livingStreak++
            deadStreak = 0
        } else {
            newCell = DeadCell(R.drawable.dead_cell, "Мёртвая", "или прикидывается")
            deadStreak++
            livingStreak = 0
        }
        cells.add(newCell)
        //chechStreaks()
    }

    private fun checkStreaks(){
        if (livingStreak == 3){
            cells.add(LivingCell(R.drawable.life_cell, "Жизнь", "Ку-ку!"))
            livingStreak = 0
        } else if (deadStreak == 3){
            //TODO() Добавить клетку смерти
        }
    }

    fun getCells(): List<Cell> = cells
}