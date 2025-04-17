package com.cibertec.main;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.entidad.Alumno;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ProbandoLibreriaGson {

	public static void main(String[] args) {
		// Importar control + shift + o
		Gson gson= new Gson();
		Alumno objAlumno= new Alumno("100", "juan", "perez");
		// metodos get => para obtener
		// metodos set => para modificar
		System.out.println("Codigo " + objAlumno.getCodigo()); 
		
		String cadenaJson = gson.toJson(objAlumno);
		System.out.println("Cadena Json: " + cadenaJson);
		Alumno aluConversion = gson.fromJson(cadenaJson, Alumno.class);
		System.out.println("Codigo : " + aluConversion.getCodigo());
		System.out.println("Nombre: " + aluConversion.getNombre());
		System.out.println("Apellido : "+ aluConversion.getApellido());
		
		List<Alumno> lista= new ArrayList<Alumno>();
		lista.add(new Alumno("100", "erick", "p"));
		lista.add(new Alumno("101", "benito", "g"));
		lista.add(new Alumno("102", "alex", "r"));
		String jsonLista= gson.toJson(lista);
		System.out.println(jsonLista);

		Type tipo= new TypeToken<List<Alumno>>() {}.getType();
		List<Alumno> listaFormateada= gson.fromJson(jsonLista, tipo);
		
		System.out.println(listaFormateada.get(0).getNombre());
		System.out.println(listaFormateada.get(1).getNombre());
		System.out.println(listaFormateada.get(2).getNombre());
//		for(Alumno x:listaFormateada) {
//			System.out.println("Codigo : "+ x.getCodigo() + "-Nombre:"+ x.getNombre());
//		}
		
	}
}
