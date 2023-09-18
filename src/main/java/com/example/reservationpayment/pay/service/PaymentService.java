package com.example.reservationpayment.pay.service;



import com.example.reservationpayment.pay.client.api.CustomerClient;
import com.example.reservationpayment.pay.client.api.OrderCommandClient;
import com.example.reservationpayment.pay.client.api.RoomClient;
import com.example.reservationpayment.pay.client.request.OrderRequest;
import com.example.reservationpayment.pay.config.TokenInfo;
import com.example.reservationpayment.pay.domain.dto.Customer;
import com.example.reservationpayment.pay.domain.dto.Room;
import com.example.reservationpayment.pay.domain.entity.Payment;
import com.example.reservationpayment.pay.domain.request.PaymentRequest;
import com.example.reservationpayment.pay.domain.response.PaymentResponse;
import com.example.reservationpayment.pay.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final CustomerClient customerClient;
    private final RoomClient roomClient;
    private final OrderCommandClient orderCommandClient;
//  내꺼 보는거

    public PaymentResponse getByCustomerId(TokenInfo info) {
        Optional<Payment> optionalPayment = paymentRepository.findById(info.getId());

        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            List<PaymentResponse> responseList = getPaymentResponseList(Arrays.asList(payment));

            if (!responseList.isEmpty()) {
                return responseList.get(0);
            } else {
                throw new NoSuchElementException("ERR");
            }
        } else {
            throw new NoSuchElementException("ERR");
        }
    }


    //  전체 결제내역 보는거
    public List<PaymentResponse> getAll(){
        List<Payment> all = paymentRepository.findAll();
        return getPaymentResponseList(all);
    }

    private List<PaymentResponse> getPaymentResponseList(List<Payment> all) {
        Map<UUID, Customer> customerMap = new HashMap<>();

        return all.stream().map(payment -> {
            Customer customer = customerMap.computeIfAbsent(
                    payment.getCustomerId(),
                    id -> customerClient.getById(id.toString())
            );

            List<UUID> roomIds = Arrays.stream(payment.getRoomId().toString().split(","))
                    .map(UUID::fromString)
                    .collect(Collectors.toList());

            List<Room> rooms = roomClient.getAllByIds(roomIds);

            UUID roomId = rooms.get(0).getRoomId();

            return new PaymentResponse(payment, roomId, customer.getId());
        }).toList();
    }


    //  등록하는 것
    public void save(PaymentRequest request, TokenInfo tokenInfo){
        Payment save = paymentRepository.save(request.toEntity(tokenInfo));
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setPrice(save.getPrice());
        orderRequest.setPNumber(save.getPNumber());
        orderRequest.setAmenityId(save.getAmenityId());
        orderRequest.setCustomerId(save.getCustomerId());
        orderCommandClient.save(orderRequest);
    }
}
