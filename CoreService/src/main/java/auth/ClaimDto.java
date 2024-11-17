package auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
public class ClaimDto implements Serializable {
    private String objectId;
    private String email;
    private String country;
    private String scope;
    private String city;
    private String token;
    private String jobTitle;
    private String postalCode;
    private String issuer;
    private String givenName;
    private String name;
    private String state;
    private String familyName;

}

