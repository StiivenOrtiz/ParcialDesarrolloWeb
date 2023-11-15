import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AddLibraryComponent } from './add-library/add-library.component';
import { AddBookComponent } from './add-book/add-book.component';
import { ListLibrariesComponent } from './list-libraries/list-libraries.component';
import { ListBooksComponent } from './list-books/list-books.component';

const routes: Routes = [
  { path: 'add-library', component: AddLibraryComponent },
  { path: 'add-book', component: AddBookComponent },
  { path: 'list-libraries', component: ListLibrariesComponent },
  { path: 'list-books', component: ListBooksComponent },
  { path: '', redirectTo: '/add-library', pathMatch: 'full' }, // Ruta por defecto
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
