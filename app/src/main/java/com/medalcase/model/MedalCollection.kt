package com.medalcase.model

import com.medalcase.R

sealed class RecordCollection {
    abstract val id: Long
    abstract val name: String

}

data class Medal(
    override val id: Long,
    override val name: String,
    val recordValue: String,
    val imageUrl: Int,
    val isCompleted: Boolean
) : RecordCollection()

data class Header(
    override val id: Long,
    override val name: String,
    val completedCount: Int? = 0,
    val totalCount: Int? = 0
) : RecordCollection()

private val personalRecordsList = listOf(
    Medal(1, "Longest Run", "00:00", R.drawable.ic_virtual_half_marathon_race, true),
    Medal(1, "Highest Elevation", "00:00", R.drawable.ic_highest_elevation, true),
    Medal(1, "Fastest 5K", "00:00", R.drawable.ic_fastest_5k, true),
    Medal(1, "10K", "00:00", R.drawable.ic_fastest_10k, true),
    Medal(1, "Half Marathon", "00:00:00", R.drawable.ic_fastest_half_marathon, false),
    Medal(1, "Marathon", "00:00", R.drawable.ic_fastest_marathon, false)
)

private val vertualRacesList = listOf(
    Medal(1, "Virtual Half Marathon Race", "00:00", R.drawable.ic_longest_run, true),
    Medal(1, "Tokyo-Hakone Ekiden 2020", "00:00:00", R.drawable.ic_highest_elevation, true),
    Medal(1, "Virtual 10K Race", "00:00:00", R.drawable.ic_fastest_5k, true),
    Medal(1, "Hakone Ekiden", "00:00", R.drawable.ic_fastest_10k, true),
    Medal(
        1,
        "Mizuno Singapore Ekiden 2015",
        "00:00:00",
        R.drawable.ic_fastest_half_marathon,
        false
    ),
    Medal(1, "Virtual 5K Race", "23:07", R.drawable.ic_fastest_marathon, true)
)

private val recordCollection = hashMapOf<Header, List<Medal>>(
    Header(1, "Personal records") to personalRecordsList,
    Header(1, "Virtual Races") to vertualRacesList
)
private val recordList = listOf(
    Header(1, "Personal records", 4),
    Medal(1, "Longest Run", "00:00", R.drawable.ic_virtual_half_marathon_race, true),
    Medal(1, "Highest Elevation", "00:00", R.drawable.ic_highest_elevation, true),
    Medal(1, "Fastest 5K", "00:00", R.drawable.ic_fastest_5k, true),
    Medal(1, "10K", "00:00", R.drawable.ic_fastest_10k, true),
    Medal(1, "Half Marathon", "00:00:00", R.drawable.ic_fastest_half_marathon, true),
    Medal(1, "Marathon", "00:00", R.drawable.ic_fastest_marathon, false),
    Header(
        1, "Virtual Races", 4
    ),
    Medal(1, "Virtual Half Marathon Race", "00:00", R.drawable.ic_longest_run, true),
    Medal(1, "Tokyo-Hakone Ekiden 2020", "00:00:00", R.drawable.ic_highest_elevation, true),
    Medal(1, "Virtual 10K Race", "00:00:00", R.drawable.ic_fastest_5k, true),
    Medal(1, "Hakone Ekiden", "00:00", R.drawable.ic_fastest_10k, true),
    Medal(
        1,
        "Mizuno Singapore Ekiden 2015",
        "00:00:00",
        R.drawable.ic_fastest_half_marathon,
        false
    ),
    Medal(1, "Virtual 5K Race", "23:07", R.drawable.ic_fastest_marathon, true)

)

object RecordsRepo {
    fun getRecords(): List<RecordCollection> {
        val recordList = arrayListOf<RecordCollection>()

        val iterator = recordCollection.keys.iterator()
        while (iterator.hasNext()) {
            val key = iterator.next()
            val value = recordCollection[key]
            val recordCount = value?.size
            val recordCompleted = value?.filter { it.isCompleted }?.size
            recordList.add(Header(key.id, key.name, recordCompleted, recordCount))
            value?.let { recordList.addAll(it) }
        }

        return recordList
    }
}