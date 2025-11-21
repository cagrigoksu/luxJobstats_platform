using AuthService.Data;
using AuthService.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;

namespace AuthService.Controllers;


[Route("auth")]
[ApiController]
public class AuthController : ControllerBase
{
    private readonly UserManager<User> _userManager;
    private readonly SignInManager<User> _signInManager;

    private readonly JwtService _jwtService;

    public AuthController(
        UserManager<User> userManager,
        SignInManager<User> signInManager,
        JwtService jwtService)
    {
        _userManager = userManager;
        _signInManager = signInManager;
        _jwtService = jwtService;
    }

    [HttpPost("register")]
    public async Task<IActionResult> Register(RegisterDto dto)
    {
        var user = new User
        {
            UserName = dto.Email,
            Email = dto.Email
        };

        var result = await _userManager.CreateAsync(user, dto.Password);

        if (!result.Succeeded)
            return BadRequest(result.Errors);

        return Ok(new { message = "User registered." });
    }

    [HttpPost("login")]
    public async Task<IActionResult> Login(LoginDto dto)
    {
        var user = await _userManager.FindByEmailAsync(dto.Email);

        if (user == null)
            return Unauthorized(new { message = "Invalid login" });

        var passwordCheck = await _signInManager.CheckPasswordSignInAsync(user, dto.Password, false);

        if (!passwordCheck.Succeeded)
            return Unauthorized(new { message = "Invalid password" });

        var token = _jwtService.GenerateToken(user);

        return Ok(new
        {
            message = "Login successful",
            accessToken = token
        });
    }

}

public record RegisterDto(string Email, string Password);
public record LoginDto(string Email, string Password);

