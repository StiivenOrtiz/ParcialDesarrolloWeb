// add-book.component.ts

import { Component } from '@angular/core';
import { BookService } from '../services/book.service';
import { Book } from '../types/book';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css'],
})
export class AddBookComponent {
  newBook : Book = {
    nombre:'',
    autor:'',
    bibliotecaId: -1
  };

  constructor(private bookService: BookService) {}

  onSubmit() {
    this.bookService.createBook(this.newBook).subscribe(
      (response) => {
        alert("Libro agregado con éxito.")
        // Limpiar el formulario o realizar otras acciones después de agregar el libro
        this.newBook = {
          nombre:'',
          autor:'',
          bibliotecaId: -1
        };
      },
      (error) => {
        alert("No se pudo agregar el libro.")
      }
    );
  }
}
