package com.medalcase.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.medalcase.model.RecordCollection
import com.medalcase.model.RecordsRepo

class RecordsViewModel(): ViewModel(){

    private val _recordsLiveData = MutableLiveData<List<RecordCollection>>(RecordsRepo.getRecords())

    val recordsLiveData: LiveData<List<RecordCollection>>
        get() = _recordsLiveData

}