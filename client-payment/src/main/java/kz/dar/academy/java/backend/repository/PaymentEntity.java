package kz.dar.academy.java.backend.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "client-payment-task")
public class PaymentEntity {
    @Id
    @Field(type = FieldType.Keyword)
    private String paymentId;
    @Field(type = FieldType.Keyword)
    private String initiatorId;
    @Field(type = FieldType.Keyword)
    private String executorId;
    private String description;
    private String type;


}