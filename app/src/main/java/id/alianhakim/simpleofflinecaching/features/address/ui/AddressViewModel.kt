package id.alianhakim.simpleofflinecaching.features.address.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.alianhakim.simpleofflinecaching.data.Address
import id.alianhakim.simpleofflinecaching.data.remote.AddressApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddressViewModel @Inject constructor(
    api: AddressApi
) : ViewModel() {

    private val addressLiveData = MutableLiveData<List<Address>>()
    val addresses: LiveData<List<Address>> = addressLiveData

    init {
        viewModelScope.launch {
            val addresses = api.getAddresses()
            addressLiveData.value = addresses
        }
    }
}