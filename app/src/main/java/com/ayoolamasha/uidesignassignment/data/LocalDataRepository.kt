package com.ayoolamasha.uidesignassignment.data

import com.ayoolamasha.uidesignassignment.R


object LocalDataRepository {

    fun allShipmentDataSource(): List<ShipmentData>{
        return listOf(
            ShipmentData(
                shipmentStatus = R.string.in_progress,
                shipmentStatusIcon = R.drawable.progress,
                shipmentHeader = R.string.arriving_today,
                shipmentHeaderSub = R.string.arriving_today_details,
                shipmentAmount = R.string.fourteen_usd,
                shipmentDate = R.string.shipment_date,
            ),

            ShipmentData(
                shipmentStatus = R.string.pending,
                shipmentStatusIcon = R.drawable.history_outline,
                shipmentHeader = R.string.arriving_today,
                shipmentHeaderSub = R.string.arriving_today_details,
                shipmentAmount = R.string.six_fifty_usd,
                shipmentDate = R.string.shipment_date,
            ),

            ShipmentData(
                shipmentStatus = R.string.pending,
                shipmentStatusIcon = R.drawable.history_outline,
                shipmentHeader = R.string.arriving_today,
                shipmentHeaderSub = R.string.arriving_today_details,
                shipmentAmount = R.string.six_fifty_usd,
                shipmentDate = R.string.shipment_date,
            ),

            ShipmentData(
                shipmentStatus = R.string.loading,
                shipmentStatusIcon = R.drawable.pace_rounded,
                shipmentHeader = R.string.arriving_today,
                shipmentHeaderSub = R.string.arriving_today_details,
                shipmentAmount = R.string.two_thirty_usd,
                shipmentDate = R.string.shipment_date,
            ),

            ShipmentData(
                shipmentStatus = R.string.loading,
                shipmentStatusIcon = R.drawable.pace_rounded,
                shipmentHeader = R.string.arriving_today,
                shipmentHeaderSub = R.string.arriving_today_details,
                shipmentAmount = R.string.two_thirty_usd,
                shipmentDate = R.string.shipment_date,
            ),

            ShipmentData(
                shipmentStatus = R.string.in_progress,
                shipmentStatusIcon = R.drawable.progress,
                shipmentHeader = R.string.arriving_today,
                shipmentHeaderSub = R.string.arriving_today_details,
                shipmentAmount = R.string.three_seventy_usd,
                shipmentDate = R.string.shipment_date,
            ),

            ShipmentData(
                shipmentStatus = R.string.in_progress,
                shipmentStatusIcon = R.drawable.progress,
                shipmentHeader = R.string.arriving_today,
                shipmentHeaderSub = R.string.arriving_today_details,
                shipmentAmount = R.string.three_seventy_usd,
                shipmentDate = R.string.shipment_date,
            ),

            ShipmentData(
                shipmentStatus = R.string.pending,
                shipmentStatusIcon = R.drawable.history_outline,
                shipmentHeader = R.string.arriving_today,
                shipmentHeaderSub = R.string.arriving_today_details,
                shipmentAmount = R.string.two_thirty_usd,
                shipmentDate = R.string.shipment_date,
            ),

            ShipmentData(
                shipmentStatus = R.string.loading,
                shipmentStatusIcon = R.drawable.pace_rounded,
                shipmentHeader = R.string.arriving_today,
                shipmentHeaderSub = R.string.arriving_today_details,
                shipmentAmount = R.string.fourteen_usd,
                shipmentDate = R.string.shipment_date,
            ),

            ShipmentData(
                shipmentStatus = R.string.in_progress,
                shipmentStatusIcon = R.drawable.progress,
                shipmentHeader = R.string.arriving_today,
                shipmentHeaderSub = R.string.arriving_today_details,
                shipmentAmount = R.string.two_thirty_usd,
                shipmentDate = R.string.shipment_date,
            ),
        )
    }

