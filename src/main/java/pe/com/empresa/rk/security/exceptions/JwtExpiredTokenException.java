package pe.com.empresa.rk.security.exceptions;

import org.springframework.security.core.AuthenticationException;
import pe.com.empresa.rk.security.model.token.JwtToken;

/**
 * Created by josediaz on 23/11/2016.
 */
public class JwtExpiredTokenException extends AuthenticationException {
    private static final long serialVersionUID = -5959543783324224864L;

    private JwtToken token;

    public JwtExpiredTokenException(String msg) {
        super(msg);
    }

    public JwtExpiredTokenException(JwtToken token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String token() {
        return this.token.getToken();
    }
}
