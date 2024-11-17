package auth;

import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.jwt.auth.principal.DefaultJWTCallerPrincipal;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.json.JsonString;
import lombok.extern.slf4j.Slf4j;

import java.security.Principal;
import java.util.*;

@RequestScoped
@Slf4j
public class AuthService {
    @Inject
    SecurityIdentity securityIdentity;

    public Principal getPrincipal(){
        return securityIdentity.getPrincipal();
    }

    public List<String> getRoles(){
        return securityIdentity.getRoles().stream().toList();
    }

    private Map<String,Object> getAvailableClaims(){
        Map<String, Object> claims = new HashMap<>();
        DefaultJWTCallerPrincipal defaultJWTCallerPrincipal = (DefaultJWTCallerPrincipal)getPrincipal();
        defaultJWTCallerPrincipal
                .getClaimNames()
                .forEach(claimName -> claims.put(claimName, defaultJWTCallerPrincipal.getClaim(claimName)));
        return claims;
    }

    public ClaimDto getClaimDto(){
        Map<String, Object> claims = getAvailableClaims();
        String email = null;
        Object claimsObj = claims.get(UserClaims.EMAIL.getClaimKey());
        if (claimsObj instanceof List<?> list) {
            if (list.getFirst() instanceof JsonString jsonString) {
                email = jsonString.getString();
            }
        }

        return ClaimDto.builder()
                .email(email)
                .objectId(Objects.toString(claims.get(UserClaims.OBJECT_ID.getClaimKey()), null))
                .country(Objects.toString(claims.get(UserClaims.COUNTRY.getClaimKey()), null))
                .scope(Objects.toString(claims.get(UserClaims.SCOPE.getClaimKey()), null))
                .city(Objects.toString(claims.get(UserClaims.CITY.getClaimKey()), null))
                .token(Objects.toString(claims.get(UserClaims.TOKEN.getClaimKey()), null))
                .jobTitle(Objects.toString(claims.get(UserClaims.JOB_TITLE.getClaimKey()), null))
                .postalCode(Objects.toString(claims.get(UserClaims.POSTAL_CODE.getClaimKey()), null))
                .givenName(Objects.toString(claims.get(UserClaims.GIVEN_NAME.getClaimKey()), null))
                .name(Objects.toString(claims.get(UserClaims.NAME.getClaimKey()), null))
                .state(Objects.toString(claims.get(UserClaims.STATE.getClaimKey()), null))
                .familyName(Objects.toString(claims.get(UserClaims.FAMILY_NAME.getClaimKey()), null))
                .scope(Objects.toString(claims.get(UserClaims.SCOPE.getClaimKey()), null))
                .build();
    }


}
