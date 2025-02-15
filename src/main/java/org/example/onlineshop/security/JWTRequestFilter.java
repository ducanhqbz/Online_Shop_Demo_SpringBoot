    package org.example.onlineshop.security;

    import io.jsonwebtoken.ExpiredJwtException;
    import jakarta.servlet.FilterChain;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import lombok.AccessLevel;
    import lombok.RequiredArgsConstructor;
    import lombok.experimental.FieldDefaults;
    import org.example.onlineshop.entity.Account;
    import org.example.onlineshop.entity.TokenPayLoad;
    import org.example.onlineshop.repository.AccountRepository;
    import org.example.onlineshop.util.JwtTokenUtil;

    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.stereotype.Component;
    import org.springframework.web.filter.OncePerRequestFilter;

    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;

    @Component
    @RequiredArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public class JWTRequestFilter extends OncePerRequestFilter {
        JwtTokenUtil jwtTokenUtil;
        AccountRepository accountRepository;


        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            String requestTokenHeader = request.getHeader("Authorization");
            String token = null;
            TokenPayLoad tokenPayLoad = null;
            System.out.println(requestTokenHeader);
            String requestPath = request.getServletPath();
            System.out.println(requestPath);
            // Nếu requestPath là /CreateNew, bỏ qua JWT filter
            if ("/api/v1/CreateNew".equals(requestPath) || "/api/v1/login".equals(requestPath)) {
                filterChain.doFilter(request, response);
                return;
            }
            if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer")) {
                token = requestTokenHeader.split(" ")[1];
                System.out.println(token);
                try {
                    tokenPayLoad = jwtTokenUtil.getTokenPayload(token);
                    System.out.println(tokenPayLoad);
                } catch (ExpiredJwtException e) {

                    System.out.println("Token is expired");
                }

            } else {
                System.out.println("not start with bearer token");

            }

            if (tokenPayLoad != null ) {
                Account account = accountRepository.findById(tokenPayLoad.getAccountId());
                if (account != null) {
                    if (jwtTokenUtil.isValid(token, tokenPayLoad)) {
                        List<SimpleGrantedAuthority> listauthorites = new ArrayList<>();

                        UserDetails userDetails = new User(account.getUsername(), account.getPassword(),listauthorites);
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,listauthorites);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        System.out.println(userDetails);
                    }
                }
            } filterChain.doFilter(request, response);
        }

    }
