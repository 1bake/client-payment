package kz.dar.academy.java.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentRequest {
    private String paymentId;
    private String initiatorId;
    private String executorId;
    private String description;
    private String type;

}
