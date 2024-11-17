package auth;

public enum UserClaims {
    EMAIL("emails"),
    COUNTRY("country"),
    SCOPE("scp"),
    CITY("city"),
    TOKEN("raw_token"),
    JOB_TITLE("jobTitle"),
    POSTAL_CODE("postalCode"),
    ISSUER("iss"),
    OBJECT_ID("oid"),
    GIVEN_NAME("given_name"),
    EMAILS("emails"),
    AUDIENCE("aud"),
    NOT_BEFORE("nbf"),
    AUTHORIZED_PARTY("azp"),
    NAME("name"),
    STATE("state"),
    EXPIRATION("exp"),
    FAMILY_NAME("family_name"),
    ISSUED_AT("iat"),
    TRUST_FRAMEWORK_POLICY("tfp");

    private final String claimKey;

    UserClaims(String claimKey) {
        this.claimKey = claimKey;
    }

    public String getClaimKey() {
        return claimKey;
    }
}

