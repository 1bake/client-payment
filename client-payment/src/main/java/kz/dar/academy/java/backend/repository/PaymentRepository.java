package kz.dar.academy.java.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends ElasticsearchRepository<PaymentEntity, String> {


    Page<PaymentEntity> getPaymentEntitiesByType(String type, Pageable pageable);

    PaymentEntity getPaymentEntityByPaymentId(String paymentId);

    PaymentEntity deletePaymentEntityByPaymentId(String paymentId);

    Page<PaymentEntity> getPaymentEntitiesByInitiatorId(String initiatorId, Pageable pageable);

    Page<PaymentEntity> getPaymentEntityExecutorId(String executorId, Pageable pageable);

}
