/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica06.Archivo;

import java.io.File;
import java.io.IOException;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Personal
 */
public class ControladorArchivo {

    public void AbrirDirectorio(String ruta, DefaultMutableTreeNode nodoPadre) {
        File archivo = new File(ruta);
        File[] elementos = archivo.listFiles();
        if (elementos != null) {
            for (File elemento : elementos) {

                if (elemento.isDirectory()) {
                    DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(elemento.getName());
                    nodoPadre.add(nodo);
                    AbrirDirectorio(elemento.getAbsolutePath(), nodo);
                }

            }
        }
    }

    public void listarArchivosOcultos(String ruta, DefaultMutableTreeNode nodoPadre) {
        File archivo = new File(ruta);
        File[] elementos = archivo.listFiles();
        if (elementos != null) {
            for (File elemento : elementos) {

                if (elemento.isFile() && elemento.isHidden()) {

                    DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(elemento.getName());
                    nodoPadre.add(nodo);
                    listarArchivosOcultos(elemento.getAbsolutePath(), nodo);
                }

            }
        }
    }
    
    public void listarDirectoriosOcultos(String ruta, DefaultMutableTreeNode nodoPadre) {
        File archivo = new File(ruta);
        File[] elementos = archivo.listFiles();
        if (elementos != null) {
            for (File elemento : elementos) {

                if (elemento.isDirectory() && elemento.isHidden()) {

                    DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(elemento.getName());
                    nodoPadre.add(nodo);
                    listarDirectoriosOcultos(elemento.getAbsolutePath(), nodo);
                }

            }
        }
    }
      public void crearArchivo(String ruta, String nombre) {
        try {
            String file = ruta + "/" + nombre + ".txt";
            File archivo = new File(file);
            archivo.createNewFile();
           

        } catch (IOException e) {
           
        }
    }

    public void eliminarArchivo(String ruta) {

        File archivo = new File(ruta);
        if (archivo.isDirectory()) {
            File[] archivos = archivo.listFiles();
            if (archivos != null) {
                for (File ar : archivos) {
                    eliminarArchivo(ar.getAbsolutePath());
                }
            }
        }
        archivo.delete();

    }

    public void renombrarArchivo(String url, String urlren, String renombrar) {

        File archivoR = new File(urlren);
        if (archivoR.isDirectory()) {
            File archivoD = new File(url + "/" + renombrar);

            archivoR.renameTo(archivoD);
        } else if (archivoR.isFile()) {
            File archivoD = new File(url + "/" + renombrar + ".txt");

            archivoR.renameTo(archivoD);
        }
    }

    
    
}
     
    
