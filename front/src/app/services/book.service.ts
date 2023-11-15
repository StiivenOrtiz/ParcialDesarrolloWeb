import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../types/book';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  private apiUrl = 'http://localhost:8080/api/libros'; // Ajusta la URL de tu backend

  constructor(private http: HttpClient) {}

  getAllBooks(): Observable<Book[]> {
    const url = `${this.apiUrl}/getAll`;
    return this.http.get<Book[]>(url);
  }

  createBook(book: Book): Observable<Book> {
    const url = `${this.apiUrl}/create`;
    return this.http.post<Book>(url, book);
  }

}
