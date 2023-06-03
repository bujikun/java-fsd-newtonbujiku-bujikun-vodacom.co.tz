package tz.co.vodacom.bujikun.kitchenstories.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class LoginDTO {
    private String username;
    private String password;

}
