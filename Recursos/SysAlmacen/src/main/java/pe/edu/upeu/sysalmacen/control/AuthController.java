package pe.edu.upeu.sysalmacen.control;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.sysalmacen.dtos.UsuarioDTO;
import pe.edu.upeu.sysalmacen.security.JwtTokenUtil;
import pe.edu.upeu.sysalmacen.security.JwtUserDetailsService;
import pe.edu.upeu.sysalmacen.servicio.IUsuarioService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class AuthController {

    private final IUsuarioService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService jwtUserDetailsService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody @Valid UsuarioDTO.CredencialesDto credentialsDto, HttpServletRequest request) {
        UsuarioDTO userDto = userService.login(credentialsDto);
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(credentialsDto.user());
        userDto.setToken(jwtTokenUtil.generateToken(userDetails));
        request.getSession().setAttribute("USER_SESSION", userDto.getUser());
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> register(@RequestBody @Valid UsuarioDTO.UsuarioCrearDto user) {
       
        UsuarioDTO userDto = userService.register(user);
        
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(userDto.getUser());
        userDto.setToken(jwtTokenUtil.generateToken(userDetails));

        return ResponseEntity.ok(userDto); 
    }
}
