// list-books.component.ts

import { Component, OnInit } from '@angular/core';
import { BookService } from '../services/book.service';
import { Book } from '../types/book';

@Component({
  selector: 'app-list-books',
  templateUrl: './list-books.component.html',
  styleUrls: ['./list-books.component.css'],
})
export class ListBooksComponent implements OnInit {
  books: Book[] = [];

  constructor(private bookService: BookService) {}

  ngOnInit() {
    this.loadBooks();
  }

  loadBooks() {
    this.bookService.getAllBooks().subscribe(
      (books) => {
        this.books = books;
        alert('Libros cargados con éxito');
      },
      (error) => {
        alert('Error al cargar los libros.');
      }
    );
  }
}
