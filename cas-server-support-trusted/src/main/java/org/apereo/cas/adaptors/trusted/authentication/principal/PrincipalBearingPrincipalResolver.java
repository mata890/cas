package org.apereo.cas.adaptors.trusted.authentication.principal;

import org.apereo.cas.authentication.Credential;
import org.apereo.cas.authentication.principal.PersonDirectoryPrincipalResolver;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Extracts the Principal out of PrincipalBearingCredential. It is very simple
 * to resolve PrincipalBearingCredential to a Principal since the credentials
 * already bear the ready-to-go Principal.
 *
 * @author Andrew Petro
 * @since 3.0.0
 */
@RefreshScope
@Component("trustedPrincipalResolver")
public class PrincipalBearingPrincipalResolver extends PersonDirectoryPrincipalResolver {

    @Override
    protected String extractPrincipalId(final Credential credential) {
        return ((PrincipalBearingCredential) credential).getPrincipal().getId();
    }

    @Override
    public boolean supports(final Credential credential) {
        return credential instanceof PrincipalBearingCredential;
    }
}
