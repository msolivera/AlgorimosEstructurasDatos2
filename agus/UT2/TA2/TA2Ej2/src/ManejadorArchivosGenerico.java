/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase ManejadorArchivo - contiene los métodos genéricos para lectura y escritura de archivos
 * @author Fernando Scocozza
 */
public class ManejadorArchivosGenerico {
    
    /**
    * Método para escribir en archivo
    * @param nombreCompletoArchivo
    * @param listaLineasArchivo
    */
    public static void escribirArchivo(String nombreCompletoArchivo, String[] listaLineasArchivo) {
            FileWriter fw;
            try {
                    fw = new FileWriter(nombreCompletoArchivo, false);
                    BufferedWriter bw = new BufferedWriter(fw);
                    for (int i = 0; i < listaLineasArchivo.length; i++) {
                            String lineaActual = listaLineasArchivo[i];
                            //UcuPharma.mostrar(lineaActual);
                            bw.write(lineaActual);
                            bw.newLine();
                    }
                    bw.close();
                    fw.close();
            } catch (IOException e) {
                    System.out.println("Error al escribir el archivo "
                                    + nombreCompletoArchivo);
                    e.printStackTrace();
            }
    }
        
    /**
     * Método para escribir una única línea en un archivo dado
     * @param nombreCompletoArchivo - String con el nombre del archivo
     * @param linea - String con linea a agregr al archivo
     */
    public static void escribirLineaArchivo(String nombreCompletoArchivo, String linea) {
		FileWriter fw;
		try {
			fw = new FileWriter(nombreCompletoArchivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
                        bw.newLine();
                        bw.write(linea);
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo "
					+ nombreCompletoArchivo);
			e.printStackTrace();
		}
	}

    /**
     * Método para leer la información de un archivo y pasarla a un Array de String
     * @param nombreCompletoArchivo - String con nombre de archivo
     * @return - Array de String con el contenido del archivo
     */
    public static String[] leerArchivo(String nombreCompletoArchivo) {
		FileReader fr;
		ArrayList<String> listaLineasArchivo = new ArrayList<String>();
		try {
			fr = new FileReader(nombreCompletoArchivo);
			BufferedReader br = new BufferedReader(fr);
			String lineaActual = br.readLine();
			while (lineaActual != null) {
				listaLineasArchivo.add(lineaActual);
				lineaActual = br.readLine();
			}
			br.close();
            fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el archivo "
					+ nombreCompletoArchivo);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo "
					+ nombreCompletoArchivo);
			e.printStackTrace();
		}
		//System.out.println("Archivo leido satisfactoriamente");
		return listaLineasArchivo.toArray(new String[0]);
	}
    
}
