package com.ayoolamasha.uidesignassignment.data

data class AvailableVehiclesData(
    val freightType: Int,
    val freightSub: Int,
    val freightImage: Int,
)

data class ShipmentData(
    val shipmentStatus: Int,
    val shipmentStatusIcon: Int,
    val shipmentHeader: Int,
    val shipmentHeaderSub: Int,
    val shipmentAmount: Int,
    val shipmentDate: Int,
)

data class SearchData(
    val searchItemName: String,
    val searchItemShipmentCode: String,
    val searchItemSenderLocation: String,
    val searchItemReceiverLocation: String,

)