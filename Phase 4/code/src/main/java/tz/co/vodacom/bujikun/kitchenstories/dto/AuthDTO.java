package tz.co.vodacom.bujikun.kitchenstories.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class AuthDTO {
    private String username;
    private String password;

}
