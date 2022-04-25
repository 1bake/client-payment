package kz.dar.academy.java.backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentResponse {

    private String paymentId;
    private String initiatorId;
    private String executorId;
    private String description;
    private String type;

}
