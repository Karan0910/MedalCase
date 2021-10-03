package com.medalcase.model

sealed class RecordCollection {
    abstract val id: Long
    abstract val name: String


}

data class Medal(
    override val id: Long,
    override val name: String,
    val recordValue: String,
    val isCompleted: Boolean
) : RecordCollection()

data class Header(
    override val id: Long,
    override val name: String,
    val count: Int
) : RecordCollection()


private val recordList = listOf(
    Header(1,"Personal records",4),
    Medal(1, "Virtual Half Marathon Race", "00:00", true),
    Medal(1, "Tokyo-Hakone Ekiden 2020", "00:00:00", true),
    Medal(1, "Virtual 10K Race", "00:00:00", true),
    Medal(1, "Hakone Ekiden", "00:00", true),
    Medal(1, "Mizuno Singapore Ekiden 2015", "00:00:00", true),
    Medal(1, "Virtual 5K Race", "23:07", true),
    Header(1,"Virtual Races",4),
    Medal(1, "Longest Run", "00:00", true),
    Medal(1, "Highest Elevation", "00:00", true),
    Medal(1, "Fastest 5K", "00:00", true),
    Medal(1, "10K", "00:00", true),
    Medal(1, "Half Marathon", "00:00:00", true),
    Medal(1, "Marathon", "00:00", false)
)

object RecordsRepo{
    fun getRecords(): List<RecordCollection> = recordList
}