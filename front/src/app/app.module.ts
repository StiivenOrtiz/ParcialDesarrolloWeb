import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddLibraryComponent } from './add-library/add-library.component';
import { AddBookComponent } from './add-book/add-book.component';
import { ListLibrariesComponent } from './list-libraries/list-libraries.component';
import { ListBooksComponent } from './list-books/list-books.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    AddLibraryComponent,
    AddBookComponent,
    ListLibrariesComponent,
    ListBooksComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
