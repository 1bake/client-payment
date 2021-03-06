package kz.dar.academy.java.backend.service;

import kz.dar.academy.java.backend.model.PaymentRequest;
import kz.dar.academy.java.backend.model.PaymentResponse;
import kz.dar.academy.java.backend.repository.PaymentEntity;
import kz.dar.academy.java.backend.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }


    @Override
    public PaymentResponse createPayment(PaymentRequest paymentRequest) {
        paymentRequest.setPaymentId(UUID.randomUUID().toString());

        PaymentEntity paymentEntity = modelMapper.map(paymentRequest, PaymentEntity.class);
        paymentEntity = paymentRepository.save(paymentEntity);

        return modelMapper.map(paymentEntity, PaymentResponse.class);
    }

    @Override
    public PaymentResponse updatePayment(PaymentRequest paymentRequest) {
        PaymentEntity paymentEntity = modelMapper.map(paymentRequest, PaymentEntity.class);

        PaymentEntity dbEntity = paymentRepository.getPaymentEntityByPaymentId(paymentRequest.getPaymentId());
        paymentEntity.setPaymentId(dbEntity.getPaymentId());

        paymentEntity = paymentRepository.save(paymentEntity);

        return modelMapper.map(paymentEntity, PaymentResponse.class);
    }

    @Override
    public Page<PaymentResponse> getAllPaymentsByExecutorId(String executorId, Pageable pageable) {
        return paymentRepository.getPaymentEntityExecutorId(executorId, pageable)
                .map(payment -> modelMapper.map(payment, PaymentResponse.class));
    }

    @Override
    public Page<PaymentResponse> getAllPaymentsByInitiatorId(String initiatorId, Pageable pageable) {
        return paymentRepository.getPaymentEntitiesByInitiatorId(initiatorId, pageable)
                .map(payment -> modelMapper.map(payment, PaymentResponse.class));
    }


    @Override
    public void deletePaymentById(String paymentId) {

        paymentRepository.deletePaymentEntityByPaymentId(paymentId);
    }


    @Override
    public PaymentResponse getPaymentById(String paymentId) {
        PaymentEntity paymentEntity = paymentRepository.getPaymentEntityByPaymentId(paymentId);
        return modelMapper.map(paymentEntity, PaymentResponse.class);
    }



}