    fun inProgressShipmentData(): List<ShipmentData>{
        return listOf(
            ShipmentData(
                shipmentStatus = R.string.in_progress,
                shipmentStatusIcon = R.drawable.progress,
                shipmentHeader = R.string.arriving_today,
                shipmentHeaderSub = R.string.arriving_today_details,
                shipmentAmount = R.string.three_seventy_usd,
                shipmentDate = R.string.shipment_date,
            ),

            ShipmentData(
                shipmentStatus = R.string.in_progress,
                shipmentStatusIcon = R.drawable.progress,
                shipmentHeader = R.string.arriving_today,
                shipmentHeaderSub = R.string.arriving_today_details,
                shipmentAmount = R.string.three_seventy_usd,
                shipmentDate = R.string.shipment_date,
            ),

            ShipmentData(
                shipmentStatus = R.string.in_progress,
                shipmentStatusIcon = R.drawable.progress,
                shipmentHeader = R.string.arriving_today,
                shipmentHeaderSub = R.string.arriving_today_details,
                shipmentAmount = R.string.fourteen_usd,
                shipmentDate = R.string.shipment_date,
            ),

            ShipmentData(
                shipmentStatus = R.string.in_progress,
                shipmentStatusIcon = R.drawable.progress,
                shipmentHeader = R.string.arriving_today,
                shipmentHeaderSub = R.string.arriving_today_details,
                shipmentAmount = R.string.two_thirty_usd,
                shipmentDate = R.string.shipment_date,
            ),
        )
    }

    fun searchItemsData(): List<SearchData>{
        return listOf(
            SearchData(
                searchItemName = "Macbook pro M2",
                searchItemShipmentCode = "#NEJ20089934122231",
                searchItemSenderLocation = "Paris",
                searchItemReceiverLocation = "Morocco",
            ),

            SearchData(
                searchItemName = "Tapered-fit jeans AW",
                searchItemShipmentCode = "#NEJ20089934135492",
                searchItemSenderLocation = "Colombia",
                searchItemReceiverLocation = "Paris",
            ),

            SearchData(
                searchItemName = "Summer linen jacket",
                searchItemShipmentCode = "#NEJ20089934100886",
                searchItemSenderLocation = "Barcelona",
                searchItemReceiverLocation = "Paris",
            ),

            SearchData(
                searchItemName = "Office setup desk",
                searchItemShipmentCode = "#NEJ20089934156683",
                searchItemSenderLocation = "France",
                searchItemReceiverLocation = "Germany",
            ),

            SearchData(
                searchItemName = "Slim fit jeans AW",
                searchItemShipmentCode = "#NEJ20089934145322",
                searchItemSenderLocation = "Bogota",
                searchItemReceiverLocation = "Dhaka",
            ),
        )
    }

    fun availableVehiclesData(): List<AvailableVehiclesData>{
        return listOf(
            AvailableVehiclesData(
                freightType = R.string.freight_type_1,
                freightSub = R.string.freight_type_1 ,
                freightImage = R.drawable.train_feright,
            ),

            AvailableVehiclesData(
                freightType = R.string.freight_type_2,
                freightSub = R.string.freight_type_2 ,
                freightImage = R.drawable.delivery_truck,
            ),

            AvailableVehiclesData(
                freightType = R.string.freight_type_3,
                freightSub = R.string.freight_type_3 ,
                freightImage = R.drawable.train_feright,
            ),

            AvailableVehiclesData(
                freightType = R.string.freight_type_4,
                freightSub = R.string.freight_type_4 ,
                freightImage = R.drawable.delivery_truck,
            ),

            AvailableVehiclesData(
                freightType = R.string.freight_type_5,
                freightSub = R.string.freight_type_5 ,
                freightImage = R.drawable.delivery_truck,
            ),

            AvailableVehiclesData(
                freightType = R.string.freight_type_6,
                freightSub = R.string.freight_type_6 ,
                freightImage = R.drawable.delivery_truck,
            ),

            AvailableVehiclesData(
                freightType = R.string.freight_type_7,
                freightSub = R.string.freight_type_7 ,
                freightImage = R.drawable.delivery_truck,
            ),
        )
    }

}