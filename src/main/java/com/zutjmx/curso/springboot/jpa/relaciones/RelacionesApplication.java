package com.zutjmx.curso.springboot.jpa.relaciones;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.zutjmx.curso.springboot.jpa.relaciones.entities.Adress;
import com.zutjmx.curso.springboot.jpa.relaciones.entities.Cliente;
import com.zutjmx.curso.springboot.jpa.relaciones.entities.Direccion;
import com.zutjmx.curso.springboot.jpa.relaciones.entities.Factura;
import com.zutjmx.curso.springboot.jpa.relaciones.entities.Persona;
import com.zutjmx.curso.springboot.jpa.relaciones.entities.Telefono;
import com.zutjmx.curso.springboot.jpa.relaciones.repositories.ClienteRepository;
import com.zutjmx.curso.springboot.jpa.relaciones.repositories.DireccionRepository;
import com.zutjmx.curso.springboot.jpa.relaciones.repositories.FacturaRepository;
import com.zutjmx.curso.springboot.jpa.relaciones.repositories.PersonaRepository;
import com.zutjmx.curso.springboot.jpa.relaciones.util.FakeData;

@SpringBootApplication
public class RelacionesApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private FacturaRepository facturaRepository;

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private DireccionRepository direccionRepository;

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
		System.out.println("3 .- Crea Persona y Dirección");
		System.out.println("4 .- Crea Dirección de una Persona");
		System.out.println("5 .- OneToMany");
		System.out.println("6 .- Guarda Cliente y Teléfonos");

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
			case 3:
				System.out.println("Has seleccionado Crea Persona y Dirección");
				creaPersonaYDireccion();
				break;
			case 4:
				System.out.println("Has seleccionado Crea Dirección de una Persona");
				creaDireccion();
				break;
			case 5:
				System.out.println("Has seleccionado OneToMany");
				oneToMany();
				break;
			case 6:
				System.out.println("Has seleccionado Guarda Cliente y Teléfonos");
				guardaClienteYTelefonos();
				break;
			default:
				System.out.println("Opción no válida");
				break;
		}
		
	}

	@Transactional
	public void creaDireccion() {
		Long idPersona = fakeData.generaIdClienteAleatorio();
		System.out.println("ID de persona generado aleatoriamente: " + idPersona);
		Persona persona = personaRepository.findById(idPersona)
				.orElseThrow(() -> new RuntimeException("Persona no encontrada: " + idPersona));
		System.out.println("Persona encontrada: " + persona);
		Direccion direccion = fakeData.getDireccion(persona);
		Direccion direccionGuardada = direccionRepository.save(direccion);
		System.out.println("Dirección guardada: " + direccionGuardada);
		System.out.println("Lógica creaDirección ejecutada");
	}

	@Transactional
	public void creaPersonaYDireccion() {
		Persona persona = fakeData.getPersona();
		personaRepository.save(persona);
		System.out.println("Persona guardada: " + persona);
		Direccion direccion = fakeData.getDireccion(persona);
		direccionRepository.save(direccion);
		System.out.println("Dirección guardada: " + direccion);		
		System.out.println("Lógica creaPersonaYDireccion ejecutada");
	}

	@Transactional
	public void manyToOne() {
		// Implementación de la lógica ManyToOne
		Cliente cliente = fakeData.crearClienteFalso();
		clienteRepository.save(cliente);

		Factura factura = fakeData.crearFacturaFalsa(cliente);
		Factura facturaGuardada = facturaRepository.save(factura);

		System.out.println(facturaGuardada);
		System.out.println("Lógica ManyToOne ejecutada");
	}

	@Transactional
	public void manyToOneFindByIdCliente() {
		// Implementación de la lógica ManyToOne
		Long idCliente = fakeData.generaIdClienteAleatorio();
		System.out.println("ID de cliente generado aleatoriamente: " + idCliente);
		Cliente cliente = clienteRepository.findById(idCliente)
				.orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + idCliente));
		System.out.println("Cliente encontrado: " + cliente);

		Factura factura = fakeData.crearFacturaFalsa(cliente);
		Factura facturaGuardada = facturaRepository.save(factura);

		System.out.println(facturaGuardada);
		System.out.println("Lógica ManyToOneFindByIdCliente ejecutada");
	}

	@Transactional
	public void oneToMany() {
		Cliente cliente = fakeData.crearClienteFalso();
		List<Adress> adresses = fakeData.getAdresses(5);
		cliente.setAdresses(adresses);				
		Cliente clienteGuardado = clienteRepository.save(cliente);
		System.out.println("Cliente guardado: " + clienteGuardado);
		System.out.println("Lógica ManyToMany ejecutada");
	}

	@Transactional
	public void guardaClienteYTelefonos() {
		Cliente cliente = fakeData.crearClienteFalso();
		List<Telefono> telefonos = fakeData.getTelefonos(5);
		cliente.setTelefonos(telefonos);
		Cliente clienteGuardado = clienteRepository.save(cliente);
		System.out.println("Cliente guardado: " + clienteGuardado);
		System.out.println("Lógica guardaClienteYTelefonos ejecutada");
	}

}
