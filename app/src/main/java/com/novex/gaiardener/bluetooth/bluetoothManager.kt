package com.novex.gaiardener.bluetooth

import android.bluetooth.BluetoothDevice
import androidx.compose.runtime.mutableStateOf

object BluetoothManager {
    var isConnected = mutableStateOf(false)
    var connectedDevice: BluetoothDevice? = null

    fun connectToDevice(device: BluetoothDevice) {
        if (connectedDevice == device && isConnected.value) {
            return // Si ya está conectado, no hace nada
        }
        // Lógica de conexión real
        connectedDevice = device
        isConnected.value = true
    }

    fun disconnectDevice() {
        // Lógica de desconexión real
        connectedDevice = null
        isConnected.value = false
    }
}
