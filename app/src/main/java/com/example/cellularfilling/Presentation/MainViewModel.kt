package com.example.cellularfilling.Presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cellularfilling.Domain.Cell
import com.example.cellularfilling.Domain.World
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val world = World()

    private val _cells = MutableStateFlow<List<Cell>>(emptyList())
    //val cells = mutableStateListOf<Cell>()
    val cells: StateFlow<List<Cell>> = _cells.asStateFlow()

    /*init {
        updateCells()
    }*/

    fun addRandomCell() {
        world.addRandomCell()
        updateCells()
    }

    private fun updateCells() {
        _cells.value = world.getCells().toList()
        Log.d("ViewModel", _cells.value.toString())
    }
}