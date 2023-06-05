package tz.co.vodacom.bujikun.kitchenstories.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.kitchenstories.dto.PasswordChangeDTO;
import tz.co.vodacom.bujikun.kitchenstories.entity.Food;
import tz.co.vodacom.bujikun.kitchenstories.repository.FoodRepository;
import tz.co.vodacom.bujikun.kitchenstories.repository.UserRepository;
import tz.co.vodacom.bujikun.kitchenstories.util.DateUtil;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final DateUtil dateUtil;
    private final PasswordEncoder passwordEncoder;

    public void changePassword(PasswordChangeDTO passwordChangeDTO) {
        var user = userRepository.findUserByUsername(passwordChangeDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("Bad request"));
        if (!(passwordEncoder.matches(passwordChangeDTO.getOldPassword(),user.getPassword()))) {
            throw new RuntimeException("Bad Request");
        }

        user.setUpdatedOn(dateUtil.now());
        //user.setVersion(user.getVersion() + 1);
        user.setPassword(passwordEncoder.encode(passwordChangeDTO.getNewPassword()));
        userRepository.save(user);
    }
}
