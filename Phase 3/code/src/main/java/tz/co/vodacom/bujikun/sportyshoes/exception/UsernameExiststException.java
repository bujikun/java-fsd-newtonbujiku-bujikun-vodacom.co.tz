package tz.co.vodacom.bujikun.sportyshoes.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tz.co.vodacom.bujikun.sportyshoes.entity.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsernameExiststException extends RuntimeException{
    private  String message;
    private User user;
}

