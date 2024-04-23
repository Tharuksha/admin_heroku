package com.nsbm.ebookstore.login.Service;
import com.nsbm.ebookstore.login.Dto.ReqRes;
import com.nsbm.ebookstore.login.Entity.Users;
import com.nsbm.ebookstore.login.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashMap;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public ReqRes signUp(ReqRes registrationRequest){
        ReqRes resp = new ReqRes();
        try {
            if (userRepository.existsByEmail(registrationRequest.getEmail())) {
                resp.setStatusCode(400);
                resp.setMessage("User with this email already registered");
                return resp;
            }

            Users ausers = new Users();
            ausers.setEmail(registrationRequest.getEmail());
            ausers.setFirstname((registrationRequest.getFirstname()));
            ausers.setLastname((registrationRequest.getLastname()));
            ausers.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            ausers.setRole(registrationRequest.getRole());
            Users UserResult = userRepository.save(ausers);
            if (UserResult.getUserid() > 0) {
                resp.setUsers(UserResult);
                resp.setMessage("User Saved Successfully");
                resp.setStatusCode(200);
            }
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }

    public ReqRes signIn(ReqRes signingRequest){
        ReqRes response = new ReqRes();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signingRequest.getEmail(),signingRequest.getPassword()));
            var user = userRepository.findByEmail(signingRequest.getEmail()).orElseThrow();
            System.out.println("USER IS: "+ user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setUserid(user.getUserid());
            response.setFirstname(user.getFirstname());
            response.setLastname(user.getLastname());
            response.setExpirationTime("24Hr");
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setRole(user.getRole());
            response.setMessage("Successfully Signed In");
        }catch (Exception e){
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }
    public ReqRes refreshToken(ReqRes refreshTokenRequest){
        ReqRes response = new ReqRes();
        String ourEmail = jwtUtils.extractUsername(refreshTokenRequest.getToken());
        Users users = userRepository.findByEmail(ourEmail).orElseThrow();
        if (jwtUtils.isTokenValid(refreshTokenRequest.getToken(), users)) {
            var jwt = jwtUtils.generateToken(users);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenRequest.getToken());
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Refreshed Token");
        }
        response.setStatusCode(500);
        return response;
    }
}
