package tz.co.vodacom.bujikun.sportyshoes.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReportDTO {
    private Integer orderId;
    private LocalDate createdOn;
    private String username;
}
