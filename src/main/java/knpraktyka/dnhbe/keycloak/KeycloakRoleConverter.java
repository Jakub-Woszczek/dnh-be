package knpraktyka.dnhbe.keycloak;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.BadJwtException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/// Reads roles from Jwt and converts them to SpringBoot authority
public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        // Keycloak gives list of roles in realm_access
        Map<String, Object> realmAccess = jwt.getClaim("realm_access");

        if (realmAccess == null || realmAccess.isEmpty()) {
            return List.of();
        }

        Object rolesObj = realmAccess.get("roles");
        if (rolesObj instanceof List<?> rolesList) {
            return rolesList.stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList());
        } else {
            // Malformed JWT from Keycloak (shouldn't ever happen)
            throw new BadJwtException("Invalid JWT");
        }

    }
}
