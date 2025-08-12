package com.zutjmx.curso.springboot.jpa.relaciones;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zutjmx.curso.springboot.jpa.relaciones.entities.Cliente;
import com.zutjmx.curso.springboot.jpa.relaciones.entities.Factura;
import com.zutjmx.curso.springboot.jpa.relaciones.repositories.ClienteRepository;
import com.zutjmx.curso.springboot.jpa.relaciones.repositories.FacturaRepository;
import com.zutjmx.curso.springboot.jpa.relaciones.util.FakeData;

@SpringBootApplication
public class RelacionesApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private FacturaRepository facturaRepository;

	@Autowired
	private FakeData fakeData;

	public static void main(String[] args) {
		SpringApplication.run(RelacionesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// This method can be used to execute code after the application has started
		
		System.out.println("Opciones de la aplicación:");
		System.out.println("1 .- ManyToOne");
		System.out.println("2 .- ManyToOneFindByIdCliente");

		Scanner	scanner = new Scanner(System.in);
		System.out.println("Selecciona una opción:");
		int opcion = scanner.nextInt();
		scanner.close();

		switch (opcion) {
			case 1:
				System.out.println("Has seleccionado ManyToOne");
				manyToOne();
				break;
			case 2:
				System.out.println("Has seleccionado ManyToOneFindByIdCliente");
				manyToOneFindByIdCliente();
				break;
			default:
				System.out.println("Opción no válida");
				break;
		}
		
	}

	public void manyToOne() {
		// Implementación de la lógica ManyToOne
		Cliente cliente = fakeData.crearClienteFalso();
		clienteRepository.save(cliente);

		Factura factura = fakeData.crearFacturaFalsa(cliente);
		Factura facturaGuardada = facturaRepository.save(factura);

		System.out.println(facturaGuardada);
		System.out.println("Lógica ManyToOne ejecutada");
	}

	public void manyToOneFindByIdCliente() {
		// Implementación de la lógica ManyToOne
		Cliente cliente = clienteRepository.findById(1L)
				.orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
		System.out.println("Cliente encontrado: " + cliente);

		Factura factura = fakeData.crearFacturaFalsa(cliente);
		Factura facturaGuardada = facturaRepository.save(factura);

		System.out.println(facturaGuardada);
		System.out.println("Lógica ManyToOneFindByIdCliente ejecutada");
	}

	public void manyToMany() {
		// Implementación de la lógica ManyToMany
		System.out.println("Lógica ManyToMany aún no implementada");
		// Aquí puedes agregar la lógica para ManyToMany
		System.out.println("Lógica ManyToMany ejecutada");
	}

}
