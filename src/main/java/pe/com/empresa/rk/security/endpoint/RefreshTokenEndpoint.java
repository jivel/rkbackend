package pe.com.empresa.rk.security.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.com.empresa.rk.domain.model.entities.Usuario;
import pe.com.empresa.rk.security.auth.jwt.extractor.TokenExtractor;
import pe.com.empresa.rk.security.config.JwtSettings;
import pe.com.empresa.rk.security.config.WebSecurityConfig;
import pe.com.empresa.rk.security.exceptions.InvalidJwtToken;
import pe.com.empresa.rk.security.model.token.JwtToken;
import pe.com.empresa.rk.security.model.token.JwtTokenFactory;
import pe.com.empresa.rk.security.model.token.RawAccessJwtToken;
import pe.com.empresa.rk.security.model.token.RefreshToken;
import pe.com.empresa.rk.security.UserService;
import pe.com.empresa.rk.security.auth.jwt.verifier.TokenVerifier;
import pe.com.empresa.rk.security.model.UserContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by josediaz on 23/11/2016.
 */
@RestController
public class RefreshTokenEndpoint {
    @Autowired
    private JwtTokenFactory tokenFactory;
    @Autowired private JwtSettings jwtSettings;
    @Autowired private UserService userService;
    @Autowired private TokenVerifier tokenVerifier;
    @Autowired @Qualifier("jwtHeaderTokenExtractor") private TokenExtractor tokenExtractor;

    @RequestMapping(value="/api/auth/token", method= RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody
    JwtToken refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tokenPayload = tokenExtractor.extract(request.getHeader(WebSecurityConfig.JWT_TOKEN_HEADER_PARAM));

        RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(rawToken, jwtSettings.getTokenSigningKey()).orElseThrow(() -> new InvalidJwtToken());

        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new InvalidJwtToken();
        }

        String subject = refreshToken.getSubject();
        Usuario user = userService.getByUsername(subject).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + subject));

        if (user.getRoles() == null) throw new InsufficientAuthenticationException("El Usuario no tiene roles asignados");
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRol().authority()))
                .collect(Collectors.toList());

        UserContext userContext = UserContext.create(user.getIdUsuario(), authorities);

        return tokenFactory.createAccessJwtToken(userContext);
    }
}