import { Component } from '@angular/core';
import { Library } from '../types/library';
import { LibraryService } from '../services/library.service';

@Component({
  selector: 'app-add-library',
  templateUrl: './add-library.component.html',
  styleUrls: ['./add-library.component.css'],
})
export class AddLibraryComponent {
  newLibrary: Library = {
    nombre: '',
    direccion: '',
    ciudad: '',
  };

  constructor(private libraryService: LibraryService) {}

  onSubmit() {
    
    // verificar de que no este nulos los valores
    if (this.newLibrary.nombre == '' || this.newLibrary.direccion == '' || this.newLibrary.ciudad == '') {
      alert('Todos los campos son requeridos');
      return;
    }


    // Lógica para enviar la nueva biblioteca al servicio
    this.libraryService.createLibrary(this.newLibrary).subscribe(
      (response) => {
        // lanzar un mensaje de que fue creado correctamente
        alert('Biblioteca agregada');
        // Limpiar 
        this.newLibrary = {
          nombre: '',
          direccion: '',
          ciudad: '',
        };
      },
      (error) => {
        alert("Error al agregar la biblioteca.")
      }
    );
  }
}