package com.example.reservationpayment.pay.client.api;


import com.example.reservationpayment.pay.domain.dto.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient("ROOM-SERVICE")
public interface RoomClient {
    @GetMapping("/api/v1/room/ids")
    List<Room> getAllByIds(
            @RequestParam(name = "ids") List<UUID> ids);
}
