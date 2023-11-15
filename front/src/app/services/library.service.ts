import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Library } from '../types/library';

@Injectable({
  providedIn: 'root',
})
export class LibraryService {
  private apiUrl = 'http://localhost:8080/api/bibliotecas'; // Ajusta la URL de tu backend

  constructor(private http: HttpClient) {}

  getAllLibraries(): Observable<Library[]> {
    const url = `${this.apiUrl}/getAll`;
    return this.http.get<Library[]>(url);
  }

  createLibrary(library: Library): Observable<Library> {
    const url = `${this.apiUrl}/create`;
    return this.http.post<Library>(url, library);
  }

}
