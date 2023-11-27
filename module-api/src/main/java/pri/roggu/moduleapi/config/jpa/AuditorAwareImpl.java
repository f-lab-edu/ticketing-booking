package pri.roggu.moduleapi.config.jpa;

import org.springframework.data.domain.AuditorAware;


import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if(ObjectUtils.isEmpty(authentication) || !authentication.isAuthenticated()){
//            return Optional.empty();
//        }

        //return Optional.of(((UserDetails) authentication.getPrincipal()).getUsername());
        return Optional.of("관리자");
    }

}
