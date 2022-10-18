package com.example.Ejercicio1ApiLibros.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ejercicio1ApiLibros.utils.MessageResponseDto;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/email")
@Tag(name="Controlador de Email")
public class EmailController {
	
	@Autowired
	private EmailService emailS;

	@PostMapping("/send")
	public void sendEmail(@RequestBody Email email) {
		emailS.sendEmail(email);
	}
}
