package kz.dar.academy.java.backend.service;

import kz.dar.academy.java.backend.model.PaymentRequest;
import kz.dar.academy.java.backend.model.PaymentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentService {
    PaymentResponse createPayment(PaymentRequest paymentRequest);

    PaymentResponse updatePayment(PaymentRequest paymentRequest);

    Page<PaymentResponse> getAllPaymentsByExecutorId(String executorId, Pageable pageable);

    Page<PaymentResponse> getAllPaymentsByInitiatorId(String initiatorId, Pageable pageable);

    PaymentResponse getPaymentById(String paymentId);

    void deletePaymentById(String paymentId);


}
