// list-libraries.component.ts

import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../services/library.service';
import { Library } from '../types/library';

@Component({
  selector: 'app-list-libraries',
  templateUrl: './list-libraries.component.html',
  styleUrls: ['./list-libraries.component.css'],
})
export class ListLibrariesComponent implements OnInit {
  libraries: Library[] = [];

  constructor(private libraryService: LibraryService) {}

  ngOnInit() {
    this.loadLibraries();
  }

  loadLibraries() {
    this.libraryService.getAllLibraries().subscribe(
      (libraries) => {
        this.libraries = libraries;
        console.log('Bibliotecas cargadas con éxito:', libraries);
      },
      (error) => {
        console.error('Error al cargar las bibliotecas:', error);
      }
    );
  }
}
